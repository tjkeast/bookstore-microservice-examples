package com.example.micronaut.bookstore.repository

import com.example.micronaut.bookstore.repository.entity.BookEntity
import io.micronaut.data.annotation.Repository
import io.micronaut.data.jpa.repository.JpaSpecificationExecutor
import io.micronaut.data.repository.CrudRepository

@Repository
interface BookRepository : CrudRepository<BookEntity, String>, JpaSpecificationExecutor<BookEntity>