package forum;

import forum.dbinterfaces.DataConnector;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class Forum {

    public void addTopic(Post post) {
        Topic topic = new Topic(post);
        DataConnector.getDb().save(topic);
    }

    public void changeTopic(Topic topic, String oldTopicName) {
        deleteTopic(oldTopicName);
        DataConnector.getDb().save(topic);
    }

    public Topic getTopic(String topic) {
        return DataConnector.getDb().get(topic);
    }

    public List<String> getAllTopics() {
        return DataConnector.getDb().getAllTopics();
    }

    public void deleteTopic(String topic) {
        DataConnector.getDb().delete(topic);
    }

}