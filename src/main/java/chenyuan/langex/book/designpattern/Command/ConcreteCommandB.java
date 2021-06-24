package chenyuan.langex.book.designpattern.Command;

/**
 * Created by chenyuan on 2017/4/20.
 */
public class ConcreteCommandB implements Command {

    private Receiver receiver;

    public ConcreteCommandB() {
        receiver = new ReceiverB();
    }

    public void execute() {
        Receiver coordinator = new ReceiverA();
        coordinator.doAction();
        receiver.doAction();
    }

}
