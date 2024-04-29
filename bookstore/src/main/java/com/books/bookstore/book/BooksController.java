package com.books.bookstore.book;

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
    List<Book> getBooks() {
        return bookServices.getBooks();
    }

    @PostMapping
    String createBooks(@RequestBody Book book) throws Exception {
        boolean status = true;
        System.out.println(book);

        status = bookServices.createBook(book);
        if (status) return "{statusCode: 200, statusMsg: 'Success'}";
        throw new Exception("Couldn't Create a new Book");
    }

}
