package forum.dbinterfaces.in_memory;


import forum.User;
import forum.dbinterfaces.UserDataObject;

public class UserInMemoryDb extends Db implements UserDataObject{

    public UserInMemoryDb() {
        addUser(new User("admin", "12345"));
    }

    @Override
    public User getUser(String login) {
        if (Db.users.containsKey(login))
            return Db.users.get(login);
        else
            return new User("","");
    }

    @Override
    public void addUser(User user) {
        Db.users.put(user.login(), user);
    }
}
