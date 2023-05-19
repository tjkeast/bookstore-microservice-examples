package com.keabyte.bookstore.core.service;


import com.keabyte.bookstore.api.model.Book;

import java.util.List;

public interface BookService {

    List<Book> getBooks();

    Book getBook(Long bookId);

    Book createBook(Book book);
}
