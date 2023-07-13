package com.example.micronaut.bookstore.kafka.producer.event

import io.micronaut.serde.annotation.Serdeable
import java.time.ZonedDateTime
import java.util.*

/**
 * Wrapper for kafka event data
 */
@Serdeable
data class KafkaEvent<T>(
    val id: String,
    val source: String,
    val timestamp: ZonedDateTime,
    val data: T,
) {

    companion object {
        fun <T> of(data: T): KafkaEvent<T> {
            return KafkaEvent(
                id = UUID.randomUUID().toString(),
                source = "com.example.micronaut.bookstore",
                timestamp = ZonedDateTime.now(),
                data = data,
            )
        }
    }
}