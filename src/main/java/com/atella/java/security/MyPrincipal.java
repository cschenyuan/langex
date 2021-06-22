package com.atella.java.security;

import java.security.Principal;

/**
 * @author chenyuan
 */
public class MyPrincipal implements Principal {

    @Override
    public String getName() {
        return "yuan";
    }

}
