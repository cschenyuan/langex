package chenyuan.langex.book.designpattern.Prototype;

/**
 * Created by chenyuan on 2017/4/12.
 */
public class ConcretePrototype implements Prototype {

    @Override
    public ConcretePrototype clone() {
        try {
            return (ConcretePrototype) super.clone();
        } catch (CloneNotSupportedException e) {
            e.printStackTrace();
        }
        return null;
    }

}
