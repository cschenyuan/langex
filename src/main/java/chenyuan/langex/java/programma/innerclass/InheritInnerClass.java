package chenyuan.langex.java.programma.innerclass;

/**
 * Created by chenyuan on 2018/1/10.
 */
public class InheritInnerClass {

    class OuterClass {
        class InnerClass {
            public void doSomething() {}
        }
    }

    class InheritedInnerClass extends OuterClass.InnerClass {
        public InheritedInnerClass(OuterClass outer) {
            outer.super();
        }
    }

}
