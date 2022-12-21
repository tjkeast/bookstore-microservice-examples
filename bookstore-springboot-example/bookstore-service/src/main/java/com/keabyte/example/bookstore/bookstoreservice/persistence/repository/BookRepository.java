package com.keabyte.example.bookstore.bookstoreservice.persistence.repository;

import com.keabyte.example.bookstore.bookstoreservice.persistence.entity.BookEntity;
import org.springframework.data.repository.CrudRepository;

public interface BookRepository extends CrudRepository<BookEntity, Long> {
}
