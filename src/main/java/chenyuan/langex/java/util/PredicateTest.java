package chenyuan.langex.java.util;

import org.junit.Test;

import java.util.Objects;
import java.util.function.Predicate;

/**
 * Created by yuan on 2016/12/9.
 */
public class PredicateTest {

    @Test
    public void test01() {
        Predicate<String> predicate = (s) -> s != null && !s.isEmpty() ;
        Predicate<Object> nonNull = Objects::nonNull;
        Predicate<String> isEmpty = String::isEmpty;
        Predicate<String> nonEmpty = isEmpty.negate();
        System.out.println(predicate.test("abv"));
    }
}
