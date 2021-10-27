package ru.geekbrains.summer.market.model;

import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.Cascade;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;
import org.springframework.stereotype.Component;
import ru.geekbrains.summer.market.dto.OrderItemDto;
import ru.geekbrains.summer.market.utils.Cart;

import javax.annotation.PostConstruct;
import javax.persistence.*;
import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "orders")
@Data
@NoArgsConstructor
@Component
public class Order {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @OneToMany(mappedBy = "order")
    //@Cascade(org.hibernate.annotations.CascadeType.ALL)
    private List<OrderItemDto> items;

    @Column(name = "price")
    private BigDecimal price;

    @CreationTimestamp
    @Column(name = "created_at")
    private LocalDateTime createdAt;

    @UpdateTimestamp
    @Column(name = "updated_at")
    private LocalDateTime updatedAt;

    public Order(Cart cart) {
        this.items = cart.getItems();
        this.price = cart.getPrice();

    }

    @PostConstruct
    public void createCart(){
        items = new ArrayList<>();
        price = BigDecimal.ZERO;
    }

}
