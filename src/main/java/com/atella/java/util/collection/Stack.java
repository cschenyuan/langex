package com.atella.java.util.collection;

import java.util.LinkedList;

/**
 * Created by chenyuan on 2017/12/18.
 */
public class Stack<T> {

    private LinkedList<T> elements = new LinkedList<>();

    public T peek() { return elements.peek(); }

    public T pop() { return elements.pop(); }

    public void push(T e) { elements.push(e); }

    public boolean empty() { return elements.isEmpty(); }

    public String toString() { return elements.toString(); }

}
