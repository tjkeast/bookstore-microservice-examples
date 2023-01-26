package example.micronaut.bookstore.core.service;

import example.micronaut.bookstore.api.kafka.producer.BookProducer;
import example.micronaut.bookstore.api.model.Book;
import example.micronaut.bookstore.api.model.BookRequest;
import example.micronaut.bookstore.api.model.search.BookSearchCriteria;
import example.micronaut.bookstore.api.model.search.PagedSearchResult;
import example.micronaut.bookstore.core.mapper.EntityMapper;
import example.micronaut.bookstore.persistence.entity.BookEntity;
import example.micronaut.bookstore.persistence.repository.BookRepository;
import jakarta.inject.Inject;
import jakarta.inject.Singleton;

import javax.transaction.Transactional;
import java.util.UUID;

@Singleton
public class BookService {

    @Inject
    private BookRepository bookRepository;

    @Inject
    private EntityMapper entityMapper;

    @Inject
    private BookProducer bookProducer;

    @Transactional
    public PagedSearchResult<Book> getBooks(BookSearchCriteria criteria) {
        return PagedSearchResult.from(bookRepository.findAll(criteria, criteria.toPageable()), entityMapper::map);
    }

    public Book getBook(Long bookId) {
        return entityMapper.map(bookRepository.findById(bookId)
                .orElseThrow(() -> new IllegalArgumentException("Book with ID %s does not exist".formatted(bookId))));
    }

    public Book createBook(BookRequest request) {
        BookEntity book = entityMapper.map(request);
        Book newBook = entityMapper.map(bookRepository.save(book));
        bookProducer.sendBook(UUID.randomUUID().toString(), newBook);
        return newBook;
    }

    public Book updateBook(Long bookId, BookRequest request) {
        BookEntity book = bookRepository.findById(bookId)
                .orElseThrow(() -> new IllegalArgumentException("Book with ID %s does not exist".formatted(bookId)));
        entityMapper.update(book, request);

        return entityMapper.map(bookRepository.update(book));
    }
}
