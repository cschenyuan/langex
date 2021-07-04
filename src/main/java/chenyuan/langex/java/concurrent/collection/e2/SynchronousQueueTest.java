package chenyuan.langex.java.concurrent.collection.e2;

import java.util.Random;
import java.util.concurrent.SynchronousQueue;

/**
 * @author chenyuan
 */
public class SynchronousQueueTest {

    public static void main(String[] args) {

        SynchronousQueue<Integer> queue = new SynchronousQueue<>();

        Thread producer = new Thread(() -> {
            while (true) {
                try {
                    int product = new Random().nextInt(1000);
                    queue.put(product);
                    System.out.println("put " + product);
                    Thread.sleep(1000);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });

        Thread consumer = new Thread(() -> {
            while (true) {
                try {
                    System.out.println("take " + queue.take());
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });

        producer.start();
        consumer.start();
    }

}
