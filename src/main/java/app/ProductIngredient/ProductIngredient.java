package app.ProductIngredient;

import app.Product.Product;
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
public class ProductIngredient {

    @Id
    @GeneratedValue (strategy = GenerationType.UUID)
    private UUID id;

    @ManyToOne
    private Product product;

    @Column(nullable = false)
    private int quantity;

    private LocalDateTime createdOn;

    private LocalDateTime updatedOn;
}
