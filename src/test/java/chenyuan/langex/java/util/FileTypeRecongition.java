package chenyuan.langex.java.util;

import org.junit.Test;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;

/**
 * Created by chenyuan on 2018/6/6.
 */
public class FileTypeRecongition {

    /**
     * 判断文件类型
     */
    public static boolean isJarType(String fileName) throws IOException {

        InputStream is = new FileInputStream(new File(fileName));
        byte[] bytes = new byte[28];

        try {
            is.read(bytes, 0, 28);
        } catch (IOException e) {
            e.printStackTrace();
            throw e;
        } finally {
            try {
                is.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

        StringBuilder sb = new StringBuilder();
        if (bytes.length <= 0) {
            return false;
        }
        for (byte aByte : bytes) {
            int v = aByte & 0xFF;
            String hv = Integer.toHexString(v);
            if (hv.length() < 2) {
                sb.append(0);
            }
            sb.append(hv);
        }

        String fileHead = sb.toString();

        if (fileHead.length() == 0)
            return false;
        fileHead = fileHead.toUpperCase();
        System.out.println("HEAD " + fileHead);
        return fileHead.startsWith("504B0304");
    }

    @Test
    public void printFileType() throws IOException {
        String jarCode = "504B03040A000000";
        String fileName = "/Users/yuan/Public/cona-rule-3.jar";
//        String fileName = "/Users/yuan/TMP/test.jar";
        System.out.println(isJarType(fileName));
    }

}
