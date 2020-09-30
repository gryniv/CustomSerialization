import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import service.ByteSerialization;

import java.util.LinkedList;

public class Application {
    private static final Logger LOG = LogManager.getLogger(Application.class);

    public static void main(String[] args) {

        LinkedList<String> list = new LinkedList<>();
        list.add("Ihor");
        list.add("Gryniv!");
        ByteSerialization<LinkedList<String>> kk = new ByteSerialization<>();
        byte[] serialize = kk.serialize(list);
        LinkedList<String> linkedList = kk.deserializer(serialize);
        LOG.info("Hi, my name {} {} this is my Serialization to byte implementation.",
                linkedList.getFirst(), linkedList.getLast());
    }
}
