package com.example.micronaut.bookstore.controller.service

import com.example.micronaut.bookstore.entity.BookEntity
import com.example.micronaut.bookstore.repository.BookRepository
import jakarta.inject.Inject
import jakarta.inject.Singleton
import reactor.core.publisher.Flux
import javax.transaction.Transactional

@Singleton
class BookService(@Inject private val bookRepository: BookRepository) {

    fun getBooks() : Flux<BookEntity> {
        return bookRepository.findAll();
    }
}