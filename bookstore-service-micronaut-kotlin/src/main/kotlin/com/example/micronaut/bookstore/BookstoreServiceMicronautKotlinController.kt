package com.example.micronaut.bookstore

import io.micronaut.http.annotation.Controller
import io.micronaut.http.annotation.Get
import io.micronaut.http.HttpStatus

@Controller("/bookstoreServiceMicronautKotlin")
class BookstoreServiceMicronautKotlinController {

    @Get(uri="/", produces=["text/plain"])
    fun index(): String {
        return "Example Response"
    }
}