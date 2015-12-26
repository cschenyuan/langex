package com.atella.book.conarts.jmm;

/**
 * Created by yuan on 15/12/25.
 */
public class VolatileBarrierExample {
    int a;
    volatile int v1 = 1;
    volatile int v2 = 2;

    void readAndWrite() {
        int i = v1; // the first volatile read
        int j = v2; // the second volatile read
        a = i + j;
        v1 = i + 1;
    }
}
