package example.micronaut.bookstore.api.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Builder
@Data
@AllArgsConstructor
@NoArgsConstructor
public class BookRequest {

    private String title;

    private String author;

    private String description;

    private LocalDate releaseDate;

    private String coverImageUrl;
}
