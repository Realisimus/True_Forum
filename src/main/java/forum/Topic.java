package forum;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

public class Topic {

    private String name;
    private String details;
    private String author;
    private Date createdDate;
    private Date modifiedDate;

    private Map<String, Post> posts = new HashMap();

    public Topic() {
        this.createdDate = new Date();
        this.modifiedDate = new Date();
    }

    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }

    public void addPost(String title) {
        Post post = new Post();
        post.setId(Integer.toString(posts.size() + 1));
        post.setTitle(title);
        posts.put(post.getId(), post);
    }

    public Post getPost(String id) {
        return posts.get(id);
    }

    public void deletePost(Post post) {
        posts.put(post.getId(), null);
    }


}
