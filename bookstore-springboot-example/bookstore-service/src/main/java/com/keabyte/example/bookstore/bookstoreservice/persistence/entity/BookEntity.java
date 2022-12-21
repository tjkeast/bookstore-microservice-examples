package com.keabyte.example.bookstore.bookstoreservice.persistence.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.Data;

@Data
@Entity
public class BookEntity {

    @Id
    private Long id;
}
