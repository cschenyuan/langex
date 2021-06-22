package com.atella.java.util;

import org.junit.Test;

import java.util.function.Supplier;

/**
 * Created by yuan on 2016/12/9.
 */
public class SupplierTest {

    @Test
    public void test() {
        Supplier<Object> objectSupplier = Object::new;
        objectSupplier.get();
    }
}
