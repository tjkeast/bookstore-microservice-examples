package example.micronaut.bookstore.api.model.search;

import example.micronaut.bookstore.persistence.entity.BookEntity;
import example.micronaut.bookstore.persistence.entity.BookEntity_;
import io.micronaut.core.annotation.Nullable;
import io.micronaut.http.annotation.QueryValue;
import lombok.Builder;
import lombok.Getter;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Getter
public class BookSearchCriteria extends QuerySearchCriteria<BookEntity> {

    @Nullable
    @QueryValue
    private final LocalDate releaseDateMin;

    @Nullable
    @QueryValue
    private final LocalDate releaseDateMax;

    @Builder
    public BookSearchCriteria(Integer pageIndex, Integer pageSize, String query, List<String> queryFields, @Nullable LocalDate releaseDateMin, @Nullable LocalDate releaseDateMax) {
        super(pageIndex, pageSize, query, queryFields);
        this.releaseDateMin = releaseDateMin;
        this.releaseDateMax = releaseDateMax;
    }

    @Override
    public Predicate toPredicate(Root<BookEntity> root, CriteriaQuery<?> query, CriteriaBuilder cb) {
        List<Predicate> predicates = new ArrayList<>();
        predicates.add(super.toPredicate(root, query, cb));

        if (releaseDateMin != null) {
            predicates.add(cb.greaterThanOrEqualTo(root.get(BookEntity_.RELEASE_DATE), releaseDateMin));
        }

        if (releaseDateMax != null) {
            predicates.add(cb.lessThanOrEqualTo(root.get(BookEntity_.RELEASE_DATE), releaseDateMax));
        }

        return cb.and(predicates.toArray(new Predicate[]{}));
    }
}
