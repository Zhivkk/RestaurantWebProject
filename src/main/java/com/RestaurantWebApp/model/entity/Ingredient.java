package com.RestaurantWebApp.model.entity;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.CreationTimestamp;

import java.time.LocalDateTime;
import java.util.UUID;


@Entity
@Table
@Data
@NoArgsConstructor
public class Ingredient {

    @Id
    @GeneratedValue (strategy = GenerationType.UUID)
    private UUID Id;

    @Column (nullable = false)
    String ingredientName;

    @Column (nullable = false)
    Double ingredientQuantity;

    @CreationTimestamp
    @Column(updatable = false)
    LocalDateTime creationDate;

    @Column (nullable = false)
    LocalDateTime dateOfChange;

}
