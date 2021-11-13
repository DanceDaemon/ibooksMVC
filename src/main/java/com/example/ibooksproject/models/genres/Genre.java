package com.example.ibooksproject.models.genres;

import com.example.ibooksproject.models.book.Book;

import javax.persistence.*;
import java.util.Set;

@Entity(name = "genres")
public class Genre {

    @Id
    private int id;
    private String name;

    @OneToMany(mappedBy = "genre")
    //@OneToMany
    private Set<Book> books;

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

    public Set<Book> getBooks() {
        return books;
    }

    public void setBooks(Set<Book> books) {
        this.books = books;
    }
}
