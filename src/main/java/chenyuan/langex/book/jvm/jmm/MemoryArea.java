package chenyuan.langex.book.jvm.jmm;

public class MemoryArea {
    static void jVMStack() {

    }
}

class ConstantPool {

    private static final String CONST_STR = "abc";
    private static String STATIC_STR = "123";

    private String str;

    public void print() {}
}

class VMStack {

    public int members() {
        int count = 0;
        String word = "method";
        byte[] data = new byte[8];
        while(count < 8) {
            count ++;
        }
        return count;
    }
}
