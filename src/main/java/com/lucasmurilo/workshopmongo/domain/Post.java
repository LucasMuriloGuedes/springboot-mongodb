package com.lucasmurilo.workshopmongo.domain;

import com.lucasmurilo.workshopmongo.dto.AuthorDto;
import com.lucasmurilo.workshopmongo.dto.CommentDTO;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Document
public class Post implements Serializable {
    private String id;
    private Date date;
    private String title;
    private String body;
    private AuthorDto user;

    private List<CommentDTO> comments = new ArrayList<>();


    public Post(String id, Date date, String title, String body, AuthorDto authorDto) {
        this.id = id;
        this.date = date;
        this.title = title;
        this.body = body;
        this.user = authorDto;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getBody() {
        return body;
    }

    public void setBody(String body) {
        this.body = body;
    }

    public AuthorDto getUser() {
        return user;
    }

    public void setUser(AuthorDto user) {
        this.user = user;
    }

    public List<CommentDTO> getComments() {
        return comments;
    }

    public void setComments(List<CommentDTO> comments) {
        this.comments = comments;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Post post = (Post) o;

        return id != null ? id.equals(post.id) : post.id == null;
    }

    @Override
    public int hashCode() {
        return id != null ? id.hashCode() : 0;
    }
}
