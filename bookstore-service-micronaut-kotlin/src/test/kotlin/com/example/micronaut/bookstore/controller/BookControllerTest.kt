package com.example.micronaut.bookstore.controller

import com.example.micronaut.bookstore.service.model.BookSearchCriteria
import com.example.micronaut.bookstore.util.TestFixture
import io.micronaut.test.extensions.junit5.annotation.MicronautTest
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

@MicronautTest
class BookControllerTest(
    private val bookController: BookController
) {


    @Test
    fun `given no books should return empty page`() {
        val page = bookController.getBooks(BookSearchCriteria(null, null))

        assertThat(page)
            .isNotNull
            .isEmpty()
    }

    @Test
    fun `given a book is created should return the new book`() {
        val req = TestFixture.bookRequest()
        val book = bookController.createBook(req)

        assertThat(book).isNotNull
        assertThat(book.author).isEqualTo(req.author)
        assertThat(book.title).isEqualTo(req.title)
    }
}
