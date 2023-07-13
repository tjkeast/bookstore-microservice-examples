package com.example.micronaut.bookstore.kafka.producer

import com.example.micronaut.bookstore.controller.model.Book
import com.example.micronaut.bookstore.kafka.producer.event.KafkaEvent
import io.micronaut.configuration.kafka.annotation.KafkaClient
import io.micronaut.configuration.kafka.annotation.KafkaKey
import io.micronaut.configuration.kafka.annotation.Topic

@KafkaClient
interface BookProducer {

    companion object {
        const val TOPIC = "example.micronaut.bookstore.book"
    }

    @Topic(TOPIC)
    fun sendBook(@KafkaKey key: String, book: KafkaEvent<Book>)
}