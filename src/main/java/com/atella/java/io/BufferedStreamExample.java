package com.atella.java.io;

import java.io.*;

/**
 * Created by chenyuan on 2017/10/18.
 */
public class BufferedStreamExample {

    public void testBufferedInputStream() {
        File testFile = new File("test.txt");
        try (InputStream is = new FileInputStream(testFile)) {
            BufferedInputStream bis = new BufferedInputStream(is);
            bis.available();
        } catch (IOException e) {

        }
    }
}
