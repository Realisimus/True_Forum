package db;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

public class Topic {

    private Map<Integer, Post> posts = new HashMap();

    private String name;
    private String details;
    private String author;
    private Date createdDate;
    private Date modifiedDate;

    public String getName() {
        return name;
    }

    public Post getPost(Integer id) {
        return posts.get(id);
    }

    public Map getPosts() {
        return posts;
    }

    public void addPost(Post post) {
        post.setId(posts.size() + 1);
        posts.put(post.getId(), post);
    }

    public void deletePost(Post post) {
        posts.put(post.getId(), null);
    }

}
