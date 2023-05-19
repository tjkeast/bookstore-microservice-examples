package com.keabyte.bookstore.core.mapper;

import com.keabyte.bookstore.api.model.Book;
import com.keabyte.bookstore.persistence.entity.BookEntity;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper
public interface EntityMapper {

    Book map(BookEntity book);

    List<Book> map(Iterable<BookEntity> books);

    BookEntity map(Book book);
}
