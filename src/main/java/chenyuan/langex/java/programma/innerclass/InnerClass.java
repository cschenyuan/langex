package chenyuan.langex.java.programma.innerclass;

/**
 * Created by chenyuan on 2017/12/30.
 */
public class InnerClass {
    public void accessInnerClass() {
        Outer outer = new Outer();
        Outer.Inner4 inner4 = outer.new Inner4();
        Outer.Inner5 inner5 = new Outer.Inner5();
    }
}

class Outer {

    /**
     * 只能在外部类的作用范围之内访问该内部类及其字段n
     * 可在静态方法中访问
     */
    private static class Inner1 { private int n; }

    private final class Inner2 { private int n; }

    /**
     * 不能在静态方法中访问该内部类
     */
    private class Inner3 { private int n; }

    /**
     * 该内部类具有包访问权限
     * 能以outer.new Inner4()方式创建对象
     */
    class Inner4 {}

    /**
     * 该内部类具有包访问权限
     * 能以new Outer.Inner5()方式创建对象
     * 字段n不具有访问权限
     */
    static class Inner5 { private int n; }

    /**
     * 该内部类具有公共访问权限
     */
    public class Inner6 {}

}

class DotThis {
    class Inner {
        public DotThis outer() {
            return DotThis.this;
        }
    }
}

class DotNew {
    class Inner {}
    public static void main(String[] args) {
        DotNew dotNew = new DotNew();
        Inner inner = dotNew.new Inner();
    }
}


class AnonymousInnerClass {

    private interface Contents {}

    public Contents contents() {
        return new Contents() {
            private int i;
            public int value() { return i; }
        };
    }

}


