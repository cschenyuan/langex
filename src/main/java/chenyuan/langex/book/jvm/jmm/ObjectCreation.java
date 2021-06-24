package chenyuan.langex.book.jvm.jmm;


public class ObjectCreation {

    public static void main(String[] args) {
        Animal cat = new Cat("Tom", 10);
        cat.bellow();
    }
}

abstract class Animal {

    protected String name;
    protected int age;

    public abstract void bellow();

}

class Owner {}

class Cat extends Animal {

    private Owner owner;

    public Cat(String name,int age) {
        this.owner = new Owner();
        this.name = name;
        this.age = age;
    }

    @Override
    public void bellow() {
        int a = age;
        char[] n = name.toCharArray();
        Owner o = owner;
        System.out.println("Miu~~A~");
    }

}
