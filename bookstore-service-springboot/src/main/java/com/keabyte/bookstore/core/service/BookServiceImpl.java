package com.keabyte.bookstore.core.service;


import com.keabyte.bookstore.api.kafka.BookProducer;
import com.keabyte.bookstore.api.model.Book;
import com.keabyte.bookstore.core.mapper.EntityMapper;
import com.keabyte.bookstore.persistence.entity.BookEntity;
import com.keabyte.bookstore.persistence.repository.BookRepository;
import org.mapstruct.factory.Mappers;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BookServiceImpl implements BookService {

    @Autowired
    private BookRepository bookRepository;

    @Autowired
    private BookProducer bookProducer;

    private EntityMapper mapper = Mappers.getMapper(EntityMapper.class);

    public List<Book> getBooks() {
        return mapper.map(bookRepository.findAll());
    }

    @Override
    public Book getBook(Long bookId) {
        return mapper.map(bookRepository.findById(bookId).orElseThrow(() -> new IllegalStateException("Book not found")));
    }

    @Override
    public Book createBook(Book bookRequest) {
        BookEntity bookEntity = mapper.map(bookRequest);
        Book book = mapper.map(bookRepository.save(bookEntity));
        bookProducer.send(book);
        return book;
    }
}