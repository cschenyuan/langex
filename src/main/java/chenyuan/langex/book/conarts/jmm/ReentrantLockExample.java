package chenyuan.langex.book.conarts.jmm;

import java.util.concurrent.locks.ReentrantLock;

/**
 * Created by yuan on 15/12/27.
 */
public class ReentrantLockExample {
    int a = 0;
    ReentrantLock lock = new ReentrantLock();

    public void writer() {
        lock.lock();
        try {
            a++;
        } finally {
            lock.unlock();
        }
    }

    public void reader() {
        lock.lock();
        try {
            int i = a;
            // ...
        } finally {
            lock.unlock();
        }
    }
}
