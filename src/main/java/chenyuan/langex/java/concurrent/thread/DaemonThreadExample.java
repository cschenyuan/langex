package chenyuan.langex.java.concurrent.thread;

/**
 * @author chenyuan
 */
public class DaemonThreadExample {

    static void testNonDaemonThread() {
        Thread t = new Thread(() -> {
            System.out.println("线程开始");
            while (true) {
                try {
                    Thread.sleep(100000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        });


        t.start();

        try {
            t.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    static void testDaemonThread() {
        SimpleThread t = new SimpleThread();
        t.setDaemon(true);

        t.start();

        t.asyncStop();
        try {
            t.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

    }

    public static void main(String[] args) {
        testNonDaemonThread();
//        testDaemonThread();
    }
}
