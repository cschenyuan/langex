package chenyuan.langex.book.conarts.jmm;

/**
 * Created by yuan on 15/12/28.
 */
public class SafeLazyInitialization {
    private static Instance instance;

    public synchronized static Instance getInstance() {
        if(instance == null)
            instance = new Instance();
        return instance;
    }
}

