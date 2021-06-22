package com.atella.java.security.authentication;

import javax.security.auth.Subject;
import javax.security.auth.callback.CallbackHandler;
import javax.security.auth.login.LoginContext;
import javax.security.auth.login.LoginException;

/**
 * @author chenyuan
 */
public class SimpleAuthenticationExample {

    public static void main(String[] args) throws LoginException {
        String ctxName = "SimpleAuth";
        Subject subject = new Subject();
        subject.getPrincipals().add(new NamePrincipal("chenyuan"));
        CallbackHandler callbackHandler = new ConsolePasswordCallbackHandler();

        LoginContext loginContext = new LoginContext(ctxName, subject, callbackHandler);
        loginContext.login();
        loginContext.logout();
    }
}
