package example.micronaut.bookstore.api.controller.api;

import example.micronaut.bookstore.api.controller.BookController;
import example.micronaut.bookstore.api.model.Book;
import example.micronaut.bookstore.api.model.BookRequest;
import example.micronaut.bookstore.api.model.search.BookSearchCriteria;
import example.micronaut.bookstore.api.model.search.PagedSearchResult;
import example.micronaut.bookstore.persistence.entity.BookEntity_;
import io.micronaut.test.extensions.junit5.annotation.MicronautTest;
import jakarta.inject.Inject;
import org.junit.jupiter.api.Test;
import util.RequestTestFixture;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

@MicronautTest
public class BookControllerTest {

    @Inject
    private BookController bookController;

    @Test
    void getBooksTest() {
        PagedSearchResult<Book> result = bookController.getBooks(BookSearchCriteria.builder().build());
        assertEquals(0, result.getResultSize());
    }

    @Test
    void getBooksTest_searchWithQuery() {
        BookRequest request = RequestTestFixture.createBookRequest();
        bookController.createBook(request);

        BookSearchCriteria bookSearchCriteria = BookSearchCriteria.builder()
                .query("frank")
                .queryFields(List.of(BookEntity_.AUTHOR))
                .build();
        PagedSearchResult<Book> page = bookController.getBooks(bookSearchCriteria);
        assertEquals(1, page.getResultSize());
        Book book = page.getResults().get(0);
        assertEquals(request.getTitle(), book.getTitle());
    }

    @Test
    void createBookTest() {
        BookRequest request = RequestTestFixture.createBookRequest();
        Book book = bookController.createBook(request);
        assertNotNull(book.getId());
    }

    @Test
    void updateBookTest() {
        BookRequest createRequest = RequestTestFixture.createBookRequest();
        Book book = bookController.createBook(createRequest);

        BookRequest updateRequest = RequestTestFixture.createBookRequest();
        updateRequest.setDescription("New description");
        bookController.updateBook(book.getId(), updateRequest);

        Book updatedBook = bookController.getBook(book.getId());
        assertEquals("New description", updatedBook.getDescription());
    }
}
