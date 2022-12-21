package com.keabyte.example.bookstore.api.controller;

import com.keabyte.example.bookstore.api.model.Book;
import com.keabyte.example.bookstore.api.model.BookRequest;
import com.keabyte.example.bookstore.api.model.search.BookSearchCriteria;
import com.keabyte.example.bookstore.api.model.search.PagedSearchResult;
import com.keabyte.example.bookstore.core.service.BookService;
import io.micronaut.http.MediaType;
import io.micronaut.http.annotation.*;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.inject.Inject;

@Controller(value = "/books", produces = MediaType.APPLICATION_JSON)
@Tag(name = "book")
public class BookController {

    @Inject
    private BookService bookService;

    @Get
    public PagedSearchResult<Book> getBooks(@RequestBean BookSearchCriteria criteria) {
        return bookService.getBooks(criteria);
    }

    @Get("/{bookId}")
    public Book getBook(Long bookId) {
        return bookService.getBook(bookId);
    }

    @Post
    public Book createBook(@Body BookRequest request) {
        return bookService.createBook(request);
    }

    @Put("/{bookId}")
    public Book updateBook(Long bookId, @Body BookRequest request) {
        return bookService.updateBook(bookId, request);
    }
}
