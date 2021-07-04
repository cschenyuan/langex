package chenyuan.langex.java.lang.e1;

/**
 * 被动引用的例子
 * 被动引用不会触发类的初始化
 * @author chenyuan
 */
public class NotInitializationExample {

    public static void main(String[] args) {
//        e1();
        e2();
//        e3;
    }

    static void e1() {
        // 只会打印"SuperClass初始化！"
        System.out.println(SubClass.value);
    }

    static void e2() {
        // SuperClass既不会被初始化, 也不会被加载
        System.out.println(SuperClass.CONSTANT_STR);
    }

    static void e3() {
        // SuperClass不会被初始化
        SuperClass[] sca = new SuperClass[10];
    }

}
