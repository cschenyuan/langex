package chenyuan.langex.java.concurrent.lock;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantReadWriteLock;

/**
 * 读写锁示例
 * @author chenyuan
 */
public class ReadWriteLockTest {

    private static final Map<String, Object> cache = new HashMap<>();

    private static ReentrantReadWriteLock lock = new ReentrantReadWriteLock(false);
    private static Lock readLock = lock.readLock();
    private static Lock writeLock = lock.writeLock();

    public static void put(String key, Object v) {
        writeLock.lock();
        try {
            cache.put(key, v);
        } finally {
            writeLock.unlock();
        }
    }

    public static void get(String key) {
        readLock.lock();
        try {
            cache.get(key);
        } finally {
            readLock.unlock();
        }
    }

}
