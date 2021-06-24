package chenyuan.langex.book.conarts.lock;

import java.util.concurrent.Exchanger;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * Created by chenyuan on 2018/1/19.
 */
public class ExchangerTest {

    public void test() {
        Exchanger<Boolean> exchanger = new Exchanger<>();

        int numThread = 4;
        ExecutorService executor = Executors.newFixedThreadPool(numThread);

        for (int i=0; i < numThread; i++) {
            executor.execute(() -> {
            });
        }
    }

}
