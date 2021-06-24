package chenyuan.langex.java.util;

import org.junit.Test;

import java.util.Optional;

/**
 * Created by yuan on 2016/12/9.
 */
public class OptionalTest {

    @Test
    public void test() {
        Optional<String> optional = Optional.of("boom");
        optional.isPresent(); // true
        optional.get(); // boom
        optional.orElse("pua"); // boom
        optional.ifPresent(System.out::println);
    }

}
