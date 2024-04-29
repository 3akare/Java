package com.books.bookstore.book;

import jakarta.persistence.*;

import java.time.LocalDate;
import java.util.List;

@Entity
public class Book {
    @Id
    @SequenceGenerator(name = "sequence_generator", allocationSize = 1, sequenceName = "sequence_generator")
    @GeneratedValue(generator = "sequence_generator", strategy = GenerationType.IDENTITY)
    private Long id;
    private String bookTitle;
    private String bookDescription;
    private LocalDate releaseDate;
    private List<String> authors;
    private List<String> genre;
    private Integer rating;

    public Book() {
    }

    ;

    public Book(Long id, String bookTitle, String bookDescription, LocalDate releaseDate, List<String> authors, List<String> genre, Integer rating) {
        this.id = id;
        this.bookTitle = bookTitle;
        this.bookDescription = bookDescription;
        this.releaseDate = releaseDate;
        this.authors = authors;
        this.genre = genre;
        this.rating = rating;
    }

    public Book(String bookTitle, String bookDescription, LocalDate releaseDate, List<String> authors, List<String> genre, Integer rating) {
        this.bookTitle = bookTitle;
        this.bookDescription = bookDescription;
        this.releaseDate = releaseDate;
        this.authors = authors;
        this.genre = genre;
        this.rating = rating;
    }

    public String getBookTitle() {
        return bookTitle;
    }

    public void setBookTitle(String bookTitle) {
        this.bookTitle = bookTitle;
    }

    public String getBookDescription() {
        return bookDescription;
    }

    public void setBookDescription(String bookDescription) {
        this.bookDescription = bookDescription;
    }

    public LocalDate getReleaseDate() {
        return releaseDate;
    }

    public void setReleaseDate(LocalDate releaseDate) {
        this.releaseDate = releaseDate;
    }

    public List<String> getAuthors() {
        return authors;
    }

    public void setAuthors(List<String> authors) {
        this.authors = authors;
    }

    public List<String> getGenre() {
        return genre;
    }

    public void setGenre(List<String> genre) {
        this.genre = genre;
    }

    public Integer getRating() {
        return rating;
    }

    public void setRating(Integer rating) {
        this.rating = rating;
    }

    @Override
    public String toString() {
        return "Books{" +
                "bookTitle='" + bookTitle + '\'' +
                ", bookDescription='" + bookDescription + '\'' +
                ", releaseDate=" + releaseDate +
                ", authors=" + authors +
                ", genre=" + genre +
                ", rating=" + rating +
                '}';
    }
}
