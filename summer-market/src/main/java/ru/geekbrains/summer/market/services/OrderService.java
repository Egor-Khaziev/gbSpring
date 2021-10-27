package ru.geekbrains.summer.market.services;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ru.geekbrains.summer.market.dto.OrderItemDto;
import ru.geekbrains.summer.market.model.Order;
import ru.geekbrains.summer.market.repositories.OrderItemDtoRepository;
import ru.geekbrains.summer.market.repositories.OrderRepository;
import ru.geekbrains.summer.market.utils.Cart;

import java.util.List;

@Service
@RequiredArgsConstructor
public class OrderService {


    private final OrderRepository orderRepository;
    private final OrderItemDtoRepository orderItemDtoRepository;

    @Transactional
    public Order save(Cart cart) {
        if (cart.getCartId()!=null){
            //orderItemDtoRepository.removeOrderItemDtoByOrder(cart.getCartId());
            Order order = new Order(cart);
            order.setId(cart.getCartId());
            order.setCreatedAt(cart.getCreatedAt());
            saveitems(order);
            return orderRepository.save(order);
        }
        Order order = orderRepository.save(new Order(cart));
        cart.setCartId(order.getId());
        cart.setCreatedAt(order.getCreatedAt());
        return saveitems(order);
    }

    public Order saveitems(Order order){

        for (OrderItemDto oid: order.getItems()) {
            oid.setOrder(order.getId());
            orderItemDtoRepository.save(oid);
        }
        return order;
    }
}
