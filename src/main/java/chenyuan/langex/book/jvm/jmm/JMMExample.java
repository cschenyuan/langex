package chenyuan.langex.book.jvm.jmm;

/**
 * Created by chenyuan on 2018/3/4.
 */
public class JMMExample {

    private static final String CONSTANT_STR = "COFFEE BABY";

    private String appName;

    public JMMExample(String appName) {
        this.appName = appName;
    }

    /**
     * F(0) = 0, F(1) = 1
     * F(n) = F(n-1) + F(n-2) (n >= 2)
     * @param n
     * @return computation result
     */
    public int compute(int n) {
        if (n <= 0)
            return 0;
        if (n == 1)
            return 1;
        return compute(n-1) + compute(n-2);
    }

    public static Object runApp() {
        JMMExample app = new JMMExample("fibonacci computer");
        return app.compute(10);
    }

    public static void main(String[] args) {
        System.out.println(runApp());
    }

}
