package com.example.micronaut.bookstore.controller

import io.micronaut.http.MediaType
import io.micronaut.http.annotation.Controller
import io.micronaut.http.annotation.Get
import reactor.core.publisher.Flux
import java.util.UUID

@Controller(value = "/books", produces = [MediaType.APPLICATION_JSON])
class BookController {

    @Get
    fun getBooks(): Flux<Book> {
        return Flux.just(Book(UUID.randomUUID().toString()))
    }
}

data class Book(val id: String)