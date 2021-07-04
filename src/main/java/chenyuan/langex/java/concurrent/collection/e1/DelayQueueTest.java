package chenyuan.langex.java.concurrent.collection.e1;

import java.util.Date;
import java.util.Random;
import java.util.concurrent.DelayQueue;

/**
 * 延迟队列：元素添加到队列之后，需要在一定时间后才能获取到
 * @author chenyuan
 */
public class DelayQueueTest {

    public static void main(String[] args) throws Exception {
        DelayQueue<DelayedData> dq = new DelayQueue<>();
        Random random = new Random();

        Thread t = new Thread(() -> {
            while (true) {
                try {
                    DelayedData data = new DelayedData(random.nextInt());
                    dq.put(data);
                    System.out.println("[" + new Date() + "] put " + data);
                    Thread.sleep(1000);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });

        t.start();


        while (true) {
            try {
                System.out.println("[" + new Date() + "] took " + dq.take());
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

}
