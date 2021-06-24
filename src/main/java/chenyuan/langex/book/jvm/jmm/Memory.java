package chenyuan.langex.book.jvm.jmm;

/**
 * Created by chenyuan on 2018/3/11.
 */
public class Memory {

    private static final String CONST_STR = "MEMORY";

    private String str;
    private int num;
    private ClassA field;

    public Memory(int num) {
        this.num = num;
        this.field = new ClassA();
    }

    public void access() {
        int n = num + 1;
        this.field.print(n);
    }

    public static void main(String[] args) {
        Memory memory = new Memory(2);
        memory.access();
    }
}

class ClassA {
    private Object field = new Object();

    public void print(int n) {
        System.out.println(field.toString());
        for (int i=0; i<n; i++)
            System.out.println(i);
    }
}
