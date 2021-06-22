package com.atella.java.os.path;

import org.apache.velocity.runtime.resource.loader.ClasspathResourceLoader;
import org.apache.velocity.runtime.resource.loader.ResourceLoader;
import org.junit.Before;
import org.junit.Test;

import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.Enumeration;
import java.util.List;

/**
 * Created by chenyuan on 2017/8/24.
 */
public class PathTest {

    @Before
    public void init() {
        String classpath = System.getProperty("java.class.path");
        List<String> paths = new ArrayList<>();
        paths.add(".");
        paths.add("/Users/yuan/Devel/studio/atella/src/main/resources");
        paths.add(System.getProperty("user.home"));
        System.setProperty("java.class.path",
                classpath + ":" + paths.stream().reduce((l, r) -> l+":"+r).get());
    }

    @Test
    public void findInClassPath() {
        ClassLoader classLoader = getClass().getClassLoader();
        System.out.println(System.getProperty("java.class.path"));
        try {
            Enumeration<URL> urls = classLoader.getResources("foo.txt");
            while (urls.hasMoreElements()) {
                URL url = urls.nextElement();
                System.out.println(url.toString());
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void findInClassPath2() {
        ClasspathResourceLoader resourceLoader = new ClasspathResourceLoader();
        System.out.println(resourceLoader.resourceExists("welcome"));
    }

    public static void main(String[] args) {
        PathTest test = new PathTest();
        test.findInClassPath();
    }

}
