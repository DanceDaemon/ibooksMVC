package com.example.ibooksproject.models.book;

import com.example.ibooksproject.models.authors.Author;
import com.example.ibooksproject.models.comments.BookComments;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "books")
public class Book {

    @Id
    private int id;

    private String name;
    private String annotation;

    /*private Genre genre;*/
    private int id_genre;

    @OneToMany(mappedBy = "book")
    private Set<BookComments> comments = new HashSet<>();

    @ManyToMany(mappedBy = "books", fetch = FetchType.LAZY)
    private Set<Author> authors = new HashSet<>();



    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Set<Author> getAuthors() {
        return authors;
    }

    public void setAuthors(Set<Author> authors) {
        this.authors = authors;
    }

    public String getAnnotation() {
        return annotation;
    }

    public void setAnnotation(String annotation) {
        this.annotation = annotation;
    }

    public Set<BookComments> getComments() {
        return comments;
    }

    public void setComments(Set<BookComments> comments) {
        this.comments = comments;
    }

}
