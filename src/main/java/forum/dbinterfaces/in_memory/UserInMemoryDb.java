package forum.dbinterfaces.in_memory;

import forum.User;
import forum.dbinterfaces.UserDataObject;
import java.util.Collection;

public class UserInMemoryDb extends Db implements UserDataObject{

    public UserInMemoryDb() {
        addUser(new User("admin", "12345"));
    }

    @Override
    public User getUser(String login) {
        if (Db.users.containsKey(login))
            return Db.users.get(login);
        else
            return new User(null, null);
    }

    @Override
    public User getUserById(String id) {
        Collection<User> userList = Db.users.values();
        for (User user:userList)
            if (id.equals(user.getSessionId())) return user;
        return new User(null, null);
    }

    @Override
    public void addUser(User user) {
        Db.users.put(user.login(), user);
    }
}
