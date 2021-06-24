package chenyuan.langex.java.management;

/**
 * Created by yuan on 16/3/7.
 */
public class Hello implements HelloMBean {

    private String name = "hello-mbean";
    private boolean status = true;
    public long memSize = 100;

    @Override
    public String getName() {
        return name;
    }

    @Override
    public void setName(String name) {
        this.name = name;
    }

    @Override
    public boolean getStatus() {
        return this.status;
    }

    @Override
    public long getMemorySize() {
        return this.memSize;
    }

    @Override
    public void printMetrics() {
        System.out.println(
                String.format("Name: %s\nStatus: %s\nMemory Size: %d\n",
                        name, status, memSize)
        );
    }
}