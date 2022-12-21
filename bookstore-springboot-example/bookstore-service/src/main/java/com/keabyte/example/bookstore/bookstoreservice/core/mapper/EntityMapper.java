package com.keabyte.example.bookstore.bookstoreservice.core.mapper;

import com.keabyte.example.bookstore.bookstoreservice.api.model.Book;
import com.keabyte.example.bookstore.bookstoreservice.persistence.entity.BookEntity;
import org.mapstruct.Mapper;

@Mapper
public interface EntityMapper {

    Book map(BookEntity book);
}
