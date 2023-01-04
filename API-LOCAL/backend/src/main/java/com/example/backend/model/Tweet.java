package com.example.backend.model;

import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "tweets")
public class Tweet {
    @Id
    private ObjectId id;
    
    private String text;
    private String created_at;
    private int retweets;
    private int favoritos;
    private String place;
    private String entities;
    private String user;

    public Tweet(){

    }
    
    public Tweet(ObjectId id, String text, String created_at, int retweets, int favoritos, String place,
            String entities, String user) {
        this.id = id;
        this.text = text;
        this.created_at = created_at;
        this.retweets = retweets;
        this.favoritos = favoritos;
        this.place = place;
        this.entities = entities;
        this.user = user;
    }

    public ObjectId getId() {
        return id;
    }

    public void setId(ObjectId id) {
        this.id = id;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public String getCreated_at() {
        return created_at;
    }

    public void setCreated_at(String created_at) {
        this.created_at = created_at;
    }

    public int getRetweets() {
        return retweets;
    }

    public void setRetweets(int retweets) {
        this.retweets = retweets;
    }

    public int getFavoritos() {
        return favoritos;
    }

    public void setFavoritos(int favoritos) {
        this.favoritos = favoritos;
    }

    public String getPlace() {
        return place;
    }

    public void setPlace(String place) {
        this.place = place;
    }

    public String getEntities() {
        return entities;
    }

    public void setEntities(String entities) {
        this.entities = entities;
    }

    public String getUser() {
        return user;
    }

    public void setUser(String user) {
        this.user = user;
    }

    

}
