package example.bookstore.micronaut.persistence.repository;


import example.bookstore.micronaut.persistence.entity.BookEntity;
import io.micronaut.data.annotation.Repository;
import io.micronaut.data.jpa.repository.JpaSpecificationExecutor;
import io.micronaut.data.repository.PageableRepository;

@Repository
public interface BookRepository extends PageableRepository<BookEntity, Long>, JpaSpecificationExecutor<BookEntity> {
}
