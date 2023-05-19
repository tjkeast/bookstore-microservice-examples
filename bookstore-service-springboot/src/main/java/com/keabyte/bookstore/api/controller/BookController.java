package com.keabyte.bookstore.api.controller;

import com.keabyte.bookstore.api.model.Book;
import com.keabyte.bookstore.core.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/books")
public class BookController {

    @Autowired
    private BookService bookService;

    @GetMapping
    public List<Book> getBooks() {
        return bookService.getBooks();
    }

    @GetMapping("/{bookId}")
    public Book getBookById(@PathVariable Long bookId) {
        return bookService.getBook(bookId);
    }

    @PostMapping
    public Book createBook(@RequestBody Book bookRequest) {
        return bookService.createBook(bookRequest);
    }
}
