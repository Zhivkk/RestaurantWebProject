package app.Order;

import app.cart.Cart;
import app.user.model.User;
import jakarta.persistence.*;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Entity
public class Order { // описва поръчката

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;

    @ManyToOne
    private User user; // името на клиента (логнатия в системата)

    @Enumerated(EnumType.STRING)
    @Column (nullable = false)
    private OrderStatus orderStatus; // for execution, for payment, paid, for delivery, delivered (енумерация)

    @OneToMany(fetch = FetchType.EAGER, mappedBy = "order")
    @OrderBy("createdOn DESC")
    private List<Cart> carts = new ArrayList<>();

    @Column (nullable = false)
    private BigDecimal price; // обща цена за поръчката

    private String addressForDelivery; // може да се раздели на отделни позиции – град, квартал, улица ....

    private int tableNumber; // номер на масата (когато се обслужва от сервитьор)

    private String note; //Коментар

    private LocalDateTime createdOn;

    private LocalDateTime updatedOn;
}
