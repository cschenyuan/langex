package chenyuan.langex.java.gc.e1;

/**
 * System.gc()示例
 * @author chenyuan
 */
public class SystemGCTest {

    public static void main(String[] args) {

        new Object() {
            @Override
            protected void finalize() throws Throwable {
                System.out.println("start running finalization");
                super.finalize();
            }
        };

        // 通知JVM执行GC，但不会马上执行
        System.gc();

        // 强制调用不可达对象的finalize()方法
//        System.runFinalization();

        try {
            Thread.sleep(5000);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
