package chenyuan.langex.java.concurrent.threadpool;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

/**
 * @author chenyuan
 */
public class CachedThreadPoolTest {

    public static void main(String[] args) throws InterruptedException {
        // new ThreadPoolExecutor(0, Integer.MAX_VALUE,
        //     60, TimeUnit.SECONDS,
        //     new SynchronousQueue<Runnable>()
        // )
        ExecutorService executor = Executors.newCachedThreadPool();

        executor.execute(() -> {
            System.out.println("Running");
        });

        executor.shutdown();
        executor.awaitTermination(Long.MAX_VALUE, TimeUnit.DAYS);
    }
}
