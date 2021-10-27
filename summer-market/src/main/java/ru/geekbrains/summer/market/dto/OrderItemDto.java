package ru.geekbrains.summer.market.dto;

import lombok.Data;
import lombok.NoArgsConstructor;
import ru.geekbrains.summer.market.model.Order;
import ru.geekbrains.summer.market.model.Product;

import javax.persistence.*;
import java.math.BigDecimal;

@Entity
@Table(name = "orderitemsdto")
@Data
@NoArgsConstructor
public class OrderItemDto {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "order_id")
    private Long order;

    @Column(name = "productId")
    private long productId;

    @Column(name = "product_title")
    private String productTitle;

    @Column(name = "price")
    private BigDecimal pricePerProduct;

    @Column(name = "sum")
    private BigDecimal sum;

    @Column(name = "quantity")
    private int quantity;

    public OrderItemDto(Product product) {
        this.productId = product.getId();
        this.productTitle = product.getTitle();
        this.pricePerProduct = product.getPrice();
        this.sum = product.getPrice();
        this.quantity = 1;
    }

    public void changeQuantity(int amount){
        quantity += amount;
        sum = pricePerProduct.multiply(BigDecimal.valueOf(quantity));
    }
}
