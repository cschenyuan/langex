package chenyuan.langex.book.designpattern.Proxy.dynamic;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Proxy;

/**
 * Created by chenyuan on 2017/4/6.
 */
public class DynamicProxy<T> {

    private InvocationHandler handler;
    private IAdvice advice;

    public static <T> T newProxyInstance(Subject subject) {
        ClassLoader classLoader = subject.getClass().getClassLoader();
        Class<?>[] interfaces = subject.getClass().getInterfaces();
        InvocationHandler handler = new MyInvocationHandler(subject);
        IAdvice advice = new BeforeAdvice();
        advice.exec();
        return (T) Proxy.newProxyInstance(
                classLoader, interfaces, handler);
    }


}
