package chenyuan.langex.java.util;

import org.junit.Test;

import java.util.function.Consumer;

/**
 * Created by yuan on 2016/12/9.
 */
public class ConsumerTest {

    @Test
    public void test() {
        Consumer<String> consumer = System.out::println;
        consumer.accept("hello world");
    }

}
