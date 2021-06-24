package chenyuan.langex.java.generics;

/**
 * Created by chenyuan on 2018/2/26.
 */
public class GenericsErasure {

    public class A {}

    public class B<E extends A> {

        private A a;

        public B() {
        }

    }
}
