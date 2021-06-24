package chenyuan.langex.book.jvm.gc;

public class MemoryAllocation {
    private static final int _1MB = 1024 * 1024;

    private static void info(String info) {
        System.out.println("[info] " + info);
    }

    /**
     * VM OPTS: -verbose:gc -Xms20M -Xmx20M -Xmn10M -XX:+printGCDetails -XX:SurvivorRatio=8
     * -XX PreternureSizeThreshold=3145728
     *  Only used in Serial or ParNew
     */
    public static void testPretenureSizeThreshold() {
        byte[] bigObject;
        bigObject = new byte[4 * _1MB];
    }

    /**
     * VM OPTS: -verbose:gc -Xms20M -Xmx20M Xmn10M
     * -XX:+PrintGCDetails -XX:SurvivorRation=8 -XX:MaxTenuringThreshold=1
     *  -XX: +PrintTenuringDistribution
     */
    public static void testTunuringThreshold() {
        byte[] obj1,obj2,obj3;
        obj1 = new byte[_1MB/4]; // -> survivor
        obj2 = new byte[4 * _1MB]; // -> eden
        obj3 = new byte[4 * _1MB]; // obj1 -> age:1, obj2 -> tenured, obj3 -> eden
        obj3 = null;
        obj3 = new byte[4 * _1MB]; // obj1 -> tenured, obj3 -> evacuation, obj3 -> eden
    }

    /**
     * VM OPTS: -verbose:gc -Xms20M -Xmx20M -Xmn10M
     * -XX:+PrintGCDetails -XX:SurvivorRatio=8 -XX:MaxTenuringThreshold=15
     *  -XX: +PrintTenuringDistribution
     */
    public static void testTunuringThreshold2() {
        byte[] obj1,obj2,obj3,obj4;
        // obj1,obj2 -> survivor
        obj1 = new byte[_1MB/4];
        obj2 = new byte[_1MB/4];
        // obj1,obj2 -> tenured

        // obj3,obj4 -> eden
        obj3 = new byte[_1MB * 4];
        // obj3 -> tenured
        obj4 = new byte[_1MB * 4];
        // obj4 -> evacuation
        obj4 = null;
        // obj4 -> eden
        obj4 = new byte[_1MB * 4];

        // final allocation :
        // Eden: obj4
        // from Survivor:
        // to Survivor:
        // Tunered: obj1,obj2,obj3
    }

    /**
     * VM OPTS:
     * -Xms20M -Xmx20M -Xmn10M
     * -XX:+PrintGCDetails -XX:SurvivorRatio=8 -XX:HandlePromotionFailure
     */
    public static void testHandlePromotion() {
        byte[] obj1,obj2,obj3,obj4,obj5,obj6,obj7;
        obj1 = new byte[2 * _1MB]; // -> eden
        obj2 = new byte[2 * _1MB]; // -> eden
        obj3 = new byte[2 * _1MB]; // -> eden
        obj1 = null;
        // handle promotion and execute a minor GC
        // obj1 -> evacuation; obj2,obj3 -> tenured
        obj4 = new byte[2 * _1MB]; // obj4 -> eden
        obj5 = new byte[2 * _1MB]; // obj5 -> eden
        obj6 = new byte[2 * _1MB]; // obj6 -> eden
        obj4 = null;
        obj5 = null;
        obj6 = null;
        // handle promotion and execute a minor GC
        // obj4,obj5,obj6 -> evacuation
        obj7 = new byte[2 * _1MB]; // obj7 -> eden
    }

    public static void main(String[] args) {
       //testPretenureSizeThreshold();
       testTunuringThreshold();
       //testTunuringThreshold2();
       //testHandlePromotion();
    }
}
