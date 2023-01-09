package example.micronaut.bookstore.persistence.repository;


import example.micronaut.bookstore.persistence.entity.BookEntity;
import io.micronaut.data.annotation.Repository;
import io.micronaut.data.jpa.repository.JpaSpecificationExecutor;
import io.micronaut.data.repository.PageableRepository;

@Repository
public interface BookRepository extends PageableRepository<BookEntity, Long>, JpaSpecificationExecutor<BookEntity> {
}
