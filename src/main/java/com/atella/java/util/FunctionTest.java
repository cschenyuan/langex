package com.atella.java.util;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Function;

/**
 * Created by yuan on 2016/12/9.
 */
public class FunctionTest {

    @Test
    public void test() {
        Function<List<String>,String> func = (l) -> l.stream()
                .reduce((s, e) -> s += e).get();
        List<String> list = new ArrayList<>();
        list.add("hello");
        list.add("world");
        System.out.println(func.apply(list));

    }
}
