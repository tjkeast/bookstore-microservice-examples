package example.springboot.bookstore.api.controller;

import example.springboot.bookstore.api.model.Book;
import example.springboot.bookstore.core.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.Collections;
import java.util.List;

@RestController
public class BookController {

    @Autowired
    private BookService bookService;

    @GetMapping("/books")
    public List<Book> getBooks() {
        return Collections.emptyList();
    }

    @GetMapping("/books/{bookId}")
    public Book getBookById(@PathVariable Long bookId) {
        return bookService.getBook(bookId);
    }
}
