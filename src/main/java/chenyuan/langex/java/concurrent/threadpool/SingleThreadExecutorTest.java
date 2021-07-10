package chenyuan.langex.java.concurrent.threadpool;

import java.util.concurrent.*;

/**
 * @author chenyuan
 */
public class SingleThreadExecutorTest {

    public static void main(String[] args) {

        // new ThreadPoolExecutor(1, 1,
        //        0, TimeUnit.MILLISECONDS,
        //        new LinkedBlockingQueue<>()
        //        );
        ExecutorService executor = Executors.newSingleThreadExecutor();
    }

}
