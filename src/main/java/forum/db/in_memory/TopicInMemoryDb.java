package forum.db.in_memory;

import forum.Topic;
import forum.db.TopicDataObject;

public class TopicInMemoryDb extends Db implements TopicDataObject {

    @Override
    public void save(Topic topic) {
        Db.topics.put(topic.getName(), topic);
    }

    @Override
    public Topic get(String id) {
        return Db.topics.get(id);
    }

    @Override
    public void delete(String id) {
        Db.topics.remove(id);
    }
}
