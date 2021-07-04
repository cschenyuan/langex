package chenyuan.langex.java.concurrent.collection.e1;

import java.util.concurrent.Delayed;
import java.util.concurrent.TimeUnit;

/**
 * @author chenyuan
 */
public class DelayedData implements Delayed {

    private Integer number;
    private long expireTime = System.currentTimeMillis() + 5000;

    public DelayedData(Integer number) {
        this.number = number;
    }

    public Integer getNumber() {
        return number;
    }

    /**
     * 还有多少时间可以获取到这个元素
     * @param unit
     * @return
     */
    @Override
    public long getDelay(TimeUnit unit) {
        return unit.convert(expireTime - System.currentTimeMillis(), TimeUnit.MILLISECONDS);
    }

    @Override
    public int compareTo(Delayed o) {
        DelayedData data = (DelayedData) o;
        return number.compareTo(data.number);
    }

    @Override
    public String toString() {
        return "DelayedData{" +
                "number=" + number +
                ", delayTime=" + getDelay(TimeUnit.MILLISECONDS) +
                '}';
    }
}
