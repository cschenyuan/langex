package chenyuan.langex.java.util;

import org.junit.Test;

import java.util.Objects;

/**
 * Created by yuan on 2016/12/9.
 */
public class ObjectsTest {

    @Test
    public void test() {
        Object object = new Object();
        Objects.isNull(object);
        Objects.nonNull(object);
        Objects.toString(object, "no values");
    }

}
