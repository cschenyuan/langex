package chenyuan.langex.java.generics;

/**
 * Created by chenyuan on 2018/3/6.
 */

interface GenericsGetter<T extends GenericsGetter<T>> {
    T get();
}

interface Getter extends GenericsGetter<Getter> {}

public class GenericsAndReturnTypes {
    void test(Getter g) {
        Getter result = g.get();
        GenericsGetter gg = g.get();
    }
}
