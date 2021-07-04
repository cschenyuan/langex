package chenyuan.langex.java.concurrent;

import java.util.Random;
import java.util.concurrent.CyclicBarrier;

/**
 * 当所有线程都达到Barrier状态后，再一起同时执行
 * @author chenyuan
 */
public class CyclicBarrierTest {

    static class BusinessThread extends Thread {

        private CyclicBarrier barrier;

        public BusinessThread(CyclicBarrier barrier) {
            this.barrier = barrier;
        }

        @Override
        public void run() {
            try {
                Thread.sleep(1000 * (new Random().nextInt(10)));
                System.out.println(getName() + "当前准备工作执行完成, 正在等待其他线程完成准备工作...");
                barrier.await();
            } catch (Exception e) {
                e.printStackTrace();
            }
            System.out.println(getName() + "所有线程准备工作均完成");
        }
    }

    public static void main(String[] args) {
        CyclicBarrier barrier = new CyclicBarrier(10);

        for (int i=0; i < 10; i ++) {
            new BusinessThread(barrier).start();
        }
    }
}
