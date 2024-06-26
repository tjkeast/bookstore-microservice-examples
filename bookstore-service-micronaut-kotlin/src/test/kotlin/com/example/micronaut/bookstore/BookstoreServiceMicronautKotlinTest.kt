package com.example.micronaut.bookstore

import io.micronaut.runtime.EmbeddedApplication
import io.micronaut.test.extensions.junit5.annotation.MicronautTest
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

@MicronautTest
class BookstoreServiceMicronautKotlinTest(private val application: EmbeddedApplication<*>) {

    @Test
    fun testItWorks() {
        assertThat(application.isRunning).isTrue
    }
}
