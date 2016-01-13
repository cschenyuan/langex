package com.atella.book.conarts.jmm;

/**
 * Created by yuan on 15/12/27.
 */
public class FinalReferenceExample {
    final int[] intArray;

    static FinalReferenceExample obj;

    public FinalReferenceExample() {
        intArray = new int[1];
        intArray[0] = 1;
    }

    public static void writerOne() {
        obj = new FinalReferenceExample();
    }

    public static void writerTwo() {
        obj.intArray[0] = 2;
    }
    public static void reader() {
        if(obj != null) {
            int temp1 = obj.intArray[0];
        }
    }
}
