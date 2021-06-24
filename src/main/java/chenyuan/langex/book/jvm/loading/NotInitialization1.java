package chenyuan.langex.book.jvm.loading;

/**
 * Created by chenyuan on 2018/3/18.
 */
public class NotInitialization1 {

    private static class A {
        static {
            System.out.println("A is initializing");
        }
        public static int value = 192;
    }

    private static class B extends A {
        static {
            System.out.println("B is initializing");
        }
    }

    public static void main(String[] args) throws Exception {
//        System.out.println(B.value);
//        Class.forName("com.atella.book.jvm.loading.NotInitialization1$B");
        A[] arr = new A[10];
    }
}
