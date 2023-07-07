package com.example.micronaut.bookstore.repository

import com.example.micronaut.bookstore.entity.BookEntity
import io.micronaut.data.annotation.Repository
import io.micronaut.data.repository.reactive.ReactiveStreamsCrudRepository
import io.micronaut.data.repository.reactive.ReactorCrudRepository

@Repository
interface BookRepository : ReactorCrudRepository<BookEntity, String>{
}