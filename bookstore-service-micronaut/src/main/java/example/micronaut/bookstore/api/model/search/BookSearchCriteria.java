package example.micronaut.bookstore.api.model.search;

import example.micronaut.bookstore.persistence.entity.BookEntity;
import example.micronaut.bookstore.persistence.entity.BookEntity_;
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
import java.time.OffsetDateTime;
import java.util.ArrayList;
import java.util.List;

@Getter
public class BookSearchCriteria extends PagedSearchCriteria implements Specification<BookEntity> {

    @Nullable
    @QueryValue
    private OffsetDateTime releaseDateMin;

    @Nullable
    @QueryValue
    private OffsetDateTime releaseDateMax;

    @Builder
    public BookSearchCriteria(Integer pageIndex, Integer pageSize, @Nullable OffsetDateTime releaseDateMin, @Nullable OffsetDateTime releaseDateMax) {
        super(pageIndex, pageSize);
        this.releaseDateMin = releaseDateMin;
        this.releaseDateMax = releaseDateMax;
    }

    @Override
    public Predicate toPredicate(Root<BookEntity> root, CriteriaQuery<?> query, CriteriaBuilder criteriaBuilder) {
        List<Predicate> predicates = new ArrayList<>();
        if (releaseDateMin != null) {
            predicates.add(criteriaBuilder.greaterThanOrEqualTo(root.get(BookEntity_.RELEASE_DATE), releaseDateMin));
        }

        if (releaseDateMax != null) {
            predicates.add(criteriaBuilder.lessThanOrEqualTo(root.get(BookEntity_.RELEASE_DATE), releaseDateMax));
        }

        return criteriaBuilder.and(predicates.toArray(new Predicate[]{}));
    }
}
