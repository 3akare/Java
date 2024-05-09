package com.books.bookstore.book;

import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

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

    //Delete a book
    public boolean deleteBook(String bookTitle) {
        try {
            Optional<Book> optionalBook = bookRepository.findByBookTitle(bookTitle);
            Book bookToDelete = optionalBook.orElseThrow();
            bookRepository.delete(bookToDelete);
        } catch (Exception e) {
            return false;
        }
        return true;
    }

    //Update a book
    @Transactional
    public boolean updateBook(Book book, String bookTitle) {
        try {
            Book bookFromDB = bookRepository.findByBookTitle(bookTitle).orElseThrow(() -> new IllegalStateException("Book titled " + book.getBookTitle() + " cannot be found"));
            bookFromDB.setBookDescription(book.getBookDescription());
            bookFromDB.setBookTitle(book.getBookTitle());
            bookFromDB.setAuthors(book.getAuthors());
            bookFromDB.setGenre(book.getGenre());
            bookFromDB.setRating(book.getRating());
            bookFromDB.setReleaseDate(book.getReleaseDate());
//            bookRepository.save(bookFromDB);
        } catch (Exception e) {
            return false;
        }
        return true;
    }
}
