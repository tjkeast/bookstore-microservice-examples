package example.micronaut.bookstore.api.model.search;

import io.micronaut.core.annotation.Nullable;
import io.micronaut.data.jpa.repository.criteria.Specification;
import io.micronaut.http.annotation.QueryValue;
import lombok.Getter;
import org.apache.commons.lang3.StringUtils;

import javax.persistence.criteria.*;
import javax.validation.constraints.NotBlank;
import java.util.ArrayList;
import java.util.List;

@Getter
public class QuerySearchCriteria<T> extends PagedSearchCriteria implements Specification<T> {

    @Nullable
    @QueryValue
    @NotBlank
    private final String query;

    @Nullable
    @QueryValue
    @NotBlank
    private final List<String> queryFields;

    public QuerySearchCriteria(Integer pageIndex, Integer pageSize, String query, List<String> queryFields) {
        super(pageIndex, pageSize);
        this.query = query;
        this.queryFields = queryFields;
    }

    @Override
    public Predicate toPredicate(Root<T> root, CriteriaQuery<?> q, CriteriaBuilder cb) {
        List<Predicate> predicates = new ArrayList<>();

        if (query != null) {
            if (queryFields == null) {
                throw new IllegalStateException("Query parameter used without query fields");
            }

            for (String field : queryFields) {
                Expression<String> column = cb.lower(root.get(field).as(String.class));
                predicates.add(cb.like(column, StringUtils.lowerCase(query + "%")));
            }
        }

        return cb.and(predicates.toArray(new Predicate[]{}));
    }
}
