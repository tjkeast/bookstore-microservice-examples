package com.example.micronaut.bookstore.controller

import com.example.micronaut.bookstore.controller.service.BookService
import com.example.micronaut.bookstore.controller.service.model.BookSearchCriteria
import com.example.micronaut.bookstore.entity.BookEntity
import io.micronaut.data.model.Page
import io.micronaut.http.MediaType
import io.micronaut.http.annotation.Controller
import io.micronaut.http.annotation.Get
import io.micronaut.http.annotation.RequestBean
import jakarta.inject.Inject
import reactor.core.publisher.Flux
import reactor.core.publisher.Mono
import java.awt.print.Book
import java.util.UUID

@Controller(value = "/books", produces = [MediaType.APPLICATION_JSON])
class BookController(@Inject private val bookService: BookService) {

    @Get
    fun getBooks(@RequestBean bookSearchCriteria: BookSearchCriteria): Mono<Page<BookEntity>> {
        return bookService.getBooks(bookSearchCriteria)
    }
}