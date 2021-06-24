package chenyuan.langex.java.concurrent;

/**
 * Created by yuan on 2016/11/18.
 */
public class ThreadExample {

    static void testInterrupted() {
        Thread t1 = new Thread(new Runnable() {
            @Override
            public void run() {
                while (true) {
                    try {
                        System.out.println("[I1] interrupted status => " + Thread.interrupted());
                        System.out.println("[I2] interrupted status => " + Thread.interrupted());
                        Thread.sleep(1000L);
                    } catch (InterruptedException e) {
                        System.out.println("Thread was interrupted");
                        e.printStackTrace();
                        break;
                    }
                }
            }
        });
        t1.start();
        t1.interrupt();
        System.out.println("[E] interrupted status => " + Thread.interrupted());
    }

    static void handleInterrupted() {
        Thread t1 = new Thread(() -> {
            while (true) {
                if (Thread.currentThread().isInterrupted()) {
                    System.out.println("I received your interruption request");
                    System.out.println("Now doing something of end ...");
                    try { Thread.sleep(2000L); }
                    catch (InterruptedException e) {}
                    System.out.println("Done");
                    break;
                }
            }
        });
        t1.start();
        try {
            Thread.sleep(200000L);
            t1.interrupt();
            System.out.println("interrupted status => " + t1.isInterrupted());
            t1.join();
            System.out.println("interrupted status => " + t1.isInterrupted());
        }
        catch (InterruptedException e) {}
    }

    public static void main(String[] args) {
        handleInterrupted();
    }
}
