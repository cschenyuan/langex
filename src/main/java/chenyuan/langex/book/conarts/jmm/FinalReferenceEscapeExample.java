package chenyuan.langex.book.conarts.jmm;

/**
 * Created by yuan on 15/12/27.
 */
public class FinalReferenceEscapeExample {
    final int i;

    static FinalReferenceEscapeExample obj;

    public FinalReferenceEscapeExample() {
        i = 1;
        obj = this;
    }

    public static void writer() {
        new FinalReferenceEscapeExample();
    }

    public static void reader() {
        if(obj != null) {
            int temp = obj.i;
        }
    }
}
