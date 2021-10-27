package ru.geekbrains.summer.market.controllers;

import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import ru.geekbrains.summer.market.model.Order;
import ru.geekbrains.summer.market.model.Product;
import ru.geekbrains.summer.market.repositories.OrderItemDtoRepository;
import ru.geekbrains.summer.market.services.OrderService;
import ru.geekbrains.summer.market.services.ProductService;
import ru.geekbrains.summer.market.utils.Cart;
import ru.geekbrains.summer.market.utils.ResourceNotFoundException;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/cart")
public class CartController {

    private final Cart cart;
    private final ProductService productService;
    private final OrderService orderService;
    private final OrderItemDtoRepository orderItemDtoRepository;

    @GetMapping
    public Cart getCart () {return cart;}

    @GetMapping("/add/{productId}")
    public void add(@PathVariable Long productId) {
        if (!cart.add(productId)) {
            Product product = productService.findById(productId).orElseThrow(() -> new ResourceNotFoundException("Unable add product to cart. Product not found id: " + productId));
            cart.add(product);
        }
    }
    @GetMapping("/delete/{productId}")
    public ResponseEntity delete(@PathVariable Long productId) {
        if (!cart.delete(productId)) {
            throw  new ResourceNotFoundException("Unable delete product to cart. Product not found id: " + productId);
        } else {
            return ResponseEntity.ok().build();
        }
    }

    @GetMapping("/clear")
    public ResponseEntity clear() {
        cart.clear();
        return ResponseEntity.ok().build();
        }

    @GetMapping("/clear/{productId}")
    public ResponseEntity clearProduct(@PathVariable Long productId) {
            cart.clear(productId);
            return ResponseEntity.ok().build();
    }

    @Transactional
    @GetMapping("/save_order")
    public void saveCart() {
        orderItemDtoRepository.removeOrderItemDtoByOrder(cart.getCartId());
        orderService.save(cart);
    }

//    @Transactional
//    @GetMapping("/save_del")
//    public void savedel() {
//
//        orderItemDtoRepository.removeOrderItemDtoByOrder(cart.getCartId());
//
//    }

}
