package com.atella.java.security;

import org.junit.Test;

import javax.security.auth.AuthPermission;
import javax.security.auth.Subject;
import javax.security.auth.kerberos.KerberosPrincipal;
import java.io.*;
import java.security.AccessControlContext;
import java.security.AccessController;
import java.security.Principal;
import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

/**
 * Created by chenyuan on 2017/8/21.
 */
public class SubjectDemo {

    @Test
    public void testSubject() {
        Subject subject = new Subject();
        Principal principal = null;
        Object credential = null;

        // backed by Subject
        subject.getPrincipals().add(principal);
        subject.getPublicCredentials().add(credential);

        // not backed by Subject
        Set<Principal> p = subject.getPrincipals(Principal.class);
    }

    @Test
    public void testAcc() {
        AccessControlContext acc = AccessController.getContext();
        Subject subject = Subject.getSubject(acc);
    }

    @Test
    public void testAuthPermission() {
        AuthPermission perm = new AuthPermission("test");
    }

    @Test
    public void testSerialization() throws Exception {
        Set<KerberosPrincipal> principals = Collections.singleton(new KerberosPrincipal("tester@ATELLA"));
        Set<Object> credentials = Collections.singleton(new TestCredential());
        Subject subject = new Subject(true, principals, credentials, Collections.EMPTY_SET);
        System.out.println(subject);

        ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("data/subject.txt"));
        oos.writeObject(subject);
        oos.close();
    }

    @Test
    public void testDeserialization() throws Exception {
        ObjectInputStream ois = new ObjectInputStream(new FileInputStream("data/subject.txt"));
        Subject subject = (Subject) ois.readObject();

        System.out.println(subject.toString());
    }

}
