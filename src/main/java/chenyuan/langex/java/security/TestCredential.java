package chenyuan.langex.java.security;

import javax.security.auth.DestroyFailedException;
import javax.security.auth.Destroyable;
import javax.security.auth.RefreshFailedException;
import javax.security.auth.Refreshable;

/**
 * @author chenyuan
 */
public class TestCredential implements Refreshable, Destroyable {

    private String type = "DSA";

    @Override
    public boolean isCurrent() {
        return false;
    }

    @Override
    public void refresh() throws RefreshFailedException {

    }

    @Override
    public void destroy() throws DestroyFailedException {

    }

    @Override
    public boolean isDestroyed() {
        return false;
    }
}
