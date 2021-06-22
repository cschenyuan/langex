package com.atella.java.concurrent;

import java.util.concurrent.*;

/**
 * Created by yuan on 16/10/20.
 */
public class MyThreadPool {

    public static class Producer implements Runnable {
        private ThreadPoolExecutor threadPool;
        final BlockingQueue queue;

        public Producer(BlockingQueue queue) {
            this.queue = queue;
            this.threadPool = new ThreadPoolExecutor(8, 8, 10,
                    TimeUnit.SECONDS, new LinkedBlockingQueue<Runnable>(8));
        }

        public void run() {
            try {
                for (int i=1;i<=100;i++) {
                    // some processing
                    String rawProduct = "NO. " + i;
                    Future<String> future = threadPool.submit(new Callable<String>() {
                        @Override
                        public String call() throws Exception {
//                            TimeUnit.MILLISECONDS.sleep(100);
                            return rawProduct;
                        }
                    });
                    queue.put(future.get());
                    System.out.println("Produced a product: " + future.get()
                            + " Queue size: " + queue.size());
                }
            } catch (InterruptedException | ExecutionException e) {

            }
        }

    }


    public static class Consumer implements Runnable {
        final BlockingQueue queue;

        public Consumer(BlockingQueue queue) {
            this.queue = queue;
        }

        public void run() {
            try {
                while(true) {
                    if (queue.size() >= 10) {
                        for (int i=0;i<10;i++) {
                            TimeUnit.SECONDS.sleep(1L);
                            queue.take();
                        }
                        System.out.println("consumed 10 products");
                    }
                }
            } catch (InterruptedException e) {

            }
        }

    }


    public static void main(String[] args) {
        BlockingQueue queue = new ArrayBlockingQueue<String>(20);
        new Thread(new Producer(queue)).start();
        new Thread(new Consumer(queue)).start();
//        pool.produce();
    }

}
