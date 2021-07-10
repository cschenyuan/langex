package chenyuan.langex.java.concurrent.threadpool;

import java.util.concurrent.*;

/**
 * @author chenyuan
 */
public class FixedThreadPoolTest {

    public static void main(String[] args) {
        // new ThreadPoolExecutor(n, n,
        //        0, TimeUnit.MILLISECONDS,
        //        new LinkedBlockingQueue<Runnable>()
        // )
        ExecutorService executor = Executors.newFixedThreadPool(2);


    }
}
