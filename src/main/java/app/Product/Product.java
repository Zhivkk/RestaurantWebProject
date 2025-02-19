package app.Product;

import app.Ingredient.Ingredient;
import app.ProductIngredient.ProductIngredient;
import jakarta.persistence.*;
import lombok.*;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Entity
@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Product {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;

    @Column (nullable = false)
    private String productName;

    @Enumerated(EnumType.STRING)
    @Column (nullable = false)
    private ProductCategory productCategory; // soup, salad, appetizer, main course, dessert, soft drink, alcohol, others (енумерация)

    @Column (nullable = false)
    private String description; // Кратко описание на продукта

    @OneToMany(fetch = FetchType.EAGER, mappedBy = "product")
    @OrderBy("createdOn DESC")
    private List<ProductIngredient> productIngredient = new ArrayList<>(); // съдържа рецептата за продукта (съставка/количество)

    @Column (nullable = false)
    private String preparation; // начин на приготвяне;

    @Column (nullable = false)
    private int grammage; // количество на една порция

    @Column (nullable = false)
    private BigDecimal price;

    @Column (nullable = false)
    private String picture;

    @Enumerated(EnumType.STRING)
    @Column (nullable = false)
    private ProductStatus productStatus; // available, out of stock,    (енумерация)

    private LocalDateTime createdOn;

    private LocalDateTime updatedOn;
}
