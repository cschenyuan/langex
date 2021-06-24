package chenyuan.langex.book.designpattern.Command;

/**
 * Created by chenyuan on 2017/4/20.
 */
public class Client {

    public static void main(String[] args) {
        Invoker shell = new Invoker();
        Command command1 = new ConcreteCommandA();

        shell.setCommand(command1);
        shell.execute();

        Command command2 = new ConcreteCommandB();
        shell.setCommand(command2);
        command2.execute();
    }
}
