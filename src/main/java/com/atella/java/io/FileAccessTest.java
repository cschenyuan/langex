package com.atella.java.io;

import org.junit.Test;

import java.io.*;
import java.nio.charset.Charset;

/**
 * Created by yuan on 16/10/14.
 */
public class FileAccessTest {

    @Test
    public void readFileAsChars() {
        File file = new File("README");
        try {
            Reader fileReader = new FileReader(file);
            char[] buffer = new char[0x10];
            int len;
            StringBuilder text = new StringBuilder();
            while ((len = fileReader.read(buffer)) != -1) {
                text.append(buffer, 0, len);
            }
            System.out.println(text.toString());
        } catch (IOException ioe) {
            System.err.println(ioe.getMessage());
        }
    }

    @Test
    public void readFileAsBytes() {
        File file = new File("README");
        try {
            InputStream fileInput = new FileInputStream(file);
            byte[] buffer = new byte[0x10];
            int len;
            StringBuilder text = new StringBuilder();
            while ((len = fileInput.read(buffer)) != -1) {
                text.append(new String(buffer, 0, len, Charset.forName("utf-8")));
            }
            System.out.println(text.toString());
        } catch (IOException ioe) {
            System.err.println(ioe.getMessage());
        }
    }

    @Test
    public void writeFileWithChars() {
        File srcFile = new File("README");
        File destFile = new File("NOTICE");
        try {
            Reader fileReader = new FileReader(srcFile);
            Writer fileWriter = new FileWriter(destFile);
            char[] buffer = new char[0x40];
            int len;
            while ((len = fileReader.read(buffer)) != -1) {
                fileWriter.write(buffer, 0, len);
            }
            fileWriter.flush(); // important operation
        } catch (IOException ioe) {
            System.err.println(ioe.getMessage());
        }
    }

    @Test
    public void writeFileWithBytes() {
        File srcFile = new File("README");
        File destFile = new File("NOTICE");
        try {
            InputStream in = new FileInputStream(srcFile);
            OutputStream out = new FileOutputStream(destFile);
            byte[] buffer = new byte[0x40];
            int len;
            while ((len = in.read(buffer)) != -1) {
                out.write(buffer, 0, len);
            }
            out.flush();
        } catch (IOException ioe) {
            System.err.println(ioe.getMessage());
        }
    }

    @Test
    public void randomAccessFile() {
        File file = new File("README");
        byte[] buffer = new byte[0x10];
        try {
            RandomAccessFile rafile = new RandomAccessFile(file, "rw");
            // read a line from the begin of the file
            System.out.println(rafile.readLine());
            System.out.println(rafile.getFilePointer());
            // read 6 chars from second line from the file
            rafile.read(buffer, 0, 6);
            System.out.println(new String(buffer, 0 , 6));

            // set the file pointer offset to 4
            rafile.seek(4);
            rafile.read(buffer, 0, 5);
            System.out.println(new String(buffer, 0 , 5));
        } catch (IOException ioe) {
            System.err.println(ioe.getMessage());
        }
    }

    @Test
    public void syncWrite() {
        File file = new File("README");
        try  {
            OutputStream fos = new FileOutputStream(file);
            OutputStreamWriter osw = new OutputStreamWriter(fos);
//            fos.getFD().sync();
            int i = 0;
            while (i < 1 << 14) {
                osw.write("0");
                i++;
            }
            fos.flush();
            osw.flush();
        } catch (IOException ioe) {
            ioe.printStackTrace();
        }
    }

}
