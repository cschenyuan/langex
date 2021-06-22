package com.atella.java.lang;

import java.io.Serializable;

/**
 * Created by yuan on 2016/12/11.
 */
public class ClassTest implements Serializable {

    private static final String C_STRING = "String Literal";
    private static final Object C_OBJECT = new Object();
    private static final int C_INT = 1;
    private static float S_FLOAT = 1.0f;
    private final long C_LONG = 1L;

    private double V_DOUBLE = 1.0d;

    public ClassTest(double arg) {
        this.V_DOUBLE = arg;
    }

    public void func1(String arg1) {
        System.out.println(arg1);
    }

    private String func2() {
        return C_STRING;
    }

}
