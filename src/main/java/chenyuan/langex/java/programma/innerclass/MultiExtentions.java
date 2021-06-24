package chenyuan.langex.java.programma.innerclass;

/**
 * Created by chenyuan on 2018/1/6.
 */

class A { void f1(){} }
abstract class B { abstract void f2(); }
interface C { void f3(); }

public class MultiExtentions implements C {

    private InnerClassA a = this.new InnerClassA();
    private InnerClassB b = this.new InnerClassB();

    class InnerClassA extends A {
        void f1() { System.out.println(hashCode());}
    }

    class InnerClassB extends B {
        void f2() {System.out.println(hashCode());}
    }

    public void f1() {
        a.f1();
    }

    public void f2() {
        b.f2();
    }

    public void f3() {}

}
