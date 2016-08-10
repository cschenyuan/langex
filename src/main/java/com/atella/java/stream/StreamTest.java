package com.atella.java.stream;

import java.util.Arrays;
import java.util.List;

/**
 * Created by yuan on 16/6/28.
 */
public class StreamTest {

    public static void main(String[] args) {

    }

    public static void test01() {
        List<String> people = Arrays.asList("Yu Ming","Jing Ku","Ping Ni");
        Object[] array = people.stream()
                .filter(t -> t.endsWith("Ni"))
                .toArray();
        System.out.println(Arrays.toString(array));
    }
}
