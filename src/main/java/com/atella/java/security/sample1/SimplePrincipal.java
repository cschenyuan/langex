package com.atella.java.security.sample1;

import java.io.Serializable;
import java.security.Principal;

/**
 * Created by chenyuan on 2017/8/23.
 */
public class SimplePrincipal implements Principal, Serializable {

    private String name;

    public SimplePrincipal(String name) {
        if (name == null)
            throw new NullPointerException("name can not be null");
        this.name = name;
    }

    @Override
    public String getName() {
        return this.name;
    }

}
