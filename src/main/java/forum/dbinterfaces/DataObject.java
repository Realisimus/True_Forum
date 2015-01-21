package forum.dbinterfaces;

import forum.User;

public interface DataObject<T> {
    public void save(T entity);
    public T get(String id);
    public void delete(String id);
}
