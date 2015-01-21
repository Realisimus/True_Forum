package forum.dbinterfaces;

import forum.User;
import forum.dbinterfaces.in_memory.TopicInMemoryDb;
import forum.dbinterfaces.in_memory.UserInMemoryDb;

public class DataConnector {

    private static TopicDataObject topicsDb;
    private static UserDataObject usersDb;

    public static synchronized TopicDataObject getTopicsDb() {
        if (topicsDb == null)
            topicsDb = new TopicInMemoryDb();
        return topicsDb;
    }

    public static synchronized UserDataObject getUsersDb() {
        if (usersDb == null)
            usersDb = new UserInMemoryDb();
        return usersDb;
    }

}
