package com.atella.java.security;

import javax.security.auth.login.LoginContext;
import javax.security.auth.login.LoginException;

/**
 * Created by chenyuan on 2017/8/14.
 */
public class JaaSDemo {

    public static void main(String[] args) {

        LoginContext loginContext = null;

        try {
            loginContext = new LoginContext("for security");
            loginContext.login();
            System.out.println("login in");
            loginContext.logout();
            System.out.println("login out");
        } catch (LoginException e) {
            e.printStackTrace();
        }

    }

}
