package forum.dbinterfaces.in_memory;

import forum.Topic;
import forum.dbinterfaces.TopicDataObject;

import java.util.ArrayList;
import java.util.List;

public class TopicInMemoryDb extends Db implements TopicDataObject {

    @Override
    public void save(Topic topic) {
        Db.topics.put(topic.getPost(1).getTopicName(), topic);
    }

    @Override
    public Topic get(String id) {
        return Db.topics.get(id);
    }

    @Override
    public void delete(String id) {
        Db.topics.remove(id);
    }

    @Override
    public List<String> getAllTopics() {
        List<String> topicNames = new ArrayList<>();
        for (String topicName : Db.topics.keySet())
            topicNames.add(topicName);
        return topicNames;
    }
}
