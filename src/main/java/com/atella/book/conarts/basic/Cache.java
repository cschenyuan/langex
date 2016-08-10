package com.atella.book.conarts.basic;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantReadWriteLock;

/**
 * Created by yuan on 16/1/20.
 */
public class Cache {
    private static Map<String,Object> map = new HashMap<>();
    static ReentrantReadWriteLock rwl = new ReentrantReadWriteLock();
    static Lock rlock = rwl.readLock();
    static Lock wlock = rwl.writeLock();

    public static Object get(String key) {
        rlock.lock();
        try {
            return map.get(key);
        } finally {
            rlock.unlock();
        }
    }

    public static void put(String key,Object value) {
        wlock.lock();
        try {
            map.put(key,value);
        } finally {
            wlock.unlock();
        }
    }

    public static void clear() {
        wlock.lock();
        try {
            map.clear();
        } finally {
            wlock.unlock();
        }
    }
}
