package chenyuan.langex.java.ehc;

public class S5_NullAndEmptyVarg {
  public static void register(String name,Integer...varg){
    return;
  }

  public static void register(String name,String...varg){
    return;
  }

  public static void main(String[] args){
    register("Chen Yuan",new Integer(123));
    register("China","LongLife");
    //register("ErrorOfEmpty");
    //register("ErrorOfNull",null);
  }
}
