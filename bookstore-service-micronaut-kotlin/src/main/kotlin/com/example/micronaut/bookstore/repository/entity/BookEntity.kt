package com.example.micronaut.bookstore.repository.entity

import java.time.LocalDate
import javax.persistence.Entity
import javax.persistence.Id

@Entity(name = "book")
class BookEntity(
    @Id val id: String,
    val title: String,
    val author: String,
    val description: String? = "",
    val releaseDate: LocalDate,
    val coverageImageUrl: String? = null
)