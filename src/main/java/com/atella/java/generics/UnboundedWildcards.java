package com.atella.java.generics;

import org.junit.Test;

import java.util.*;

/**
 * Created by chenyuan on 2018/3/1.
 */
public class UnboundedWildcards {


    @Test
    public void test() {
        List list1 = new ArrayList();
        List<Object> list2 = new ArrayList<>();
        List<Integer> list3 = new ArrayList<>();
        List<String> list4 = new ArrayList<>();
        List<?> list;

        list1.add(new A());
        list1.add(new B());

        list2.add(new A());
        list2.add(new B());

        list3.addAll(Arrays.asList(1, 2, 3));
        list = list3;
        for (Object i : list)
            System.out.println(i);

        list4.addAll(Arrays.asList("a", "b", "c"));
        list = list4;
        for (Object s : list)
            System.out.println(s);
    }

    @Test
    public void test1() {
        Map<Integer, List<String>> map = new HashMap<>();
        List<String> l1 = new ArrayList<>();
        Collections.addAll(l1, "a", "b", "c");
        map.put(1, l1);
        List<String> l2 = new ArrayList<>();
        Collections.addAll(l2, "A", "B", "C");
        map.put(2, l2);

        for (List<String> l : map.values())
            l.remove(0);

        System.out.println(Arrays.toString(map.get(1).toArray()));
        System.out.println(Arrays.toString(map.get(2).toArray()));
    }
}

class A {}
class B {}

