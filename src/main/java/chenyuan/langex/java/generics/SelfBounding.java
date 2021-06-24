package chenyuan.langex.java.generics;

/**
 * Created by chenyuan on 2018/2/27.
 */

class SelfBounded<T extends SelfBounded<T>> {
    T element;

    SelfBounded<T> set(T arg) {
        element = arg;
        return this;
    }

    T get() { return element; }
}

class X extends SelfBounded<X> {}
class Y extends SelfBounded<X> {}

class D {}
// cannot do this
// class E extends SelfBounded<D> {}

class W extends SelfBounded {}

public class SelfBounding {

    public static void main(String[] args) {
        X x = new X();
        x.set(x);
        System.out.println(x.get().getClass().getSimpleName());
        Y y = new Y();
        y.set(x);
        System.out.println(y.get().getClass().getSimpleName());
        W w = new W();
        w.set(y);
        System.out.println(w.get().getClass().getSimpleName());
    }
}

