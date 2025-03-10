package app.Ingredient;
import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDateTime;
import java.util.UUID;

@Entity
@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Ingredient { ////  описва наличностите в склада

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID Id;

    @Column (nullable = false)
    private String ingredientName;

    @Column (nullable = false)
    Double ingredientQuantity; // наличното количество в склада

    LocalDateTime createdOn;

    LocalDateTime updatedOn;
}
