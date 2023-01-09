package example.bookstore.micronaut.core.service;

import example.bookstore.micronaut.api.model.Book;
import example.bookstore.micronaut.api.model.BookRequest;
import example.bookstore.micronaut.api.model.search.BookSearchCriteria;
import example.bookstore.micronaut.api.model.search.PagedSearchResult;

public interface BookService {

    PagedSearchResult<Book> getBooks(BookSearchCriteria criteria);

    Book getBook(Long bookId);

    Book createBook(BookRequest request);

    Book updateBook(Long bookId, BookRequest request);
}
