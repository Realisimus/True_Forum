package forum.dbinterfaces;

import forum.User;

public interface UserDataObject {

    public User getUser(String login);
    public void addUser(User user);
}
