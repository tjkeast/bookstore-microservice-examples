package com.example.micronaut.bookstore.repository

import com.example.micronaut.bookstore.repository.entity.BookEntity
import io.micronaut.data.annotation.Repository
import io.micronaut.data.hibernate.reactive.repository.jpa.ReactorJpaSpecificationExecutor
import io.micronaut.data.repository.reactive.ReactorCrudRepository

@Repository
interface BookRepository : ReactorCrudRepository<BookEntity, String>, ReactorJpaSpecificationExecutor<BookEntity>