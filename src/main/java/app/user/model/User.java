package app.user.model;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Builder
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;

    @Column(nullable = false, unique = true)
    private String username;

    private String firstName;

    private String lastName;

    private String profilePicture;

    @Column(unique = true)
    private String email;

    @Column(nullable = false)
    private String password;
    
    @Column(nullable = false)
    private String phone; // задължително при регистрация

    @Enumerated(EnumType.STRING) //client се въвежда автоматично от системата, останалите се променят ръчно от admin
    @Column(nullable = false)
    private UserRole role;

    @Enumerated(EnumType.STRING) // това трябва да се премахне
    @Column(nullable = false)
    private Country country;

    private boolean isActive;

    @Column(nullable = false)
    private LocalDateTime createdOn;

    @Column(nullable = false)
    private LocalDateTime updatedOn;

    @OneToMany(fetch = FetchType.EAGER, mappedBy = "user")
    @OrderBy("createdOn DESC")
    private List<Order> orders = new ArrayList<>();

    @OneToMany(fetch = FetchType.EAGER, mappedBy = "user")
    @OrderBy("createdOn DESC")
    private List<Massage> massages = new ArrayList<>();

}
