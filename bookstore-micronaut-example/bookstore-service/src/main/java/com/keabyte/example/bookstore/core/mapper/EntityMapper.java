package com.keabyte.example.bookstore.core.mapper;

import com.keabyte.example.bookstore.api.model.Book;
import com.keabyte.example.bookstore.api.model.BookRequest;
import com.keabyte.example.bookstore.persistence.entity.BookEntity;
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
