package com.atella.java.net;

import java.net.URI;
import java.net.URISyntaxException;

/**
 * Created by yuan on 16/6/29.
 */
public class URITest {

    public static void main(String[] args) {
        test01();
    }

    public static void test01() {
        URI uri;
        try {
            uri = new URI("http", "noahark", "proxy.noahark", 10080, "/service", null, null);
            System.out.println(uri.toString());
        } catch (URISyntaxException e) {
            e.printStackTrace();
        }
    }
}
