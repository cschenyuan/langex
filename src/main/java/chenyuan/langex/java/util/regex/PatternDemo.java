package chenyuan.langex.java.util.regex;

import org.junit.Test;

import java.util.regex.Pattern;

/**
 * Created by chenyuan on 2017/12/14.
 */
public class PatternDemo {

    @Test
    public void test() {
        System.out.println(Pattern.compile("^m_key(_[0-9]*)?$").matcher("m_key_1").matches());
    }
}
