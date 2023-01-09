package example.bookstore.micronaut.persistence.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.math.BigDecimal;
import java.time.OffsetDateTime;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity(name = "book")
public class BookEntity {

    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    private Long id;

    @NotBlank
    @Column
    private String title;

    @NotBlank
    @Column
    private String author;

    @NotBlank
    @Column
    private String description;

    @NotNull
    @Column
    private OffsetDateTime releaseDate;

    @Column
    private String coverImageUrl;

    @NotNull
    @Column
    private Integer stock;

    @NotNull
    @Column
    private BigDecimal price;
}
