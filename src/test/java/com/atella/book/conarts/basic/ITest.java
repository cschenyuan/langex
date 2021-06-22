package com.atella.book.conarts.basic;

import org.junit.Test;
import sun.misc.BASE64Encoder;

import java.net.*;
import java.util.*;

/**
 * Created by yuan on 16/2/18.
 */
public class ITest {
    @org.junit.Test
    public void test01() {
        String s = "a,b";
        for(String ss : s.split(",")) {
            System.out.println(ss);
        }
        String s2 = "asd\n";
        System.out.println(s2.endsWith("\n"));
        System.out.println(s2.substring(0,s2.length() - 1).endsWith("\n"));
    }

    private byte[] ipToBytes(String ipAddr) {
        byte[] addr = new byte[4];
        String[] slots = ipAddr.trim().split("\\.");
        System.out.println(slots.length);
        for(int i=0;i<4;i++) {
            addr[i] = (byte) Integer.parseInt(slots[i]);
        }
        return addr;
    }

    @Test
    public void test02() throws UnknownHostException {
//        String host = InetAddress.getByName("123.103.21.2").getHostName();

//        String host1 = InetAddress.getByAddress(ipToBytes("10.100.26.160")).getHostName();
        String host1 = InetAddress.getByAddress(ipToBytes("123.103.21.32")).getHostName();
        System.out.println(host1);
    }

    @Test
    public void test03() throws Exception {
        String addr = "mdp12:8020";
        System.out.println(getHostnameByAddr(addr,"http://"));
    }

    public static String getHostnameByAddr(String addr,String scheme) throws Exception {
        if(addr == null || addr.isEmpty())
            throw new URISyntaxException("address can not be null or empty", null);
        final String SEPERATOR = ":";
        if ( !addr.contains(SEPERATOR) )
            return addr.trim();
        if (scheme == null || scheme.isEmpty())
            throw new URISyntaxException("scheme can not be null or empty", null);
        URI uri =  addr.indexOf(SEPERATOR) == addr.lastIndexOf(SEPERATOR) ?
                URI.create(scheme + addr) : URI.create(addr);
        return uri.getHost();
    }

    @Test
    public void test04() {
        System.out.println("aAAA".toLowerCase());
    }

    @Test
    public void test05() {
        Date date = new Date();
        System.out.println(String.format("%03d", 1) + date.getTime());
    }

    @Test
    public void test06() {
       Integer i = null;
       int n = Integer.valueOf(i);
       System.out.println(n);
    }

    @Test
    public void test7() {
        int n = 0;
        int addition = 3;
        switch (addition) {
            case 1: n++;
            case 2: n+=2;
            case 3: n+=3;
            default: n+=4;
        }

        System.out.println(n);
    }

    @Test
    public void test8() {
        Float i1 = 1.f;
        Float i2 = 1.f;
        System.out.println(i1.hashCode());
        System.out.println(i2.hashCode());
        System.out.println(i1 == i2);
        System.out.println(i1.equals(i2));
    }

    @Test
    public void test9() {
        Set<String> set = new TreeSet<>(new Comparator<String>() {
            public int compare(String o1, String o2) {
                return o2.compareTo(o1);
            }
        });

        set.add("1_2_1");
        set.add("2_2_1");
        set.add("3_2_2_1_1");

        System.out.println(Arrays.toString(set.toArray()));
    }
}
