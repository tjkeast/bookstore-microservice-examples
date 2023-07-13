package com.example.micronaut.bookstore.controller.model

import com.example.micronaut.bookstore.repository.entity.BookEntity
import io.swagger.v3.oas.annotations.media.Schema
import java.time.LocalDate
import java.util.*

@Schema
data class CreateBookRequest(
    @Schema
    val title: String,
    @Schema
    val author: String,
    @Schema
    val description: String? = null,
    @Schema
    val releaseDate: LocalDate,
    @Schema
    val coverageImageUrl: String? = null
) {

    fun toEntity(): BookEntity {
        return BookEntity(
            id = UUID.randomUUID().toString(),
            title = title,
            author = author,
            description = description,
            releaseDate = releaseDate,
            coverageImageUrl = coverageImageUrl
        )
    }
}