package com.example.micronaut.bookstore.service.model

import com.example.micronaut.bookstore.repository.entity.BookEntity
import io.micronaut.core.annotation.Introspected
import io.micronaut.data.jpa.repository.criteria.Specification
import jakarta.persistence.criteria.CriteriaBuilder
import jakarta.persistence.criteria.CriteriaQuery
import jakarta.persistence.criteria.Predicate
import jakarta.persistence.criteria.Root


@Introspected
class BookSearchCriteria(pageIndex: Int?, pageSize: Int?): PagedSearchCriteria(pageIndex, pageSize), Specification<BookEntity> {

    override fun toPredicate(
        root: Root<BookEntity>,
        query: CriteriaQuery<*>,
        criteriaBuilder: CriteriaBuilder
    ): Predicate {
        return criteriaBuilder.like(root.get("id"), "%")
    }
}