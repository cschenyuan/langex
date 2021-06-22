package com.atella.java.system;

import org.junit.Test;

import java.io.IOException;
import java.net.URL;
import java.util.Enumeration;

/**
 * Created by chenyuan on 2017/11/15.
 */
public class ClassLoaderDemo {

    @Test
    public void test01() {
        ClassLoader classLoader = Thread.currentThread().getContextClassLoader();

        URL url = classLoader.getResource("foo.txt");
        System.out.println(url.toString());
    }
}
