package com.keabyte.example.bookstore.bookstoreservice.core.service;


import com.keabyte.example.bookstore.bookstoreservice.api.model.Book;
import com.keabyte.example.bookstore.bookstoreservice.core.mapper.EntityMapper;
import com.keabyte.example.bookstore.bookstoreservice.persistence.repository.BookRepository;
import org.mapstruct.factory.Mappers;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class BookServiceImpl implements BookService {

    @Autowired
    private BookRepository bookRepository;

    private EntityMapper mapper = Mappers.getMapper(EntityMapper.class);

    @Override
    public Book getBook(Long bookId) {
        return mapper.map(bookRepository.findById(bookId).orElseThrow());
    }
}