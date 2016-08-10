package com.atella.book.conarts.basic;

import org.junit.Test;

import java.net.*;

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
}
