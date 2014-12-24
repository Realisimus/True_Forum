package db;

import java.util.Date;

public class Post {

    private String topic;
    private Integer id;
    private String author;
    private String title;
    private String text;
    private Date createdDate;
    private Date modifiedDate;

    public Integer getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }
}
