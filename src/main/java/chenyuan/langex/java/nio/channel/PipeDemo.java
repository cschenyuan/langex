package chenyuan.langex.java.nio.channel;

import org.junit.Test;

import java.io.IOException;
import java.nio.channels.Pipe;

/**
 * Created by chenyuan on 2017/11/21.
 */
public class PipeDemo {

    @Test
    public void test() throws IOException {
        Pipe pipe = Pipe.open();
        Pipe.SinkChannel sink = pipe.sink();
        Pipe.SourceChannel source = pipe.source();

    }
}
