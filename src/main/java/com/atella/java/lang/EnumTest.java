package com.atella.java.lang;

import org.junit.Test;

/**
 * Created by chenyuan on 2017/3/31.
 */
public class EnumTest {

    public enum Type {
        T1,T2,T3;

        String type;

        public String getType() {
            return type;
        }
    }

    private Type type = Type.T1;

    public void test01() {
        EnumTest test1 = new EnumTest();
        EnumTest test2 = new EnumTest();
        Type t1 = test1.type;
        t1.type = "t1";
        System.out.println(t1.getType());
        Type t2 = test2.type;
        t2.type = "t2";
        System.out.println(t1.getType());
    }

    @Test
    public void test02() {
        String t1 = "T1";
        System.out.println(Type.valueOf("T1").ordinal());
    }
}
