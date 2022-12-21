package com.keabyte.example.bookstore.bookstoreservice.core.service;


import com.keabyte.example.bookstore.bookstoreservice.api.model.Book;

public interface BookService {

    Book getBook(Long bookId);

}
