package example.springboot.bookstore.core.service;


import example.springboot.bookstore.api.model.Book;
import example.springboot.bookstore.core.mapper.EntityMapper;
import example.springboot.bookstore.persistence.repository.BookRepository;
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