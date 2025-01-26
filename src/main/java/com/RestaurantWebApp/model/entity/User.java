package com.RestaurantWebApp.model.entity;

import com.RestaurantWebApp.model.entity.enums.Position;
import com.RestaurantWebApp.model.entity.enums.UserStatus;
import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.CreationTimestamp;

import java.time.LocalDateTime;
import java.util.UUID;

@Entity
@Table(name = "users")
@Data
@NoArgsConstructor
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;

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

    public void setUsername(String username) {
        this.username = username;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setPassword(String encode) {
        this.password = encode;
    }

    public String getPassword() {
        return this.password;
    }

    public long getId() {
        return id.compareTo(UUID.randomUUID());
    }
}
