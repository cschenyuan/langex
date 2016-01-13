package com.atella.book.conarts.jmm;

/**
 * Created by yuan on 15/12/27.
 */
public class MonitorExample {
    int a = 0;

    // happens-before order as program: 1->2, 2->3, 4->5, 5->6
    // happens-before order as monitor: 3->4
    // according to above: 2->5
    public synchronized void writer() { // 1
        a++; // 2
    } // 3

    public synchronized void reader() { // 4
        int i = a; //5
    } // 6
}
