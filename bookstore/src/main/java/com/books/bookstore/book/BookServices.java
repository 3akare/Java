package com.books.bookstore.book;

import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BookServices {
    private final BookRepository bookRepository;

    public BookServices(BookRepository bookRepository) {
        this.bookRepository = bookRepository;
    }

    //Get all books
    public List<Book> getBooks() {
        return bookRepository.findAll();
    }

    //Create a book
    public boolean createBook(Book newBook) {
        try {
//            Book newBook = new Book(bookTitle, bookDescription, releaseDate, authors, genre, rating);
            bookRepository.save(newBook);
        } catch (Exception e) {
            return false;
        }
        return true;
    }
}
