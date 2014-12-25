package forum;

public class Forum {

    public void addTopic(String name) {
        Topic topic = new Topic();
        topic.setName(name);
        topic.addPost(name);
        DataConnector.db.save(topic);
    }

    public Topic getTopic(String name) {
        return DataConnector.db.get(name);
    }

    public void deleteTopic(String id) {
        DataConnector.db.delete(id);
    }

}
