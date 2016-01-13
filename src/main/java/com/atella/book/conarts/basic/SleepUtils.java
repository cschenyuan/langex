package com.atella.book.conarts.basic;

import java.util.concurrent.TimeUnit;

/**
 * Created by yuan on 16/1/7.
 */
public class SleepUtils {

    public static final void second(long seconds) {
        try {
            TimeUnit.SECONDS.sleep(seconds);
        } catch (InterruptedException e) {

        }
    }
}
