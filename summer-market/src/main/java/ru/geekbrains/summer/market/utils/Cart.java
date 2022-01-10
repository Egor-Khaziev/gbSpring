package ru.geekbrains.summer.market.utils;

import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Component;
import ru.geekbrains.summer.market.dto.OrderItemDto;
import ru.geekbrains.summer.market.model.Product;

import javax.annotation.PostConstruct;
import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Data
@NoArgsConstructor
@Component
public class Cart {

    private List<OrderItemDto> items;
    private BigDecimal price;
    private LocalDateTime createdAt;

    @PostConstruct
    public void createCart(){
        items = new ArrayList<>();
        price = BigDecimal.ZERO;
    }

    public void clear (){
        items.clear();
        price = BigDecimal.ZERO;
    }


    // если заменить == на .equals то exceptions, невозможно разименовывать???
    public Boolean clear (Long productId){
        for (OrderItemDto oid: items){
            if (oid.getProductId()==(productId)){
                items.remove(oid);
                calculate();
                return true;
            }
        }
        return false;
    }

    // если заменить == на .equals то exceptions, невозможно разименовывать???
    public Boolean add(Long productId){
        for (OrderItemDto oid: items) {
            if(oid.getProductId()==(productId)){
                oid.changeQuantity(1);
                calculate();
                return true;
            }
        }
        return false;
    }

    // если заменить == на .equals то exceptions, невозможно разименовывать???
    public Boolean delete(Long productId){
        for (OrderItemDto oid: items) {
            if(oid.getProductId()==(productId)){

                if(oid.getQuantity()>1){
                    oid.changeQuantity(-1);
                } else {
                    items.remove(oid);
                }

                calculate();
                return true;
            }
        }
        return false;
    }

    public void add(Product product){
        items.add(new OrderItemDto(product));
        calculate();
    }

    private void calculate() {
        price = BigDecimal.ZERO;
        for (OrderItemDto oid: items) {
            price = price.add(oid.getPrice());
        }
    }



}
