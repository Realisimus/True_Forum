package forum.dbinterfaces;

import forum.dbinterfaces.in_memory.TopicInMemoryDb;

public class DataConnector {

    private static TopicDataObject db;

    public static synchronized TopicDataObject getDb() {
        if (db == null)
            db = new TopicInMemoryDb();
        return db;
    }
}
