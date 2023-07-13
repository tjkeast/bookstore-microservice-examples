package com.example.micronaut.bookstore.controller.model

import com.example.micronaut.bookstore.repository.entity.BookEntity
import io.micronaut.serde.annotation.Serdeable
import java.time.LocalDate

@Serdeable
data class Book(
    val id: String,
    val title: String,
    val author: String,
    val description: String?,
    val releaseDate: LocalDate,
    val coverageImageUrl: String?
) {
    companion object {
        fun from(source: BookEntity): Book {
            return Book(
                id = source.id,
                title = source.title,
                author = source.author,
                releaseDate = source.releaseDate,
                description = source.description,
                coverageImageUrl = source.coverageImageUrl
            )
        }
    }
}