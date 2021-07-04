package chenyuan.langex.java.lang.classloader;

import javax.servlet.Servlet;

/**
 * @author chenyuan
 */
public class ClassloaderTest {

    public static void main(String[] args) throws Exception {
        System.out.println(ClassloaderTest.class.getClassLoader().getClass().getName());
//        System.out.println(Object.class.getClassLoader().getClass().getName());
        System.out.println(Servlet.class.getClassLoader().getClass().getName());


        Class c1 = ClassloaderTest.class;
        Class c2  = new ClassLoader() {
            @Override
            public Class<?> loadClass(String name) throws ClassNotFoundException {
                System.out.println(getParent().getClass().getName());
                return super.loadClass(name);
            }
        }.loadClass("chenyuan.langex.java.lang.classloader.ClassloaderTest");

        System.out.println(c1 == c2);
    }

}
