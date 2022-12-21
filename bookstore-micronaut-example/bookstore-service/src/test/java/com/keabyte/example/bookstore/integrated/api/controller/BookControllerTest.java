package com.keabyte.example.bookstore.integrated.api.controller;

import com.keabyte.example.bookstore.api.controller.BookController;
import com.keabyte.example.bookstore.api.model.Book;
import com.keabyte.example.bookstore.api.model.BookRequest;
import com.keabyte.example.bookstore.api.model.search.BookSearchCriteria;
import com.keabyte.example.bookstore.api.model.search.PagedSearchResult;
import com.keabyte.example.bookstore.utility.RequestTestFixture;
import io.micronaut.test.extensions.junit5.annotation.MicronautTest;
import jakarta.inject.Inject;
import org.junit.jupiter.api.Test;

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
