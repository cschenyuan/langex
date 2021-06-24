package chenyuan.langex.java.io.e3;

import java.io.InputStreamReader;

/**
 * 将字节流转换为字符流
 * @author chenyuan
 */
public class ByteStreamToCharStream {

    public static void main(String[] args) {

        try (InputStreamReader isr = new InputStreamReader(System.in)) {
            char[] buff = new char[1024];
            int len;
            while ((len = isr.read(buff))!= -1) {
               System.out.println(new String(buff, 0, len));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
