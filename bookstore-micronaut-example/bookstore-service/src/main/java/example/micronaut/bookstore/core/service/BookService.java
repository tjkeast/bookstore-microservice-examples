package example.micronaut.bookstore.core.service;

import example.micronaut.bookstore.api.model.Book;
import example.micronaut.bookstore.api.model.BookRequest;
import example.micronaut.bookstore.api.model.search.BookSearchCriteria;
import example.micronaut.bookstore.api.model.search.PagedSearchResult;

public interface BookService {

    PagedSearchResult<Book> getBooks(BookSearchCriteria criteria);

    Book getBook(Long bookId);

    Book createBook(BookRequest request);

    Book updateBook(Long bookId, BookRequest request);
}
