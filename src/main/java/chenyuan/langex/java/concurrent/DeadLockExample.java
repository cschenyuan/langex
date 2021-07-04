package chenyuan.langex.java.concurrent;


import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * Created on 09/11/2016
 */
public class DeadLockExample {

    private static final String A = "A";
    private static final String B = "B";

    public static void main(String[] args) {
//        test互相等待();
        test没有释放锁();
    }


    /**
     * t1获得A锁之后，去请求B锁（这时B锁已经被t2拥有）时被阻塞，由于B锁一直不释放，所以t1一直被阻塞
     * t2获得B锁之后，请求A锁时被阻塞，由于A锁不释放，所以t2一直被阻塞
     * 最终形成死锁
     */
    static void test互相等待() {
        Thread t1 = new Thread() {
            @Override
            public void run() {
                synchronized(A) {
                    try {
                        Thread.sleep(2000L);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }

                    synchronized(B) {
                        System.out.println(B);
                    }
                }
            }
        };

        Thread t2 = new Thread() {
            public void run() {
                synchronized(B) {
                    synchronized(A) {
                        System.out.println(A);
                    }
                }
            }
        };

        t1.start();
        t2.start();
    }


    /**
     * t1拿到锁之后没释放，导致t2一直拿不到锁
     */
    static void test没有释放锁() {
        Lock lock = new ReentrantLock();

        Thread t1 = new Thread(() -> {
            lock.lock();
            System.out.println("t1拿到锁了！");
            try {
                Thread.sleep(2000L);
            } catch (Exception e) {
                e.printStackTrace();
            }
            // 不释放锁
        });
        t1.setName("test-t1");

        Thread t2 = new Thread(() -> {
            try {
                Thread.sleep(2000L);
            } catch (Exception e) {
                e.printStackTrace();
            }
            lock.lock();
            System.out.println("t2拿到锁了！");
            lock.unlock();
        });
        t2.setName("test-t2");

        t1.start();
        t2.start();
    }

}

