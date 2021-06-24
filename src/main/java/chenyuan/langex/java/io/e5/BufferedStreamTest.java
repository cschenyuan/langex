package chenyuan.langex.java.io.e5;

import org.junit.Before;
import org.junit.Test;

import java.io.*;

/**
 * @author chenyuan
 */
public class BufferedStreamTest {

    private static final String DIR = "src/main/java/"
            + BufferedStreamTest.class.getPackage().getName().replaceAll("\\.", "/");

    private File file;

    @Before
    public void init() {
        file = new File(DIR + "/data.txt");
    }

    @Test
    public void testOutput() {
        try (Writer writer = new FileWriter(file);
             BufferedWriter bw = new BufferedWriter(writer)) {
            bw.write("some data");
            bw.newLine();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void testInput() {
        try (Reader reader = new FileReader(file);
             BufferedReader br = new BufferedReader(reader)) {
            br.skip(1);
            if (br.ready()) {
                System.out.println(br.readLine());
            }
        } catch (IOException e) {
           e.printStackTrace();
        }
    }
}
