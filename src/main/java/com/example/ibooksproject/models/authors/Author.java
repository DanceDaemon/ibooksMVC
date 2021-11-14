package com.example.ibooksproject.models.authors;

import com.example.ibooksproject.models.book.Book;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "authors")
public class Author {

    @Id
    private int id;

    private String firstname;
    private String middlename;
    private String lastname;
    private String inform;

    @ManyToMany(fetch = FetchType.LAZY, cascade = CascadeType.PERSIST)
    @JoinTable(name = "authors_books",
        joinColumns = {
            @JoinColumn(name = "id_authors", referencedColumnName = "id")
        },
        inverseJoinColumns = {
            @JoinColumn(name = "id_books", referencedColumnName = "id")
        }
    )
    private Set<Book> books = new HashSet<>();

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Set<Book> getBooks() {
        return books;
    }

    public void setBooks(Set<Book> books) {
        this.books = books;
    }

    public String getFirstname() {
        return firstname;
    }

    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }

    public String getMiddlename() {
        return middlename;
    }

    public void setMiddlename(String middlename) {
        this.middlename = middlename;
    }

    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public String getInform() {
        return inform;
    }

    public void setInform(String inform) {
        this.inform = inform;
    }

    @Override
    public String toString() {
        return this.getFirstname() + this.getMiddlename() + this.getLastname();
    }
}
