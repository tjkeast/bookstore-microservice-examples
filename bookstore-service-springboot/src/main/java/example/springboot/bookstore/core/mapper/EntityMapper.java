package example.springboot.bookstore.core.mapper;

import example.springboot.bookstore.api.model.Book;
import example.springboot.bookstore.persistence.entity.BookEntity;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper
public interface EntityMapper {

    Book map(BookEntity book);

    List<Book> map(Iterable<BookEntity> books);

    BookEntity map(Book book);
}
