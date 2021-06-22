package com.atella.java.system;

import org.junit.Test;

import java.util.*;

public class TestSystem {

    public static <T> String clctionToString(Collection<T> collection){
        StringBuilder sb = new StringBuilder();
        if(collection != null){
          for(T e : collection){
            sb.append(String.valueOf(e) + " ");
          }
          sb.append("\n");
        }
        return sb.toString();
      }

    @Test
    public void test() {
        Properties properties = System.getProperties();
        Enumeration enumeration = properties.propertyNames();
        while (enumeration.hasMoreElements()) {
            String key = (String)enumeration.nextElement();
            System.out.println("key: " + key + " value:" + properties.get(key));
        }
    }


	public static void main(String[] args) {
        List<String> list = new ArrayList<String>();
        list.add("A");
        list.add("B");
        System.out.println(clctionToString(list));
	}

}
