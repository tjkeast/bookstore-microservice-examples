package com.keabyte.bookstore.persistence.repository;

import com.keabyte.bookstore.persistence.entity.BookEntity;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BookRepository extends CrudRepository<BookEntity, Long> {
}
