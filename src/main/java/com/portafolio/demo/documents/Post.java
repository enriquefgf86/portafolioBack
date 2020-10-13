package com.portafolio.demo.documents;

import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Document(collection = "Post")
public class Post {

    @Id
    private String id=new ObjectId().toString();
    private String name;
    private String text;
    private String description;
    private String technologies;
    private List<String>images;
    private List<String>videos;

    @DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME)
    private Date date=new Date();

    private List<Coments> allComments=new ArrayList<>();



    public Post(String id, String name, String text, String description, String technologies, List<String> images,
                List<String> videos, Date date, List<Coments> allComments) {
        this.id = id;
        this.name = name;
        this.text = text;
        this.description = description;
        this.images = images;
        this.videos = videos;
        this.date = date;
        this.allComments = allComments;
        this.technologies=technologies;
    }

    public List<Coments> getAllComments() {
        return allComments;
    }

    public void setAllComments(List<Coments> allComments) {
        this.allComments = allComments;
    }


    public String getTechnologies() {
        return technologies;
    }

    public void setTechnologies(String technologies) {
        this.technologies = technologies;
    }
    public List<String> getImages() {
        return images;
    }

    public void setImages(List<String> images) {
        this.images = images;
    }

    public List<String> getVideos() {
        return videos;
    }

    public void setVideos(List<String> videos) {
        this.videos = videos;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

}
