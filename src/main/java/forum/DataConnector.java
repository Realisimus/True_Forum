package forum;

import forum.db.TopicDataObject;
import forum.db.in_memory.TopicInMemoryDb;

public class DataConnector {

    public static TopicDataObject db = new TopicInMemoryDb();

}
