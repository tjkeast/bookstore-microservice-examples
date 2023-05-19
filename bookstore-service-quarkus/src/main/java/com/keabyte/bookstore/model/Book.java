package com.keabyte.bookstore.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.time.OffsetDateTime;

@Builder
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Book {

    private Long id;

    private String title;

    private String author;

    private String description;

    private OffsetDateTime releaseDate;

    private String coverImageUrl;

    private Integer stock;

    private BigDecimal price;
}
