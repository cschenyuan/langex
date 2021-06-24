package chenyuan.langex.book.designpattern.Command;

/**
 * Created by chenyuan on 2017/4/20.
 */
public class ReceiverA implements Receiver {

    public void doAction() {
        System.out.println("Action was done by ReceiverA");
    }

}
