package forum;

import forum.dbinterfaces.DataConnector;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class Forum {

    public User getUser(String login) {
        return DataConnector.getUsersDb().getUser(login);
    }

    public void addTopic(Post post) {
        Topic topic = new Topic(post);
        DataConnector.getTopicsDb().save(topic);
    }

    public void changeTopic(Topic topic, String oldTopicName) {
        deleteTopic(oldTopicName);
        DataConnector.getTopicsDb().save(topic);
    }

    public Topic getTopic(String topic) {
        return DataConnector.getTopicsDb().get(topic);
    }

    public List<String> getAllTopics() {
        return DataConnector.getTopicsDb().getAllTopics();
    }

    public void deleteTopic(String topic) {
        DataConnector.getTopicsDb().delete(topic);
    }

}