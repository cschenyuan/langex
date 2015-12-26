package com.atella.java.lang;

public class StringTest {

  public static void main(String[] args) {
    test01();
  }

  static void print(String msg) {
    System.out.println(msg);
  }

  /**
   * illustrate that how Java to store String object in main memory and
   * the function of String.intern()
   */
  static void test01 () {
    String s1 = "Hello World";
    String s2 = "Hello " + "World"; // express "+" contains functionally "intern" operation
    StringBuilder sb = new StringBuilder();
    sb.append("Hello ").append("World");
    String s3 = sb.toString();
    String s4 = new String("Hello World");
    // optimize the memory
    String s4_ = (new String("Hello World")).intern();

    print("s1 == s2 " + (s1 == s2)); // true
    print("s1 == s3 " + (s1 == s3)); // false
    print("s1 == s4 " + (s1 == s4)); // false
    print("s1 == s3.intern " + (s1 == s3.intern())); // true

    print("s1 hash code: " + s1.hashCode());
    s1 = null;
    s2 = null;
    print("===Garbage Collection===");
    System.gc();
    print("s3.intern hash code: " + s3.hashCode());
  }

}
