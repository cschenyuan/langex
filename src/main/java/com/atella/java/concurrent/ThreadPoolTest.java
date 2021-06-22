package com.atella.java.concurrent;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/**
 * Created by yuan on 16/9/10.
 */
public class ThreadPoolTest {

    static class MyTask implements Runnable {
        @Override
        public void run() {
            ExecutorService executor = Executors.newFixedThreadPool(2);
            for (int i = 0; i < 2; i ++) {
                final int n = i;
                executor.execute(() -> {
                    while(true) {
                        try {
                            Thread.sleep(1);
                        } catch (InterruptedException e) {
                            System.out.println("thread " + n + " is interrupted");
                            break;
                        }
                    }
                });
            }
            try {
                executor.awaitTermination(Long.MAX_VALUE, TimeUnit.SECONDS);
            } catch (InterruptedException e) {
                executor.shutdownNow();
                e.printStackTrace();
            }
        }
    }

    public static void main(String[] args) throws Exception {
        MyTask task = new MyTask();
        Thread t = new Thread(task);
        t.setDaemon(true);
        t.start();
        Thread.sleep(5000);
        t.interrupt();
    }
}
