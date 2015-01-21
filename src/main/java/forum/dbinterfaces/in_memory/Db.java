package forum.dbinterfaces.in_memory;

import forum.Topic;
import forum.User;

import java.util.HashMap;
import java.util.Map;

class Db {

    protected static Map<String, Topic> topics = new HashMap<>();
    protected static Map<String, User> users = new HashMap<>();
}
