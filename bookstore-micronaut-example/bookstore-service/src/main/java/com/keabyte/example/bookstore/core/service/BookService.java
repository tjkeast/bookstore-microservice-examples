package com.keabyte.example.bookstore.core.service;

import com.keabyte.example.bookstore.api.model.Book;
import com.keabyte.example.bookstore.api.model.BookRequest;
import com.keabyte.example.bookstore.api.model.search.BookSearchCriteria;
import com.keabyte.example.bookstore.api.model.search.PagedSearchResult;

public interface BookService {

    PagedSearchResult<Book> getBooks(BookSearchCriteria criteria);

    Book getBook(Long bookId);

    Book createBook(BookRequest request);

    Book updateBook(Long bookId, BookRequest request);
}
