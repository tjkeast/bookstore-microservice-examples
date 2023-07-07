package com.example.micronaut.bookstore.controller

import com.example.micronaut.bookstore.controller.model.Book
import com.example.micronaut.bookstore.controller.model.CreateBookRequest
import com.example.micronaut.bookstore.service.BookService
import com.example.micronaut.bookstore.service.model.BookSearchCriteria
import io.micronaut.data.model.Page
import io.micronaut.http.MediaType
import io.micronaut.http.annotation.*
import jakarta.inject.Inject
import reactor.core.publisher.Mono

@Controller(value = "/books", produces = [MediaType.APPLICATION_JSON])
class BookController(@Inject private val bookService: BookService) {

    @Get
    fun getBooks(@RequestBean bookSearchCriteria: BookSearchCriteria): Mono<Page<Book>> {
        return bookService.getBooks(bookSearchCriteria)
    }

    @Post
    fun createBook(@Body createBookRequest: CreateBookRequest): Mono<Book> {
        return bookService.createBook(createBookRequest)
    }
}