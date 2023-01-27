package e2e;

import example.micronaut.bookstore.api.controller.BookController;
import example.micronaut.bookstore.api.model.Book;
import example.micronaut.bookstore.api.model.BookRequest;
import example.micronaut.bookstore.api.model.search.BookSearchCriteria;
import example.micronaut.bookstore.api.model.search.PagedSearchResult;
import io.micronaut.core.annotation.NonNull;
import io.micronaut.test.extensions.junit5.annotation.MicronautTest;
import io.micronaut.test.support.TestPropertyProvider;
import jakarta.inject.Inject;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import org.testcontainers.containers.KafkaContainer;
import org.testcontainers.containers.PostgreSQLContainer;
import org.testcontainers.utility.DockerImageName;

import java.time.LocalDate;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

@MicronautTest
@TestInstance(TestInstance.Lifecycle.PER_CLASS)
public class BookTest implements TestPropertyProvider {

    static KafkaContainer kafka = new KafkaContainer(DockerImageName.parse("confluentinc/cp-kafka:7.3.0"));

    static PostgreSQLContainer<?> postgres = new PostgreSQLContainer<>(DockerImageName.parse("postgres:14.5"));

    @Inject
    private BookController bookController;

    @NonNull
    @Override
    public Map<String, String> getProperties() {
        kafka.start();
        postgres.start();

        return Map.of(
                "kafka.bootstrap.servers", kafka.getBootstrapServers(),
                "datasources.default.url", postgres.getJdbcUrl(),
                "datasources.default.driverClassName", postgres.getDriverClassName(),
                "datasources.default.username", postgres.getUsername(),
                "datasources.default.password", postgres.getPassword());
    }

    @Test
    void test() {
        Book book;
        BookRequest request = BookRequest.builder()
                .title("Lord of the Rings")
                .author("J. R. R. Tolkien")
                .description("Hobbit")
                .releaseDate(LocalDate.of(1954, 7, 29))
                .build();

        // POST /books
        {
            book = bookController.createBook(request);
            assertNotNull(book.getId());
        }

        // GET /books/{id}
        {
            book = bookController.getBook(book.getId());
            assertEquals(request.getTitle(), book.getTitle());
        }

        // GET /books
        {
            PagedSearchResult<Book> page = bookController.getBooks(BookSearchCriteria.builder().build());
            assertEquals(1, page.getResultSize());
        }

        // PUT /books/{id}
        {
            request.setDescription("New description");
            book = bookController.updateBook(book.getId(), request);
            assertEquals(request.getDescription(), book.getDescription());
        }
    }
}
