package example.micronaut.bookstore.api.model.search;

import io.micronaut.data.model.Page;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Builder;
import lombok.Data;

import java.util.Collection;
import java.util.function.Function;

@Data
@Schema(name = "PagedSearchResult")
@Builder
public class PagedSearchResult<T> {

    private Collection<T> results;

    private long resultSize;

    private long totalPages;

    private long totalSize;

    public static <T> PagedSearchResult<T> from(Page<T> page) {
        return from(page, l -> l);
    }

    public static <Z, T> PagedSearchResult<T> from(Page<Z> page, Function<Collection<Z>, Collection<T>> mapper) {
        return PagedSearchResult.<T>builder()
                .results(mapper.apply(page.getContent()))
                .resultSize(page.getNumberOfElements())
                .totalPages(page.getTotalPages())
                .totalSize(page.getTotalSize())
                .build();
    }
}
