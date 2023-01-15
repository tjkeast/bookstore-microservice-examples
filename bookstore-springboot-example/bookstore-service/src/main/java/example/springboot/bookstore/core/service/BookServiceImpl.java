package example.springboot.bookstore.core.service;


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
        BookEntity book = mapper.map(bookRequest);
        return mapper.map(bookRepository.save(book));
    }
}