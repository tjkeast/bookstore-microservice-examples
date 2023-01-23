package example.springboot.bookstore.persistence.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

import java.time.LocalDate;

@Data
@Entity
@Table(name = "book")
public class BookEntity {

    @Id
    private Long id;

    private String title;

    private String author;

    private String description;

    private LocalDate releaseDate;

    private String coverImageUrl;
}
