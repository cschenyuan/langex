package chenyuan.langex.java.concurrent.object;

import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * @author chenyuan
 */
public class WaiterAndProducer {

    private int size = 10;
    private final Queue<Object> queue = new LinkedList<>();

    public void enqueue(Object e) {
         synchronized (queue) {
             try {
                 if (queue.size() == 10) {
                     System.out.println("队列已满，等待消费者唤醒");
                     queue.wait();
                 }
                 Thread.sleep(200);
                 queue.offer(e);
                 queue.notify();
             } catch (InterruptedException ie) {
                 ie.printStackTrace();
             }
         }
    }

    public Object dequeue() {
        synchronized (queue) {
            try {
                if (queue.isEmpty()) {
                    System.out.println("队列为空，等待生产者唤醒");
                    queue.wait();
                }
                Thread.sleep(100);
                Object e = queue.poll();
                queue.notify();
                return e;
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        return null;
    }

    public static void main(String[] args) {
        WaiterAndProducer wap = new WaiterAndProducer();

        new Thread(() -> {
            while (true) {
                wap.enqueue(new Object());
            }
        }).start();

        new Thread(() -> {
            while (true) {
                wap.dequeue();
            }
        }).start();

    }
}
