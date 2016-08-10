package com.atella.book.conarts.basic;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * Created by yuan on 16/1/22.
 */
public class ConditionUseCase {
    Lock lock = new ReentrantLock();
    Condition condition = lock.newCondition();

    public void conditionWait() throws InterruptedException {
        lock.lock();
        try {
            // release lock and wait
            condition.await();
        } finally {
            lock.unlock();
        }
    }

    public void conditionSingnal() throws InterruptedException {
        lock.lock();
        try {
            condition.signal();
        } finally {
            lock.unlock();
        }
    }
}
