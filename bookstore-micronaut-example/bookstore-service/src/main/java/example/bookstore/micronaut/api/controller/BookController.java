package example.bookstore.micronaut.api.controller;

import example.bookstore.micronaut.api.model.Book;
import example.bookstore.micronaut.api.model.BookRequest;
import example.bookstore.micronaut.api.model.search.BookSearchCriteria;
import example.bookstore.micronaut.api.model.search.PagedSearchResult;
import example.bookstore.micronaut.core.service.BookService;
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
