package chenyuan.langex.book.jvm.gc;

public class MinorGCExample {

    private static int _1MB = 1024 * 1024;

    public static void testAllocate() {
        byte[] obj1,obj2,obj3,obj4;
        obj1 = new byte[2 * _1MB];
        obj2 = new byte[2 * _1MB];
        obj3 = new byte[2 * _1MB];
        obj4 = new byte[4 * _1MB];
    }

    public static void main(String[] args) {
        testAllocate();
    }
}
