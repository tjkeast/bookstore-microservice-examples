package com.example.micronaut.bookstore.repository.entity

import jakarta.persistence.Entity
import jakarta.persistence.Id
import java.time.LocalDate

@Entity(name = "book")
class BookEntity(
    @Id val id: String,
    val title: String,
    val author: String,
    val description: String? = "",
    val releaseDate: LocalDate,
    val coverageImageUrl: String? = null
)