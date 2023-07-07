package com.example.micronaut.bookstore.service

import com.example.micronaut.bookstore.controller.model.Book
import com.example.micronaut.bookstore.controller.model.CreateBookRequest
import com.example.micronaut.bookstore.repository.BookRepository
import com.example.micronaut.bookstore.service.model.BookSearchCriteria
import io.micronaut.data.model.Page
import jakarta.inject.Inject
import jakarta.inject.Singleton
import reactor.core.publisher.Mono

@Singleton
class BookService(@Inject private val bookRepository: BookRepository) {

    fun getBooks(bookSearchCriteria: BookSearchCriteria): Mono<Page<Book>> {
        return bookRepository.findAll(bookSearchCriteria, bookSearchCriteria.toPageable())
            .map { it.map { z -> Book.from(z) } }
    }

    fun createBook(createBookRequest: CreateBookRequest): Mono<Book> {
        return bookRepository.save(createBookRequest.toEntity()).map { Book.from(it) }
    }
}