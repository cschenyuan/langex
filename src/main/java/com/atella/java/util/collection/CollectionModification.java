package com.atella.java.util.collection;

import org.junit.Test;

import java.util.*;

/**
 * Created by chenyuan on 2018/2/26.
 */
public class CollectionModification {

    @Test
    public void test01() {
        Set<Integer> set = new HashSet<>();
        Collections.addAll(set, 1, 2, 3, 4, 5, 6);

        for (Iterator<Integer> it = set.iterator(); it.hasNext();) {
            if (it.next() % 2 == 0)
                it.remove();
        }

        System.out.println(Arrays.toString(set.toArray()));
    }
}
