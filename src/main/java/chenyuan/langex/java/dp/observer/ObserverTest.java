package chenyuan.langex.java.dp.observer;

import java.util.Observable;
import java.util.Observer;

/**
 * Created by yuan on 16/7/26.
 */
public class ObserverTest {

    public static void main(String[] args) {
        Subject subject = new Subject();
        Observer ob1 = new MyObserver(1);
        subject.addObserver(ob1);
        Observer ob2 = new MyObserver(2);
        subject.addObserver(ob2);

        for (int i=0;i<10;i++) {
            subject.changeState(i);
        }
    }
}

class Subject extends Observable {
    private Integer state;

    public Subject() { this.state = 0;}

    public int getState() {
        return this.state;
    }

    public void changeState(int state) {
        if (this.state != state) {
            this.state = state;
            setChanged();
        }
        notifyObservers();
    }
}

class MyObserver implements Observer {
    private int id;

    public MyObserver(int id) {
        this.id = id;
    }

    @Override
    public void update(Observable ob,Object data) {
        System.out.println("Observer[" + this.id + "] state has changed to " + ((Subject) ob).getState());
    }
}