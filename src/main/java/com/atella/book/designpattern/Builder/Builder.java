package com.atella.book.designpattern.Builder;

/**
 * Created by chenyuan on 2017/3/13.
 */
public abstract class Builder {

    public abstract void setPart(Object type);

    public abstract Product build();
}
