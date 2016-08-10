package com.atella.java.management;

/**
 * Created by yuan on 16/3/7.
 */
public interface HelloMBean {
    public String getName();

    public void setName(String name);

    public boolean getStatus();

    public long getMemorySize();

    public void printMetrics();
}
