package com.atella.java.security;

import org.junit.Test;

import java.security.AccessController;

/**
 * @author chenyuan
 */
public class ProtectionDomainTest {

    @Test
    public void test01() {
        System.out.println(Object.class.getProtectionDomain());
        System.out.println(getClass().getProtectionDomain());
        AccessController.getContext().getDomainCombiner();
    }
}
