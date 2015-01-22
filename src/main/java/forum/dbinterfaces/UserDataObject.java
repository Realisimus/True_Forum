package forum.dbinterfaces;

import forum.User;

public interface UserDataObject {

    public User getUser(String login);
    public User getUserById(String id);
    public void addUser(User user);
}
