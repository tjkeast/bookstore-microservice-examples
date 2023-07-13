package com.example.micronaut.bookstore.listener

import com.example.micronaut.bookstore.repository.BookRepository
import com.example.micronaut.bookstore.repository.entity.BookEntity
import io.micronaut.context.annotation.Requires
import io.micronaut.context.event.StartupEvent
import io.micronaut.runtime.event.annotation.EventListener
import jakarta.inject.Inject
import jakarta.inject.Singleton
import java.time.LocalDate
import java.util.*

@Singleton
@Requires(env = ["dev-test"])
open class TestDataCreator(@Inject val bookRepository: BookRepository) {

    @EventListener
    open fun init(event: StartupEvent) {
        bookRepository.saveAll((1..10).map {
            BookEntity(
                id = UUID.randomUUID().toString(),
                author = "Frank Herbert",
                releaseDate = LocalDate.now(),
                title = "Dune"
            )
        })
    }
}