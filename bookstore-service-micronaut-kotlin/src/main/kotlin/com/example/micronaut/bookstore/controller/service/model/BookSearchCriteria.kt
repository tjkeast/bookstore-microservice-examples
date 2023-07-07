package com.example.micronaut.bookstore.controller.service.model

import com.example.micronaut.bookstore.entity.BookEntity
import io.micronaut.core.annotation.Introspected
import io.micronaut.data.jpa.repository.criteria.Specification
import javax.persistence.criteria.CriteriaBuilder
import javax.persistence.criteria.CriteriaQuery
import javax.persistence.criteria.Predicate
import javax.persistence.criteria.Root

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