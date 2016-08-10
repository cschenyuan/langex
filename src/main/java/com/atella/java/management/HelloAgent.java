package com.atella.java.management;

import java.lang.management.ManagementFactory;
import javax.management.MBeanServer;
import javax.management.ObjectName;

/**
 * Created by yuan on 16/3/7.
 */
public class HelloAgent {

    public static void main(String[] args) throws Exception {
        HelloAgent agent = new HelloAgent();
        agent.createAgent();

        Thread.sleep(500 * 1000);
    }

    public MBeanServer createAgent() throws Exception {
        MBeanServer mbs = ManagementFactory.getPlatformMBeanServer();
        HelloMBean hello = new Hello();

        ObjectName name = new ObjectName("com.atella.java.management:type=Hello");
        mbs.registerMBean(hello, name);

        return mbs;
    }

    public void createConnector(MBeanServer agent) {

    }
}
