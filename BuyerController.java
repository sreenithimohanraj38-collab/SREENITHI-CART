package com.sreenithimart.shop.controller;

import com.sreenithimart.shop.model.Order;
import com.sreenithimart.shop.service.OrderService;
import org.springframework.web.bind.annotation.*;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api/buyer")
@CrossOrigin(origins = "*")
public class BuyerController {
    private final OrderService orderService;
    public BuyerController(OrderService orderService) { this.orderService = orderService; }

    @PostMapping("/orders")
    public Map<String, Object> placeOrder(@RequestBody Order order) {
        Order created = orderService.createOrder(order);
        Map<String, Object> response = new HashMap<>();
        response.put("success", true);
        response.put("message", "Order placed successfully!");
        response.put("order", created);
        return response;
    }

    @GetMapping("/orders/{buyerId}")
    public List<Order> getBuyerOrders(@PathVariable Long buyerId) { return orderService.getOrdersByBuyer(buyerId); }

    @GetMapping("/orders")
    public List<Order> getAllOrders() { return orderService.getAllOrders(); }
}
