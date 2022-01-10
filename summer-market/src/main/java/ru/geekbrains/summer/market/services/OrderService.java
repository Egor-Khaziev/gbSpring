package ru.geekbrains.summer.market.services;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ru.geekbrains.summer.market.dto.OrderItemDto;
import ru.geekbrains.summer.market.exceptions.ResourceNotFoundException;
import ru.geekbrains.summer.market.model.Order;
import ru.geekbrains.summer.market.model.OrderItem;
import ru.geekbrains.summer.market.model.Product;
import ru.geekbrains.summer.market.repositories.OrderRepository;
import ru.geekbrains.summer.market.utils.Cart;

import java.math.BigDecimal;
import java.security.Principal;
import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class OrderService {

    private final ProductService productService;
    private final UserService userService;
    private final OrderRepository orderRepository;
//    private final OrderItemDtoRepository orderItemDtoRepository;
    private final Cart cart;

    @Transactional
    public void save(Principal principal) {
//        if (cart.getCartId()!=null){
//            //orderItemDtoRepository.removeOrderItemDtoByOrder(cart.getCartId());
//            Order order = new Order(cart);
//            order.setId(cart.getCartId());
//            order.setCreatedAt(cart.getCreatedAt());
//            saveitems(order);
//            return orderRepository.save(order);
//        }
//        Order order = orderRepository.save(new Order(cart));
//        cart.setCartId(order.getId());
//        cart.setCreatedAt(order.getCreatedAt());
//        return saveitems(order);
        Order order = new Order();
        order.setPrice(cart.getPrice());
        order.setItems(new ArrayList<>());
        order.setUser(userService.findByUsername(principal.getName()).get());
        for (OrderItemDto o : cart.getItems()) {
        OrderItem orderItem = new OrderItem();
        orderItem.setOrder(order);
        orderItem.setQuantity(o.getQuantity());
        Product product = productService.findById(o.getProductId()).orElseThrow(() -> new ResourceNotFoundException("Product not found"));
        orderItem.setPrice(product.getPrice().multiply(BigDecimal.valueOf(o.getQuantity())));
        orderItem.setPricePerProduct(product.getPrice());
        orderItem.setProduct(product);
        order.getItems().add(orderItem);
    }
        orderRepository.save(order);
        cart.clear();
    }

    public List<Order> findAll() {
        return orderRepository.findAll();
    }

    public List<Order> findAllOrdersUserId(String name) {
        return orderRepository.findOrdersByUser(userService.findByUsername(name).get());
    }

//    public Order saveitems(Order order){
//
//        for (OrderItemDto oid: order.getItems()) {
//            oid.setOrder(order.getId());
//            orderItemDtoRepository.save(oid);
//        }
//        return order;
//    }
}
