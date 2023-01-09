package example.springboot.bookstore.persistence.repository;

import example.springboot.bookstore.persistence.entity.BookEntity;
import org.springframework.data.repository.CrudRepository;

public interface BookRepository extends CrudRepository<BookEntity, Long> {
}
