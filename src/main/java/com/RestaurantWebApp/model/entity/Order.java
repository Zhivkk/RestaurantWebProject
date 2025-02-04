package com.RestaurantWebApp.model.entity;

import com.RestaurantWebApp.model.entity.enums.OrderStatus;
import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.Fetch;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Entity
@Table
@Data
@NoArgsConstructor
public class Order {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user = new User();

    @Column
    @Enumerated(EnumType.STRING)
    private OrderStatus orderStatus;

    @OneToMany(fetch = FetchType.EAGER)
    private List<Product> order = new ArrayList<>();

    @Column(nullable = false)
    private BigDecimal OrderPrice;

    @Column
    private String addressForDelivery;

    @CreationTimestamp
    @Column(updatable = false)
    LocalDateTime creationDate;

    @Column(nullable = false)
    LocalDateTime dateOfChange;



}
