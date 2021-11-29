package com.example.ibooksproject.models.book;

import com.example.ibooksproject.models.genres.Genre;
import com.example.ibooksproject.models.authors.Author;
import com.example.ibooksproject.models.comments.BookComments;
import com.example.ibooksproject.models.user.User;

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

    @ManyToOne
    //@JoinTable(name = "genres")
    private Genre genre;

    @OneToMany(mappedBy = "book")
    private Set<BookComments> comments = new HashSet<>();

    @ManyToMany(mappedBy = "books", fetch = FetchType.LAZY)
    private Set<Author> authors = new HashSet<>();

    @Column(name = "average_rating")
    private int averageRating;

    @Column(name = "count_likes")
    private int countLikes;

    @Column(name = "count_dislikes")
    private int countDislikes;

    @ManyToMany
    @JoinTable(name = "books_likes",
            joinColumns = {
                    @JoinColumn(name = "book_id", referencedColumnName = "id")
            },
            inverseJoinColumns = {
                    @JoinColumn(name = "user_id", referencedColumnName = "id")
            }
    )
    private Set<User> likes;

    @ManyToMany
    @JoinTable(name = "books_dislikes",
            joinColumns = {
                    @JoinColumn(name = "book_id", referencedColumnName = "id")
            },
            inverseJoinColumns = {
                    @JoinColumn(name = "user_id", referencedColumnName = "id")
            }
    )
    private Set<User> dislikes;

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

    public Genre getGenre() {
        return genre;
    }

    public void setGenre(Genre genre) {
        this.genre = genre;
    }

    public int getAverageRating() {
        return averageRating;
    }

    public void setAverageRating(int averageRating) {
        this.averageRating = averageRating;
    }

    public int getCountLikes() {
        return countLikes;
    }

    public void setCountLikes(int countLikes) {
        this.countLikes = countLikes;
    }

    public int getCountDislikes() {
        return countDislikes;
    }

    public void setCountDislikes(int countDislikes) {
        this.countDislikes = countDislikes;
    }

    public Set<User> getLikes() {
        return likes;
    }

    public void setLikes(Set<User> likes) {
        this.likes = likes;
    }

    public Set<User> getDislikes() {
        return dislikes;
    }

    public void setDislikes(Set<User> dislikes) {
        this.dislikes = dislikes;
    }
}
