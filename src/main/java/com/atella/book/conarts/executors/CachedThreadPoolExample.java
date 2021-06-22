package com.atella.book.conarts.executors;

import com.atella.book.conarts.basic.Interrupted;
import org.junit.Test;

import java.util.concurrent.*;

/**
 * Created by yuan on 2017/1/9.
 */
public class CachedThreadPoolExample {

    @Test
    public void testSynchronousQueue() throws Exception {
        SynchronousQueue<String> queue = new SynchronousQueue<>();
        Executors.newSingleThreadExecutor().execute(() -> {
            try {
                while(true) {
                    if (Thread.interrupted())
                        break;
                    System.out.println("consumed:" + queue.take());
                    TimeUnit.MILLISECONDS.sleep(1000L);
                }
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });

        System.out.println("adding");
        queue.put("e-1");
        System.out.println("adding");
        queue.put("e-2");
    }

    @Test
    public void testCachedThreadPool() throws Exception {
        ThreadPoolExecutor executor = (ThreadPoolExecutor)Executors.newCachedThreadPool();
        for (int i=0;i<10;i++) {
            final int n = i;
            executor.execute(() -> {
                System.out.println("Thread-" + n + ": " + executor.getPoolSize());
                try {
                    TimeUnit.MILLISECONDS.sleep(1000L);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            });
        }

        executor.awaitTermination(Long.MAX_VALUE, TimeUnit.MILLISECONDS);
    }

}
