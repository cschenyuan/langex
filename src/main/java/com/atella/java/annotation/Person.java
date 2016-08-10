package com.atella.java.annotation;

import java.lang.annotation.Annotation;

/**
 * Created by yuan on 16/6/14.
 */
@PersonType(type = "USA")
public class Person {

    public static void main(String[] args) {
        Class clazz = Person.class;
        Annotation[] annos = clazz.getAnnotations();
        for(Annotation anno : annos) {
            if (anno instanceof PersonType) {
                PersonType personType = (PersonType) anno;
                System.out.println(personType.type());
            }
        }
    }
}
