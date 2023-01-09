package example.bookstore.micronaut.api.model.search;

import example.bookstore.micronaut.persistence.entity.BookEntity;
import example.bookstore.micronaut.persistence.entity.BookEntity_;
import io.micronaut.core.annotation.Nullable;
import io.micronaut.data.jpa.repository.criteria.Specification;
import io.micronaut.http.annotation.QueryValue;
import lombok.Builder;
import lombok.Getter;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
import javax.validation.constraints.PositiveOrZero;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

@Getter
public class BookSearchCriteria extends PagedSearchCriteria implements Specification<BookEntity> {

    @Nullable
    @QueryValue
    @PositiveOrZero
    private BigDecimal minPrice;

    @Nullable
    @QueryValue
    @PositiveOrZero
    private BigDecimal maxPrice;

    @Builder
    public BookSearchCriteria(Integer pageIndex, Integer pageSize, BigDecimal minPrice, BigDecimal maxPrice) {
        super(pageIndex, pageSize);
        this.minPrice = minPrice;
        this.maxPrice = maxPrice;
    }

    @Override
    public Predicate toPredicate(Root<BookEntity> root, CriteriaQuery<?> query, CriteriaBuilder criteriaBuilder) {
        List<Predicate> predicates = new ArrayList<>();
        if (minPrice != null) {
            predicates.add(criteriaBuilder.greaterThanOrEqualTo(root.get(BookEntity_.PRICE), minPrice));
        }

        if (maxPrice != null) {
            predicates.add(criteriaBuilder.lessThanOrEqualTo(root.get(BookEntity_.PRICE), maxPrice));
        }

        return criteriaBuilder.and(predicates.toArray(new Predicate[]{}));
    }
}
