package chenyuan.langex.java.reflect;

import java.lang.reflect.Method;

/**
 * @author chenyuan
 */
public class Test {
        public static void main(String[] args) {
        Class cls = SubClass.class;
        for (Method method : cls.getMethods()) {
            System.out.println(method.getName());
            System.out.println(method.getReturnType());
            System.out.println(method.getAnnotatedReturnType());
            System.out.println(method.getGenericReturnType());
        }

        System.out.println("===");

        for (Method method : cls.getDeclaredMethods()) {
            System.out.println(method.getName());
            System.out.println(method.getReturnType());
            System.out.println(method.getAnnotatedReturnType());
            System.out.println(method.getGenericReturnType());
        }
    }
}
