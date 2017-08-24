package com.reddit.fakereddit.Model;

import org.hibernate.validator.constraints.NotEmpty;


import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.NotNull;
import java.util.Date;

@Entity
public class Link {
    @GeneratedValue(strategy= GenerationType.AUTO)
    @Id
    private long id;
    @NotEmpty
    private String title;
    @NotEmpty
    private String myLink;
    @NotEmpty
    private String userName;
      //change to date
    private Date timestamp;  //come back to this and figure out how to set it

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public Date getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(Date timestamp) {
        this.timestamp = timestamp;
    }

    public String getMyLink() {
        return myLink;
    }

    public void setMyLink(String myLink) {
        this.myLink = myLink;
    }
}
