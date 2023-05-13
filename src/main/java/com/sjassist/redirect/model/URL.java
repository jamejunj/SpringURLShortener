package com.sjassist.redirect.model;


import java.util.Objects;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.SequenceGenerator;

@Entity
public class URL {
    @Id
    @SequenceGenerator(
        name = "url_sequence",
        sequenceName = "url_sequence"
    )
    @GeneratedValue(
        strategy = GenerationType.SEQUENCE
    )
    private Long id;
    private String url;
    private String shortString;
    private String title;
    private String description;

    public URL(){}

    public URL(String url, String title, String description, String shortString){
        this.url = url;
        this.title = title;
        this.description = description;
        this.shortString = shortString;
    }

    //getter and setter
    public long getId(){
        return this.id;
    }

    public String getShortString(){
        return this.shortString;
    }

    public String getUrl(){
        return this.url;
    }

    public String getTitle(){
        return this.title;
    }

    public String getDescription(){
        return this.description;
    }

    public void setId(Long id){
        this.id = id;
    }

    public void setUrl(String url){
        this.url = url;
    }

    public void setTitle(String title){
        this.title = title;
    }

    public void setDescription(String description){
        this.description = description;
    }

    public void setShortString(String shortString){
        this.shortString = shortString;
    }

    @Override
    public String toString(){
        return "URL{" +
                "id=" + id +
                ", url='" + url + '\'' +
                ", title='" + title + '\'' +
                ", description='" + description + '\'' +
                '}';
    }

    public boolean equals(Object o){
        if (this == o) return true;
        if (!(o instanceof URL)) return false;
        URL url = (URL) o;
        return id == url.id &&
                Objects.equals(this.url, url.url) &&
                Objects.equals(this.title, url.title) &&
                Objects.equals(this.description, url.description);
    }

    public int hashCode(){
        return Objects.hash(id, url, title, description);
    }
}
