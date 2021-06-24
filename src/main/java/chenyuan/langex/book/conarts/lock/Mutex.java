package chenyuan.langex.book.conarts.lock;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.AbstractQueuedSynchronizer;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;

/**
 * Created by yuan on 2016/12/28.
 */
public class Mutex implements Lock {

    private final Sync sync;

    public Mutex() {
        sync = new Sync();
    }

    static final class Sync extends AbstractQueuedSynchronizer {

        protected boolean isHeldExclusively() {
            return getState() == 1;
        }

        protected boolean tryAcquire(int acquires) {
            Thread current = Thread.currentThread();
            if (compareAndSetState(0, 1)) {
                setExclusiveOwnerThread(current);
                return true;
            }
            return false;
        }

        protected boolean tryRelease(int arg) {
            if (getState() == 0) throw new IllegalStateException();
            setExclusiveOwnerThread(null);
            setState(0);
            return true;
        }

    }

    @Override
    public void lock() {
        sync.acquire(1);
    }

    @Override
    public void lockInterruptibly() throws InterruptedException {
        sync.acquireInterruptibly(1);
    }

    @Override
    public boolean tryLock() {
        return sync.tryAcquire(1);
    }

    @Override
    public boolean tryLock(long time, TimeUnit unit) throws InterruptedException {
        return sync.tryAcquireNanos(1, unit.toNanos(time));
    }

    @Override
    public void unlock() {
        sync.release(1);
    }

    public boolean isLocked() {
        return sync.isHeldExclusively();
    }

    public boolean hasQueuedThreads() {
        return sync.hasQueuedThreads();
    }

    public boolean hasPredecssors() {
        return sync.hasQueuedPredecessors();
    }

    @Override
    public Condition newCondition() {
        return null;
    }
}
