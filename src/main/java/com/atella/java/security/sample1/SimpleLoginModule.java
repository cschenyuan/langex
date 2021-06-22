package com.atella.java.security.sample1;

import javax.security.auth.Subject;
import javax.security.auth.callback.CallbackHandler;
import javax.security.auth.login.LoginException;
import javax.security.auth.spi.LoginModule;
import java.util.Map;

/**
 * Created by chenyuan on 2017/8/22.
 */
public class SimpleLoginModule implements LoginModule {

    private Subject subject;
    private CallbackHandler callbackHandler;
    private Map<String, ?> sharedState;
    private Map<String, ?> options;

    @Override
    public void initialize(Subject subject,
                           CallbackHandler callbackHandler,
                           Map<String, ?> sharedState, Map<String, ?> options) {
        this.subject = subject;
        this.callbackHandler = callbackHandler;
        this.sharedState = sharedState;
        this.options = options;
        if (subject != null) {
            SimplePrincipal principal = new SimplePrincipal("Sample");
            subject.getPrincipals().add(principal);
        }
    }

    @Override
    public boolean login() throws LoginException {
        System.out.println("Login Authenticated.");
        return true;
    }

    @Override
    public boolean commit() throws LoginException {
        System.out.println("Committed");
        return true;
    }

    @Override
    public boolean abort() throws LoginException {
        return false;
    }

    @Override
    public boolean logout() throws LoginException {
        System.out.println("Logout successfully.");
        return true;
    }
}
