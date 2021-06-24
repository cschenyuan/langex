package chenyuan.langex.java.generics;

/**
 * Created by chenyuan on 2018/3/6.
 */

class Base {}
class Derived extends Base {}

interface OrdinaryGetter {
    Base get();
}

interface DerivedGetter extends OrdinaryGetter {
    Derived get();
}

public class ConvariantReturnTypes {

    void test(DerivedGetter d) {
        Derived d2 = d.get();
    }
}
