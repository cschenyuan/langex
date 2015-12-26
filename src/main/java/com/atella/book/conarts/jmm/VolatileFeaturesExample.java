package com.atella.book.conarts.jmm;

/**
 * Created by yuan on 15/12/25.
 */
public class VolatileFeaturesExample {

}


// Code: A
class VolatileExample {
    volatile long vl = 0L;

    public void set(long l) {
        this.vl = l;
    }

    public void getAndIncrement() {
        vl++;
    }

    public long get() {
        return this.vl;
    }
}

// Code: B
// be equivalent with A
class EquivalentExample {
    long vl = 0L;

    public synchronized void set(long l) {
        this.vl = l;
    }

    public void getAndIncrement() {
        long temp = get();
        temp += 1L;
        set(temp);
    }

    public synchronized long get() {
        return this.vl;
    }
}

// happens-before: 1 -> 2 -> 3 -> 4
class VolatileExample1 {
    int a = 0;
    volatile boolean flag = false;

    public void writer () {
        a = 1; // #1
        flag = true; // #2
    }

    public void reader() {
        if(flag) { // #3
            int i = a; // #4
        }
    }
}
