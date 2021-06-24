package chenyuan.langex.book.designpattern.Observer;

import java.util.Observer;

/**
 * Created by chenyuan on 2017/5/15.
 */
public class Client {

    public static void main(String[] args) {
        Subject subject = new Subject();
        Observer observer1 = new ObserverImpl();
        Observer observer2 = new ObserverImpl();

        subject.addObserver(observer1);
        subject.addObserver(observer2);

        subject.setChanged();
        subject.notifyObservers();
    }
}
