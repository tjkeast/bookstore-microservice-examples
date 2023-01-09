package example.springboot.bookstore.core.mapper;

import example.springboot.bookstore.api.model.Book;
import example.springboot.bookstore.persistence.entity.BookEntity;
import org.mapstruct.Mapper;

@Mapper
public interface EntityMapper {

    Book map(BookEntity book);
}
