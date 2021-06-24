package chenyuan.langex.java.security.authentication;

import java.security.Principal;

/**
 * @author chenyuan
 */
public class NamePrincipal implements Principal {

    private String name;

    public NamePrincipal(String name) {
        this.name = name;
    }

    @Override
    public String getName() {
        return name;
    }

}
