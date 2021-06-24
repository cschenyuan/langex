package chenyuan.langex.book.conarts.lock;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * Created by yuan on 2016/12/15.
 */
public class ConditionUseCase {

    private Lock lock = new ReentrantLock();
    private Condition condition = lock.newCondition();

    public void conditionWait() throws InterruptedException {
        try {
            lock.lock();
            condition.await();
        } catch (Exception e) {
            System.out.println("Here");
            e.printStackTrace();
        } finally {
            lock.unlock();
        }
    }

    public void conditionSignal() throws InterruptedException {
        lock.lock();
        try {
            condition.signal();
        } finally {
            lock.unlock();
        }
    }

    public static void main(String[] args) throws Exception {
        ConditionUseCase c = new ConditionUseCase();
        c.conditionWait();
    }

}
