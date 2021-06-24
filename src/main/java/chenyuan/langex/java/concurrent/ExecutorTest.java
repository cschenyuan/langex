package chenyuan.langex.java.concurrent;

import java.util.concurrent.Executor;
import java.util.concurrent.Executors;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Future;

/**
 * Created by yuan on 15/12/18.
 */
public class ExecutorTest {

    public static void main(String[] args) {
//       singleThhreadExecutor();
       test01();
    }

    static void singleThhreadExecutor() {
        Executor executor = Executors.newSingleThreadExecutor();
        Thread t1 = new Thread(){
          @Override
            public void run(){
              System.out.print("Hello World");
          }
        };
        executor.execute(t1);
    }

    // Executors
    static void test01() {
         ExecutorService pool = Executors.newCachedThreadPool();
         for (int i=0;i<100;i++) {
             pool.submit(new MyTask(i%4));
         }
        pool.shutdown();
    }

    static void testFixedThreadPool() {
        ExecutorService pool = Executors.newFixedThreadPool(32);
        for (int i=0;i<100;i++) {
        }
    }

    static class MyTask implements Runnable {
        private int index;

        public MyTask(int index) {
            this.index = index;
        }
            public void run() {
                System.out.println(index);
            }
    }
}
