package example.bookstore.micronaut.core.mapper;

import example.bookstore.micronaut.api.model.Book;
import example.bookstore.micronaut.api.model.BookRequest;
import example.bookstore.micronaut.persistence.entity.BookEntity;
import org.mapstruct.Mapper;
import org.mapstruct.MappingTarget;

import java.util.Collection;

@Mapper(componentModel = "jsr330")
public interface EntityMapper {

    Book map(BookEntity book);

    BookEntity map(BookRequest request);

    void update(@MappingTarget BookEntity target, BookRequest source);

    Collection<Book> map(Iterable<BookEntity> book);
}
