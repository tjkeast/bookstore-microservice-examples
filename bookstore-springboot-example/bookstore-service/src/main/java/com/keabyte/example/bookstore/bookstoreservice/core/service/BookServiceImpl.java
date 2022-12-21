package com.keabyte.example.bookstore.bookstoreservice.core.service;


import com.keabyte.example.bookstore.bookstoreservice.api.model.Book;
import org.springframework.stereotype.Service;

@Service
public class BookServiceImpl implements BookService {

    @Override
    public Book getBook(Long bookId) {
        return Book.builder().build();
    }
}