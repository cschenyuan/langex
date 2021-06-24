package chenyuan.langex.java.dp.observer;

import com.google.common.eventbus.EventBus;
import com.google.common.eventbus.Subscribe;
import org.junit.Test;

/**
 * Created by chenyuan on 2018/7/31.
 */
public class EventBusTest {

    private static class SimpleEvent {

        private String msg;

        public SimpleEvent(String msg) {
            this.msg = msg;
        }

        public String getMsg() {
            return msg;
        }
    }

    private static class EventListener {

        @Subscribe
        public void listen(SimpleEvent event) {
            System.out.println("Received an event: " + event.getMsg());
        }
    }

    @Test
    public void test() {
        EventBus eventBus = new EventBus("test");
        EventListener listener = new EventListener();

        eventBus.register(listener);
        eventBus.post(new SimpleEvent("start"));
        eventBus.post(new SimpleEvent("running"));
        eventBus.post(new SimpleEvent("end"));
    }

    public static void main(String[] args) {
        EventBusTest test = new EventBusTest();
        test.test();
    }

}
