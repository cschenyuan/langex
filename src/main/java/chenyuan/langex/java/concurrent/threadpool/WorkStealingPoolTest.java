package chenyuan.langex.java.concurrent.threadpool;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * @author chenyuan
 */
public class WorkStealingPoolTest {

    public static void main(String[] args) {
        ExecutorService executor = Executors.newWorkStealingPool(2);
    }
}
