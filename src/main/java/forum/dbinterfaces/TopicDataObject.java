package forum.dbinterfaces;

import forum.Topic;

import java.util.List;

public interface TopicDataObject extends DataObject<Topic> {

    public List<String> getAllTopics();
}
