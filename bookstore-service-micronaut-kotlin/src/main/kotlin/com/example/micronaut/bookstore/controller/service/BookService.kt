package com.example.micronaut.bookstore.controller.service

import com.example.micronaut.bookstore.controller.service.model.BookSearchCriteria
import com.example.micronaut.bookstore.entity.BookEntity
import com.example.micronaut.bookstore.repository.BookRepository
import io.micronaut.data.model.Page
import jakarta.inject.Inject
import jakarta.inject.Singleton
import reactor.core.publisher.Mono

@Singleton
class BookService(@Inject private val bookRepository: BookRepository) {

    fun getBooks(bookSearchCriteria: BookSearchCriteria) : Mono<Page<BookEntity>> {
        return bookRepository.findAll(bookSearchCriteria, bookSearchCriteria.toPageable())
    }
}