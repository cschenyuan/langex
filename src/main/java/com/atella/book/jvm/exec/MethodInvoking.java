package com.atella.book.jvm.exec;

public class MethodInvoking implements InterfaceInvoking {

    // invokespecial
    public MethodInvoking() {}

    // invokestatic
    public static void invokeStatic() {}

    // invokespecial
    private void invokePrivate() {}

    // invokevirtual
    public final void invokeFinal() {}

    // invokeinterface
    public void interfaceMethod() {}

    public static void main(String[] args) {
        invokeStatic();
        InterfaceInvoking invoke1 = new MethodInvoking();
        MethodInvoking invoke2 = new MethodInvoking();
        invoke1.interfaceMethod();
        invoke2.invokePrivate();
        invoke2.invokeFinal();

    }

}

interface InterfaceInvoking {
    public void interfaceMethod();
}
