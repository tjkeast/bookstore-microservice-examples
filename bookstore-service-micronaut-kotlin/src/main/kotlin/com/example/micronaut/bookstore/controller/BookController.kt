package com.example.micronaut.bookstore.controller

import com.example.micronaut.bookstore.controller.model.Book
import com.example.micronaut.bookstore.controller.model.CreateBookRequest
import com.example.micronaut.bookstore.service.BookService
import com.example.micronaut.bookstore.service.model.BookSearchCriteria
import io.micronaut.data.model.Page
import io.micronaut.http.MediaType
import io.micronaut.http.annotation.*

@Controller(value = "/books", produces = [MediaType.APPLICATION_JSON])
class BookController(private val bookService: BookService) {

    @Get
    fun getBooks(@RequestBean bookSearchCriteria: BookSearchCriteria): Page<Book> {
        return bookService.getBooks(bookSearchCriteria)
    }

    @Post
    fun createBook(@Body createBookRequest: CreateBookRequest): Book {
        return bookService.createBook(createBookRequest)
    }
}