package chenyuan.langex.java.test;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.*;

public class Test {

	public static void main(String[] args) {
//        String[] argv = {"a","b"};
//        System.out.println(Arrays.toString(argv));
        test05();
	}
	

    static void test00() {
        String str = "Hello World";
		str.compareTo("");
        try {

          Thread.sleep(1000 * 600);
        } catch (Exception e) {
          e.printStackTrace();
        }
    }

    static void test01() {
        Map<String,String> ref = new HashMap<>();
        Test test = new Test();
        test.test01(ref);
        if (ref.containsKey("test")) {
            System.out.println("passed reference");
            System.out.println(ref.get("test"));
        } else {
            System.out.println("passed value");
        }
    }

    /**
     * 传值（或引用值,引用的副本）, 对值的计算, 只会改变内部引用的值, 不会改变外部引用的值
     * @param ref
     */
    void test01(Map<String,String> ref) {
        // internal compluting
        ref.put("test","testvalue");
        // follow code is ineffective
        // external computing
        ref = new HashMap<>();
    }

    static void test02() {
        System.out.println("A");
        System.out.println("sss"+'\32'+"sad");
        System.out.println("B");
    }

    static void test03() {
        System.out.println(Boolean.valueOf(null) == false);
    }

    static void test04() {
        MyObject testReturn = new MyObject();
        List<String> list = testReturn.getTestList();
        System.out.println("At first return: " + list.hashCode());
        for(String str : list) {
            System.out.println(str);
        }
        list.add("modification");
        list = testReturn.getTestList();
        System.out.println("At second return: " + list.hashCode());
        for(String str : list) {
            System.out.println(str);
        }
    }

    static void test05() {
        DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        Date date = new Date(1479196223048L);
        System.out.println(dateFormat.format(date));
        int [] a = new  int[]{1, 3};
    }

}

class MyObject {
    private List<String> testList = new ArrayList<>();

    MyObject() {
        testList.add("test return");
    }

    public List<String> getTestList() {
        return testList;
    }
}