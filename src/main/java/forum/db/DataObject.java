package forum.db;

public interface DataObject<T> {
    public void save(T entity);
    public T get(String id);
    public void delete(String id);
}
