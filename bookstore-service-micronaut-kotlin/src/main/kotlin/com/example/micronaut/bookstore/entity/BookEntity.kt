package com.example.micronaut.bookstore.entity

import javax.persistence.Entity
import javax.persistence.Id

@Entity(name = "book")
class BookEntity(@Id val id: String)