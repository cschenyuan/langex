package com.atella.java.system;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

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

      
	public static void main(String[] args) {
        List<String> list = new ArrayList<String>();
        list.add("A");
        list.add("B");
        System.out.println(clctionToString(list));
	}

}
