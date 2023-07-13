package com.example.micronaut.bookstore.util

import com.example.micronaut.bookstore.controller.model.CreateBookRequest
import java.time.LocalDate

class TestFixture {

    companion object {
        fun bookRequest(): CreateBookRequest {
            return CreateBookRequest(
                author = "Frank Herber",
                releaseDate = LocalDate.now(),
                title = "Dune"
            )
        }
    }
}