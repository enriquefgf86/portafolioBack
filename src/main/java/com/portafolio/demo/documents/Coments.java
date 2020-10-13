package com.portafolio.demo.documents;

import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class Coments {
@Id
private String id=new ObjectId().toString();
    private String comments;

    @DateTimeFormat(iso=DateTimeFormat.ISO.DATE_TIME)
    private Date releaseDate;

    private String name ;


    public Coments() {
//        this.id = id;
//        this.comments = comments;
//        this.releaseDate = releaseDate;
//        this.name = name;
    }
////////////////////////////////////getters y setters//////////////////////
    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getComments() {
        return comments;
    }

    public void setComments(String comments) {
        this.comments = comments;
    }

    public Date getReleaseDate() {
        return releaseDate;
    }

    public void setReleaseDate(Date releaseDate) {
        this.releaseDate = releaseDate;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
