package example.bookstore.micronaut.core.service;

import example.bookstore.micronaut.api.model.Book;
import example.bookstore.micronaut.api.model.BookRequest;
import example.bookstore.micronaut.api.model.search.BookSearchCriteria;
import example.bookstore.micronaut.api.model.search.PagedSearchResult;
import example.bookstore.micronaut.core.mapper.EntityMapper;
import example.bookstore.micronaut.persistence.entity.BookEntity;
import example.bookstore.micronaut.persistence.repository.BookRepository;
import jakarta.inject.Inject;
import jakarta.inject.Singleton;

import javax.transaction.Transactional;

@Singleton
public class BookServiceImpl implements BookService {

    @Inject
    private BookRepository bookRepository;

    @Inject
    private EntityMapper entityMapper;

    @Transactional
    @Override
    public PagedSearchResult<Book> getBooks(BookSearchCriteria criteria) {
        return PagedSearchResult.from(bookRepository.findAll(criteria, criteria.toPageable()), entityMapper::map);
    }

    @Override
    public Book getBook(Long bookId) {
        return entityMapper.map(bookRepository.findById(bookId)
                .orElseThrow(() -> new IllegalArgumentException("Book with ID %s does not exist".formatted(bookId))));
    }

    @Override
    public Book createBook(BookRequest request) {
        BookEntity book = entityMapper.map(request);
        return entityMapper.map(bookRepository.save(book));
    }

    @Override
    public Book updateBook(Long bookId, BookRequest request) {
        BookEntity book = bookRepository.findById(bookId)
                .orElseThrow(() -> new IllegalArgumentException("Book with ID %s does not exist".formatted(bookId)));
        entityMapper.update(book, request);

        return entityMapper.map(bookRepository.update(book));
    }
}
