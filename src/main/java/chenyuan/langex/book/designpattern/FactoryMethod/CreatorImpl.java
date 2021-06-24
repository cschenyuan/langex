package chenyuan.langex.book.designpattern.FactoryMethod;

/**
 * Created by chenyuan on 2017/3/1.
 */
public class CreatorImpl implements Creator {

    public <T extends Product> T create(Class<T> cls) {
        Product product = null;
        try {
            product = (Product) Class.forName(cls.getName()).newInstance();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return (T) product;
    }

}
