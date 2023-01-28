package example.micronaut.bookstore.api.model.search;

import io.micronaut.core.annotation.Nullable;
import io.micronaut.data.model.Pageable;
import io.micronaut.http.annotation.QueryValue;
import lombok.Getter;

import javax.validation.constraints.PositiveOrZero;

import static java.lang.Math.min;
import static org.apache.commons.lang3.ObjectUtils.defaultIfNull;

@Getter
public class PagedSearchCriteria {

    private static final int DEFAULT_PAGE_SIZE = 10;
    private static final int DEFAULT_MAX_PAGE_SIZE = 100;

    @Nullable
    @QueryValue
    @PositiveOrZero
    private final Integer pageIndex;

    @Nullable
    @QueryValue
    @PositiveOrZero
    private final Integer pageSize;

    public PagedSearchCriteria(Integer pageIndex, Integer pageSize) {
        this.pageIndex = defaultIfNull(pageIndex, 0);
        this.pageSize = min(defaultIfNull(pageSize, DEFAULT_PAGE_SIZE), DEFAULT_MAX_PAGE_SIZE);
    }

    public Pageable toPageable() {
        return Pageable.from(pageIndex, pageSize);
    }
}
