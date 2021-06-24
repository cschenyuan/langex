package chenyuan.langex.book.designpattern.FactoryMethod;

/**
 * Created by chenyuan on 2017/3/1.
 */
public interface Creator {

    public <T extends Product> T create(Class<T> cls);

}
