package com.keabyte.bookstore.core.service;


import com.keabyte.bookstore.api.kafka.BookProducer;
import com.keabyte.bookstore.api.model.Book;
import com.keabyte.bookstore.core.mapper.EntityMapper;
import com.keabyte.bookstore.persistence.entity.BookEntity;
import com.keabyte.bookstore.persistence.repository.BookRepository;
import lombok.RequiredArgsConstructor;
import org.mapstruct.factory.Mappers;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class BookServiceImpl implements BookService {

    private final BookRepository bookRepository;

    private final BookProducer bookProducer;

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