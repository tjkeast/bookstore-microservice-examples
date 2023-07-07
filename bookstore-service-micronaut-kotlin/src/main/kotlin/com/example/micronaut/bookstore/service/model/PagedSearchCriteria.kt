package com.example.micronaut.bookstore.service.model

import io.micronaut.core.annotation.Nullable
import io.micronaut.data.model.Pageable
import io.micronaut.http.annotation.QueryValue


abstract class PagedSearchCriteria (
    @QueryValue
    var pageIndex: Int?,
    @QueryValue
    var pageSize: Int?
)  {

    companion object {
        const val DEFAULT_PAGE_INDEX = 0
        const val DEFAULT_PAGE_SIZE = 10
    }

    fun toPageable() : Pageable {
        return Pageable.from(pageIndex ?: DEFAULT_PAGE_INDEX, pageSize ?: DEFAULT_PAGE_SIZE)
    }
}