package com.books.bookstore.book;

import jakarta.websocket.server.PathParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/books")
public class BooksController {

    private final BookServices bookServices;

    @Autowired
    public BooksController(BookServices bookServices) {
        this.bookServices = bookServices;
    }

    @GetMapping
    public List<Book> getBooks() {
        return bookServices.getBooks();
    }

    @PostMapping
    public String createBooks(@RequestBody Book book) throws Exception {
        boolean status = true;

        status = bookServices.createBook(book);
        if (status) return "{statusCode: 200, statusMsg: 'Success'}";
        throw new Exception("Couldn't Create a new Book titled " + book.getBookTitle());
    }

    @DeleteMapping
    public String deleteBook(@PathParam("bookTitle") String bookTitle) throws Exception {
        boolean status = true;
//        System.out.println(bookTitle);
        status = bookServices.deleteBook(bookTitle);
        if (status) return "{statusCode: 200, statusMsg: 'Success'}";
        throw new Exception("Couldn't Delete " + bookTitle);
    }

    @PatchMapping
    public String updateBook(@RequestBody Book book, @PathParam("bookTitle") String bookTitle) throws Exception {
        boolean status = true;
        status = bookServices.updateBook(book, bookTitle);
        if (status) return "{statusCode: 200, statusMsg: 'Success'}";
        throw new Exception("Couldn't Update " + book.getBookTitle());
    }
}
