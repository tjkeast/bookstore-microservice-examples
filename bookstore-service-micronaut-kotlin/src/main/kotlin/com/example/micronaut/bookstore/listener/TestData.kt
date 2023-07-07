package com.example.micronaut.bookstore.listener

import com.example.micronaut.bookstore.entity.BookEntity
import com.example.micronaut.bookstore.repository.BookRepository
import io.micronaut.context.annotation.Requires
import io.micronaut.context.event.StartupEvent
import io.micronaut.runtime.event.annotation.EventListener
import jakarta.inject.Inject
import jakarta.inject.Singleton
import java.util.*

@Singleton
@Requires(env = ["dev-test"])
open class TestData(@Inject val bookRepository: BookRepository) {

    @EventListener
    open fun init(event: StartupEvent) {
        bookRepository.saveAll((1..10).map { BookEntity(id = UUID.randomUUID().toString()) }).subscribe()
    }
}