package example.micronaut.bookstore.core.mapper;

import example.micronaut.bookstore.api.model.Book;
import example.micronaut.bookstore.api.model.BookRequest;
import example.micronaut.bookstore.persistence.entity.BookEntity;
import org.mapstruct.Mapper;
import org.mapstruct.MappingTarget;

import java.util.List;

@Mapper(componentModel = "jsr330")
public interface EntityMapper {

    Book map(BookEntity book);

    BookEntity map(BookRequest request);

    void update(@MappingTarget BookEntity target, BookRequest source);

    List<Book> map(Iterable<BookEntity> book);
}
