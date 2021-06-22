package com.atella.java.util.collection;

import org.junit.Test;

import java.util.*;

/**
 * Created by chenyuan on 2017/12/18.
 */
public class ListTest {

    @Test
    public void testAddAll() {
        List list = new LinkedList();
        Collections.addAll(list, 1, 2, 3);

        // more faster
        List list2 = new ArrayList();
        list2.addAll(list);
    }

    @Test
    public void testAsList() {
        List<Integer> list = Arrays.asList(1, 2, 3);
        list.add(4); // Runtime error
    }

    @Test
    public void testPrint() {
        System.out.println(
                Arrays.toString(new String[]{"I", "m", "not", "me"})
        );
    }

}
