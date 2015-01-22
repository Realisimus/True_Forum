package forum;

import java.util.Date;

public class Post {

    private String user;
    private String topicName;
    private Integer id;
    private String text;
    private Date createdDate;
    private Date modifiedDate;

    public Post() {
        this.createdDate = new Date();
        this.modifiedDate = new Date();
    }
    public Post(String topic) {
        this.topicName = topic;
        this.createdDate = new Date();
        this.modifiedDate = new Date();
    }

    public String getUser() {
        return user;
    }
    public void setUser(String user) {
        this.user = user;
    }

    public String getTopicName() {
        return topicName;
    }
    public void setTopicName(String topicName) {
        this.topicName = topicName;
    }

    public Integer getId() {
        return id;
    }
    public void setId(Integer id) {
        this.id = id;
    }

    public String getText() {
        return this.text;
    }
    public void setText(String text) {
        this.text = text;
        setModifiedDate();
    }

    public void setModifiedDate() {
        modifiedDate = new Date();
    }
    public Date getModifiedDate() {
        return modifiedDate;
    }

    public Date getCreatedDate() {
        return createdDate;
    }

}
