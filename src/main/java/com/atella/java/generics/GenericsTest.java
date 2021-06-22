package com.atella.java.generics;

import org.junit.Test;

import java.util.*;

/**
 * Created by chenyuan on 2018/2/6.
 */
public class GenericsTest {

    @Test
    public void test() {
        List<Integer> list = new ArrayList<>();
        System.out.println(Arrays.toString(list.getClass().getTypeParameters()));
        Map<String,List<String>> map = new HashMap<>();
        System.out.println(Arrays.toString(map.getClass().getTypeParameters()));
    }
}
