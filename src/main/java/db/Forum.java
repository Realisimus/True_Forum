package db;

import java.util.HashMap;
import java.util.Map;

public class Forum {

    private Map<String, Topic> forum = new HashMap();

    public void addTopic(Topic topic) {
        forum.put(topic.getName(), topic);
    }

    public Topic getTopic(String name) {
        return forum.get(name);
    }

}
