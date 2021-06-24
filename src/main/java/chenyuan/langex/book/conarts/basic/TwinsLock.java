package chenyuan.langex.book.conarts.basic;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.AbstractQueuedSynchronizer;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;

/**
 * Created by yuan on 16/1/14.
 */
public class TwinsLock implements Lock {

    private final static class Sync extends AbstractQueuedSynchronizer {

        Sync(int count) {
            if (count <= 0)
                throw new IllegalArgumentException("count must large than zero");
            setState(count);
        }

        protected int tryAcquireShared(int reduceCount) {
            for(;;) {
                int current = getState();
                int newCount = current - reduceCount;
                if( newCount < 0 || compareAndSetState(current,newCount))
                    return newCount;
            }
        }

        protected boolean tryReleaseShared(int returnCount) {
            for(;;) {
                int current = getState();
                int newCount = current + returnCount;
                if ( compareAndSetState(current,newCount))
                    return true;
            }
        }

        protected Condition newCondition() { return new ConditionObject(); }
    }

    private Sync sync = new Sync(2);

    public void lock() { sync.acquireShared(1); }

    public void lockInterruptibly() throws InterruptedException {
        sync.acquireSharedInterruptibly(1);
    }

    public boolean tryLock() {
        if (sync.tryAcquireShared(1) >= 0)
            return true;
        return false;
    }

    public boolean tryLock(long timeout,TimeUnit unit) throws InterruptedException {
        return sync.tryAcquireSharedNanos(1,unit.toNanos(timeout));
    }

    public void unlock() { sync.releaseShared(1); }

    public Condition newCondition() { return sync.newCondition(); }
}
