package com.RestaurantWebApp.model.entity;

import com.RestaurantWebApp.model.entity.enums.Position;
import com.RestaurantWebApp.model.entity.enums.UserStatus;
import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.CreationTimestamp;

import java.time.LocalDateTime;

@Entity
@Table(name = "users")
@Data
@NoArgsConstructor
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(unique = true, nullable = false)
    private String username;

    @Column(nullable = false)
    private String password;

    @Column(unique = true, nullable = false)
    private String email;

    @Column
    @Enumerated(EnumType.STRING)
    private UserStatus userStatus;

    @Column
    @Enumerated(EnumType.STRING)
    private Position position;

    @Column
    private String photo;

    @CreationTimestamp
    @Column(updatable = false)
    private LocalDateTime creationDate;

    @Column(nullable = false)
    private LocalDateTime dateOfChange;
}
