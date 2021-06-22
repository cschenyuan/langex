package com.atella.java.security.sample1;

import javax.security.auth.Subject;
import javax.security.auth.login.LoginContext;
import javax.security.auth.login.LoginException;
import java.io.File;
import java.net.URISyntaxException;
import java.security.Principal;
import java.security.PrivilegedAction;
import java.security.Security;

/**
 * Created by chenyuan on 2017/8/21.
 */
public class ExampleAction  implements PrivilegedAction {

    @Override
    public Object run() {
        File file = new File("foo.txt");
        System.out.println(file.getAbsolutePath());

        if (file.exists()) {
            System.out.println("the file " + file.getName() + " exists.");
        }
        return null;
    }


    public static void main(String[] args) {
        LoginContext lc = null;
        try {
            lc = new LoginContext("Sample");
            lc.login();
            Subject subject = lc.getSubject();
            System.out.println("Principals: " + subject.getPrincipals().stream()
                    .map(Principal::getName)
                    .reduce((l,r) -> l+","+r));
            Subject.doAs(subject, new ExampleAction());
            lc.logout();
        } catch (LoginException e) {
            e.printStackTrace();
        }
    }
}
