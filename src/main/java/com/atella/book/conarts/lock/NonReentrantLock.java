package com.atella.book.conarts.lock;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.AbstractQueuedSynchronizer;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;

/**
 * Created by yuan on 2016/12/28.
 */
public class NonReentrantLock implements Lock {

    private final Sync sync;

    public NonReentrantLock() {
        sync = new Sync();
    }

    static final class Sync extends AbstractQueuedSynchronizer {

        final Condition newCondition() {
            return new ConditionObject();
        }

        @Override
        protected boolean tryAcquire(int arg) {
            if (compareAndSetState(0, 1)) {
                return true;
            }
            return false;
        }
    }

    @Override
    public void lock() {
        sync.tryAcquire(1);
    }

    @Override
    public void lockInterruptibly() throws InterruptedException {

    }

    @Override
    public boolean tryLock() {
        return false;
    }

    @Override
    public boolean tryLock(long time, TimeUnit unit) throws InterruptedException {
        return false;
    }

    @Override
    public void unlock() {

    }

    @Override
    public Condition newCondition() {
        return sync.newCondition();
    }
}
