package ru.geekbrains.summer.market.controllers;

import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.*;
import ru.geekbrains.summer.market.dto.OrderDto;
import ru.geekbrains.summer.market.model.User;
import ru.geekbrains.summer.market.services.OrderService;
import ru.geekbrains.summer.market.services.UserService;

import java.security.Principal;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api/v1/orders")
@RequiredArgsConstructor
public class OrderController {
    private final OrderService orderService;
    private final UserService userService;

    @Autowired
    private AuthenticationManager authenticationManager;


    @PostMapping
    public void createOrder(Principal principal) {
        User user = userService.findByUsername(principal.getName()).get();
        System.out.println("+++++++++++++++++++++++ " + user.getUsername() + " create order +++++++++++++++++++++++");
        orderService.save(principal);
    }

    @GetMapping
    public List<OrderDto> getAllOrders() {
        return orderService.findAll().stream().map(OrderDto::new).collect(Collectors.toList());
    }

    @GetMapping("/user")
    public List<OrderDto> getAllUserOrders(Principal principal) {

        //User user = (User)SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        //return orderService.findAllOrdersUserId(user.getId()).stream().map(OrderDto::new).collect(Collectors.toList());
        //return orderService.findAllOrdersUserId(SecurityContextHolder.getContext().getAuthentication().getName()).stream().map(OrderDto::new).collect(Collectors.toList());
        return orderService.findAllOrdersUserId(principal.getName()).stream().map(OrderDto::new).collect(Collectors.toList());

    }

}
