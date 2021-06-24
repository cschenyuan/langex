package chenyuan.langex.java.management;

import javax.management.*;
import javax.management.remote.JMXConnector;
import javax.management.remote.JMXConnectorFactory;
import javax.management.remote.JMXServiceURL;
import java.util.Set;
import java.util.TreeSet;

/**
 * Created by yuan on 16/3/10.
 */
public class Client {

    // The JMX client needs a notification handler, to listen for and to process any
    // notifications that might be sent by the MBeans that are registered in the JMX agent's
    // MBean server. The JMX client's notification handler is an instance of the
    // NotificationListener interface
    public static class ClientListener implements NotificationListener {

        @Override
        public void handleNotification(Notification notification, Object handback) {
            print("\nReceived notification:");
            print("\tClassName: " + notification.getClass().getName());
            print("\tSource: " + notification.getSource());
            print("\tType: " + notification.getType());
            print("\tMessage: " + notification.getMessage());
            if (notification instanceof AttributeChangeNotification) {
                AttributeChangeNotification acn =
                        (AttributeChangeNotification) notification;
                print("\tAttributeName: " + acn.getAttributeName());
                print("\tAttributeType: " + acn.getAttributeType());
                print("\tNewValue: " + acn.getNewValue());
                print("\tOldValue: " + acn.getOldValue());
            }
        }

    }

    public static void print(String msg) {
        System.out.print(msg);
    }

    public static void main(String[] args) throws Exception {
        // JMXServiceURL represents the location at which the connector client expects to
        // find the connector server. This URL allows the connector client to
        // retrieve the RMI connector server stub jmxrmi from the RMI registry
        // running on port 9999 of the local host, and to connect to the RMI connector server.
        JMXServiceURL url =
                new JMXServiceURL("service:jmx:rmi:///jndi/rmi://:9999/jmxrmi");

        // The connector client, jmxc,is an instance of JMXConnector, created by connect()
        // method of JMXConnectorFactory.
        JMXConnector jmxc = JMXConnectorFactory.connect(url, null);

        // A way to talk to a MBean server
        MBeanServerConnection mbsc = jmxc.getMBeanServerConnection();
        print("Domains:");
        String[] domains = mbsc.getDomains();
        for(String domain : domains) {
            print("\tDomain = " + domain);
        }
        print("\tDefault domain: " + mbsc.getDefaultDomain());
        print("\tMBean count = " + mbsc.getMBeanCount());
        print("\nQuery MBeanServer MBeans:");
        Set<ObjectName> names =
                new TreeSet<>(mbsc.queryNames(null, null));
        for(ObjectName name : names) {
            print("\tName = " + name.toString());
        }

        // The client accesses the Hello MBean in the MBean server through the MBean server
        // connection by creating an MBean proxy. This MBean proxy is local to the client,
        // and emulates the remote MBean.
        ObjectName mbeanName =
                new ObjectName("com.atella.java.management:type=Hello");
        HelloMBean mBeanProxy =
                JMX.newMBeanProxy(mbsc, mbeanName, HelloMBean.class, true);

        print("\tAdd Notification Listener");
        ClientListener listener = new ClientListener();
        mbsc.addNotificationListener(mbeanName, listener, null, null);

        print("\nCacheSize = " + mBeanProxy.getMemorySize());

        mBeanProxy.setName("HGCS-009");

        print("\nWaiting for notification...");
        Thread.sleep(2000);
        print("Current Name = " + mBeanProxy.getName());
    }

}
