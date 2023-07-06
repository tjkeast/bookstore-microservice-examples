package com.example.micronaut.bookstore.entity

import javax.persistence.Entity
import javax.persistence.Id

@Entity
class BookEntity(@Id val id: String)