package forum.dbinterfaces.sql;

import forum.Topic;
import forum.dbinterfaces.TopicDataObject;

import java.util.List;

public class TopicSqlDb implements TopicDataObject{
    @Override
    public void save(Topic entity) {

    }

    @Override
    public Topic get(String id) {
        return null;
    }

    @Override
    public void delete(String id) {

    }

    @Override
    public List<String> getAllTopics() {
        return null;
    }
}
