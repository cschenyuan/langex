package com.atella.java.security;

import org.junit.Test;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.security.AccessControlContext;
import java.security.AccessController;
import java.security.PrivilegedAction;

/**
 * @author chenyuan
 */
public class SecurityManagerTest {

    private void readAndPrintFile() {
        File file = new File("/Users/yuan/Devel/studio/atella/data/foo.txt");
        try(FileReader reader = new FileReader(file)) {
            StringBuilder sb = new StringBuilder();
            char[] buffer = new char[1024];
            int len;
            while ((len = reader.read(buffer)) != -1) {
                sb.append(String.valueOf(buffer, 0, len));
            }
            System.out.println(sb.toString());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void setSM() {
        SecurityManager sm = new SecurityManager();
        System.setSecurityManager(sm);
    }

    @Test
    public void test01() {
        setSM();
        readAndPrintFile();
    }

    @Test
    public void test02() {
//        readAndPrintFile();
        AccessController.doPrivileged((PrivilegedAction<Boolean>) () -> {
            readAndPrintFile();
            return true;
        });
    }

    public static void main(String[] args) {
        SecurityManagerTest test = new SecurityManagerTest();
        test.test02();
    }
}
