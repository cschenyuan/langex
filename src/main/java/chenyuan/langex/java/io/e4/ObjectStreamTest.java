package chenyuan.langex.java.io.e4;

import org.junit.Before;
import org.junit.Test;

import java.io.*;

/**
 * @see ObjectInputStream
 * @see ObjectOutputStream
 * @author chenyuan
 */
public class ObjectStreamTest {

    private static final String DIR = "src/main/java/"
            + ObjectStreamTest.class.getPackage().getName().replaceAll("\\.", "/");

    private File objectFile;

    @Before
    public void init() {
        objectFile = new File(DIR + "/object.d");
        System.out.println("file: " + objectFile.getAbsolutePath());
    }


    /**
     * 将对象转换成字节数据输出到文件
     */
    @Test
    public void testOutput() {
        try (FileOutputStream fos = new FileOutputStream(objectFile);
             ObjectOutputStream oos = new ObjectOutputStream(fos)) {
            Object s = "some data";
            oos.writeObject(s);
            oos.flush();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * 将文件输入流转换成对象输入流
     */
    @Test
    public void testInput() {
        try (FileInputStream fis = new FileInputStream(objectFile);
             ObjectInputStream ois = new ObjectInputStream(fis) ) {
            Object object = ois.readObject();
            System.out.println("[" + object.getClass() + "]: " + object);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
