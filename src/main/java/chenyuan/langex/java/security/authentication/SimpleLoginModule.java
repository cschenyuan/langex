package chenyuan.langex.java.security.authentication;

import javax.security.auth.Subject;
import javax.security.auth.callback.*;
import javax.security.auth.login.LoginException;
import javax.security.auth.spi.LoginModule;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

/**
 * @author chenyuan
 */
public class SimpleLoginModule implements LoginModule {

    private static Map<String, String> userAndPasswordStore = new HashMap<>();

    static {
        userAndPasswordStore.put("chenyuan", "test123");
        userAndPasswordStore.put("robot", "321tset");
    }

    private Subject subject;
    private CallbackHandler callbackHandler;
    private Map<String, ?> sharedState;
    private Map<String, ?> options;

    private boolean loginSucceeded;
    private boolean commitSucceeded;

    @Override
    public void initialize(Subject subject, CallbackHandler callbackHandler, Map<String, ?> sharedState, Map<String, ?> options) {
        this.subject = subject;
        this.callbackHandler = callbackHandler;
        this.sharedState = sharedState;
        this.options = options;
    }

    @Override
    public boolean login() throws LoginException {
        String user = subject.getPrincipals().iterator().next().getName();
        PasswordCallback passwdCallback = new PasswordCallback("Password for " + user + ": ", true);
        Callback[] callbacks = new Callback[]{passwdCallback};

        try {
            callbackHandler.handle(callbacks);
            char[] password = passwdCallback.getPassword();
            if (!userAndPasswordStore.containsKey(user)) {
                loginSucceeded = false;
            } else {
                String storedPassword = userAndPasswordStore.get(user);
                loginSucceeded = storedPassword.contains(String.valueOf(password));
            }
        } catch (IOException | UnsupportedCallbackException e) {
            e.printStackTrace();
        }
        System.out.println("login result: " + loginSucceeded);
        return loginSucceeded;
    }

    @Override
    public boolean commit() throws LoginException {
        if (!loginSucceeded) {
            return false;
        }
        commitSucceeded = true;
        System.out.println("commit successfully.");
        return true;
    }

    private void clearStates() {
        loginSucceeded = false;
        commitSucceeded = false;
    }

    @Override
    public boolean abort() throws LoginException {
        if (!loginSucceeded) {
            return false;
        }

        if (commitSucceeded) {
            logout();
        }
        clearStates();
        System.out.println("login abort");
        return true;
    }

    @Override
    public boolean logout() throws LoginException {
        subject.getPrincipals().clear();
        clearStates();
        System.out.println("logout");
        return false;
    }
}
