package chenyuan.langex.java.concurrent.semaphore;

import java.util.concurrent.Semaphore;

/**
 * @author chenyuan
 */
public class SemaphoreTest {

    private static Semaphore semaphore = new Semaphore(10, false);

    static Thread createThread(int permits, long businessTime) {
        return new Thread() {
            @Override
            public void run() {
                while (true) {
                    try {
                        semaphore.acquire(permits);
                        System.out.println(getName() + "获得" + permits + "个资源！");
                        Thread.sleep(businessTime);
                        super.run();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    } finally {
                        semaphore.release(permits);
                        System.out.println(getName() + "释放" + permits + "个资源！");
                    }
                }
            }
        };
    }

    public static void main(String[] args) throws Exception {
        Thread t1 = createThread(2, 1000);
        Thread t2 = createThread(3, 5000);

        t1.start();
        t2.start();

        t1.join();
        t2.join();
    }
}
