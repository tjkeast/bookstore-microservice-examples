package example.springboot.bookstore.core.service;


import example.springboot.bookstore.api.kafka.BookProducer;
import example.springboot.bookstore.api.model.Book;
import example.springboot.bookstore.core.mapper.EntityMapper;
import example.springboot.bookstore.persistence.entity.BookEntity;
import example.springboot.bookstore.persistence.repository.BookRepository;
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