package example.micronaut.bookstore.api.model.search;

import io.micronaut.data.model.Page;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Builder;
import lombok.Data;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.function.Function;

@Data
@Schema(name = "PagedSearchResult")
@Builder
public class PagedSearchResult<T> {

    private final List<T> results;

    private final long resultSize;

    private final long totalPages;

    private final long totalSize;

    public static <T> PagedSearchResult<T> from(Page<T> page) {
        return from(page, ArrayList::new);
    }

    public static <Z, T> PagedSearchResult<T> from(Page<Z> page, Function<Collection<Z>, List<T>> mapper) {
        return PagedSearchResult.<T>builder()
                .results(mapper.apply(page.getContent()))
                .resultSize(page.getNumberOfElements())
                .totalPages(page.getTotalPages())
                .totalSize(page.getTotalSize())
                .build();
    }
}
