package com.atella.book.designpattern.Builder;

/**
 * Created by chenyuan on 2017/3/13.
 */
public class ConcreteBuilder extends Builder {

    private Object type;

    @Override
    public void setPart(Object type) {
        this.type = type;
    }

    @Override
    public Product build() {
        return new Product();
    }
}
