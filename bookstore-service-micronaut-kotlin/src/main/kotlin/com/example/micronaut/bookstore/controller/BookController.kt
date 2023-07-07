package com.example.micronaut.bookstore.controller

import com.example.micronaut.bookstore.controller.service.BookService
import com.example.micronaut.bookstore.entity.BookEntity
import io.micronaut.http.MediaType
import io.micronaut.http.annotation.Controller
import io.micronaut.http.annotation.Get
import jakarta.inject.Inject
import reactor.core.publisher.Flux
import java.awt.print.Book
import java.util.UUID

@Controller(value = "/books", produces = [MediaType.APPLICATION_JSON])
class BookController(@Inject private val bookService: BookService) {

    @Get
    fun getBooks(): Flux<BookEntity> {
        return bookService.getBooks()
    }
}