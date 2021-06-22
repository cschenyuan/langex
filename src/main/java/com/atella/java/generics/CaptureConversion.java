package com.atella.java.generics;

/**
 * Created by chenyuan on 2018/3/5.
 */
public class CaptureConversion {

    static class Holder<T> {
        private T e;
        public T get() {
            return e;
        }
    }

    static <T> void f1(Holder<T> holder) {
        System.out.println(holder.get().getClass().getSimpleName());
    }

    static void f2(Holder<?> holder) {
        f1(holder);
    }

    public static void main(String[] args) {
        Holder raw = new Holder<Integer>();
        f1(raw);  // unchecked warning
        f2(raw); // no warning
    }
}
