package chenyuan.langex.book.designpattern.Command;

/**
 * Created by chenyuan on 2017/4/20.
 */
public class ConcreteCommandA implements Command {

    private Receiver receiver;

    public ConcreteCommandA() {
        receiver = new ReceiverA();
    }

    public void execute() {
        receiver.doAction();
    }

}
