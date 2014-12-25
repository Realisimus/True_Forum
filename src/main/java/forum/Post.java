package forum;

import java.util.Date;

public class Post {

    private String topic;
    private String id;
    private String author;
    private String title;
    private String text;
    private Date createdDate;
    private Date modifiedDate;

    public Post() {
        this.createdDate = new Date();
        this.modifiedDate = new Date();
    }

    public String getId() {
        return id;
    }
    public void setId(String id) {
        this.id = id;
    }

    public void setTitle(String title) {
        this.title = title;
    }
}
