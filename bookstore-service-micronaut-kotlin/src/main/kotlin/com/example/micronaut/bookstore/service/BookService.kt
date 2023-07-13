package com.example.micronaut.bookstore.service

import com.example.micronaut.bookstore.controller.model.Book
import com.example.micronaut.bookstore.controller.model.CreateBookRequest
import com.example.micronaut.bookstore.kafka.producer.BookProducer
import com.example.micronaut.bookstore.kafka.producer.event.KafkaEvent
import com.example.micronaut.bookstore.repository.BookRepository
import com.example.micronaut.bookstore.service.model.BookSearchCriteria
import io.micronaut.data.model.Page
import jakarta.inject.Singleton
import jakarta.transaction.Transactional

@Singleton
open class BookService(private val bookRepository: BookRepository, private val bookProducer: BookProducer) {

    @Transactional
    open fun getBooks(bookSearchCriteria: BookSearchCriteria): Page<Book> {
        return bookRepository.findAll(bookSearchCriteria, bookSearchCriteria.toPageable())
            .map { Book.from(it) }
    }

    fun createBook(createBookRequest: CreateBookRequest): Book {
        val book = Book.from(bookRepository.save(createBookRequest.toEntity()))
        publishBookEvent(book)
        return book
    }

    private fun publishBookEvent(book: Book) {
        bookProducer.sendBook(book.id, KafkaEvent.of(book))
    }
}