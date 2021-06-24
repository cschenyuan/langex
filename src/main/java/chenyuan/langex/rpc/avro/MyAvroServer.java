package chenyuan.langex.rpc.avro;

import org.apache.avro.Protocol;
import org.apache.avro.Protocol.Message;
import org.apache.avro.generic.GenericRecord;
import org.apache.avro.generic.GenericRecordBuilder;
import org.apache.avro.ipc.HttpServer;
import org.apache.avro.ipc.Server;
import org.apache.avro.ipc.generic.GenericResponder;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.File;

public class MyAvroServer extends GenericResponder {

    private static Logger log = LoggerFactory.getLogger(MyAvroServer.class);
    private Protocol protocol;

    public MyAvroServer(Protocol protocol) {
        super(protocol);
        this.protocol = protocol;
    }

    public Object respond(Message message, Object request) throws Exception {
        GenericRecord req = (GenericRecord) request;
        GenericRecord reMessage = null;
        if (message.getName().equals("sayHello")) {
            Object name = req.get("name2");
            Object name2 = ((GenericRecord) name).get("name1");
            //  do something...
            //取得返回值的类型
            reMessage = new GenericRecordBuilder(protocol.getType("nameMessage")).build();

            //直接构造回复
            reMessage.put("name1", "Hello, " + name2.toString());
            log.info(reMessage.toString());
        }
        return reMessage;
    }

    public static void main(String[] args) throws Exception {
        int port = 8088;
        try {
            Server server = new HttpServer(
                    new MyAvroServer(Protocol.parse(
//							new File("helloword.json"))),
                            new File("data/avro/service.avro"))),
                    port);
            server.start();
            server.join();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
