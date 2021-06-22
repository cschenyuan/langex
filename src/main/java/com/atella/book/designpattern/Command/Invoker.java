package com.atella.book.designpattern.Command;

/**
 * Created by chenyuan on 2017/4/20.
 */
public class Invoker {

    private Command command;

    public void setCommand(Command command) {
        this.command = command;
    }

    public void execute() {
        command.execute();
    }

}
