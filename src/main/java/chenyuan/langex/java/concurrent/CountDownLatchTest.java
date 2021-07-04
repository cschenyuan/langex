package chenyuan.langex.java.concurrent;

import java.util.concurrent.CountDownLatch;

/**
 * CountDownLatch，等待n个子线程执行结束(countDown())
 * @author chenyuan
 */
public class CountDownLatchTest {

    public static void main(String[] args) {
        CountDownLatch latch = new CountDownLatch(2);

        new Thread(() -> {
            try {
                Thread.sleep(2000);
                latch.countDown(); // 执行结束
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }).start();

        new Thread(() -> {
            try {
                Thread.sleep(3000);
                latch.countDown(); // 执行结束
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }).start();

        try {
            latch.await(); // 无限期等待
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
