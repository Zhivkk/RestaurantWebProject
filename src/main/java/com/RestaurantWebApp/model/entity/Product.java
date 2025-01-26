package com.RestaurantWebApp.model.entity;

import com.RestaurantWebApp.model.entity.enums.Category;
import com.RestaurantWebApp.model.entity.enums.ProductStatus;
import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.CreationTimestamp;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.Map;
import java.util.UUID;

@Entity
@Table
@Data
@NoArgsConstructor
public class Product {

    @Id
    @GeneratedValue (strategy = GenerationType.UUID)
    private UUID id;

    @Column(nullable = false)
    private String productName;

    @Column(nullable = false)
    @Enumerated(EnumType.STRING)
    private Category category;

    @Column(nullable = false)
    private String description;

    @Column (nullable = false)
    private Map<Ingredient, Double> recipe;

    @Column(columnDefinition = "TEXT", nullable = false)
    private String preparation;

    @Column (nullable = false)
    private Double grammage;

    @Column (nullable = false)
    private BigDecimal price;

    @Column(nullable = false)
    private String picture;

    @Column(nullable = false)
    @Enumerated(EnumType.STRING)
    private ProductStatus productStatus;

    @CreationTimestamp
    @Column(updatable = false)
    private LocalDateTime creationDate;

    @Column(nullable = false)
    private LocalDateTime dateOfChange;

}

//String productName;
//Enum category; - soup, salad, appetizer, main course, dessert, soft drink, alcohol, others (енумерация)
//String description; - Кратко описание на продукта
//Map (Ingredient, quantity) recipe – съдържа рецептата за продукта (съставка/количество)
//Text preparation; - начин на приготвяне;
//Double grammage; - количество на една порция
//BigDecimal price;
//String picture;
//String productStatus; - available, out of stock,    (енумерация)
//LocalDateTime creationDate;
//LocalDateTime dateOfChange;
