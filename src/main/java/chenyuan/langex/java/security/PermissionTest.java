package chenyuan.langex.java.security;

import org.junit.Test;

import java.io.File;
import java.io.FilePermission;
import java.io.FileReader;
import java.io.IOException;

/**
 * Created by chenyuan on 2017/8/16.
 */
public class PermissionTest {

    @Test
    public void test01() throws IOException {
        System.setSecurityManager(new SecurityManager());
        File file = new File("/Users/yuan/Devel/studio/atella/src/main/resources/sample_jaas.config");
//        FilePermission perm = new FilePermission("/Users/yuan/welcome", "read");
        try(FileReader reader = new FileReader(file)) {
            StringBuilder sb = new StringBuilder();
            char[] buffer = new char[0x1000];
            while (reader.read(buffer) != -1) {
                sb.append(buffer);
            }
            System.out.println(sb.toString());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void test02() {
        System.out.println();
    }

}
