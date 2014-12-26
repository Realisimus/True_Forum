package forum;

import java.util.ArrayList;
import java.util.List;

public class Topic {

    private List<Post> posts = new ArrayList<>();

    public Topic(Post post) {
        post.setId(1);
        posts.add(post);
    }

    public void addPost(Post post) {
        post.setId(posts.size() + 1);
        posts.add(post);
    }

    public Post getPost(Integer id) {
        return posts.get(id - 1);
    }

    public List<Post> getAllPosts() {
        return posts;
    }

    public void deletePost(Integer id) {
        posts.get(id - 1).setText("Deleted");
    }


}
