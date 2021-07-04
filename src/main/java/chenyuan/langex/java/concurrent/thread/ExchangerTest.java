package chenyuan.langex.java.concurrent.thread;

import java.util.Random;
import java.util.concurrent.Exchanger;

/**
 * @author chenyuan
 */
public class ExchangerTest {

    public static void main(String[] args) {
        Exchanger<Integer> exchanger = new Exchanger<>();

        new Thread(() -> {
            try {
                Thread.sleep(2000);
                int obtain = exchanger.exchange(new Random().nextInt(100));
                System.out.println(Thread.currentThread() + " obtain " + obtain);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }).start();

        new Thread(() -> {
            try {
                Thread.sleep(3000);
                int obtain = exchanger.exchange(new Random().nextInt(100));
                System.out.println(Thread.currentThread().getName() + " obtain " + obtain);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }).start();

        new Thread(() -> {
            try {
                Thread.sleep(4000);
                int obtain = exchanger.exchange(new Random().nextInt(100));
                System.out.println(Thread.currentThread().getName() + " obtain " + obtain);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }).start();

        new Thread(() -> {
            try {
                Thread.sleep(5000);
                int obtain = exchanger.exchange(new Random().nextInt(100));
                System.out.println(Thread.currentThread().getName() + " obtain " + obtain);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }).start();
    }
}
