package com.sreenithimart.shop.controller;

import com.sreenithimart.shop.model.Order;
import com.sreenithimart.shop.model.User;
import com.sreenithimart.shop.service.OrderService;
import com.sreenithimart.shop.service.ProductService;
import com.sreenithimart.shop.service.UserService;
import org.springframework.web.bind.annotation.*;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api/admin")
@CrossOrigin(origins = "*")
public class AdminController {
    private final UserService userService;
    private final ProductService productService;
    private final OrderService orderService;

    public AdminController(UserService userService, ProductService productService, OrderService orderService) {
        this.userService = userService;
        this.productService = productService;
        this.orderService = orderService;
    }

    @GetMapping("/dashboard")
    public Map<String, Object> getDashboard() {
        Map<String, Object> data = new HashMap<>();
        data.put("totalProducts", productService.getAllProducts().size());
        data.put("totalSellers", userService.getByRole("seller").size());
        data.put("totalBuyers", userService.getByRole("buyer").size());
        data.put("totalOrders", orderService.getAllOrders().size());
        data.put("recentOrders", orderService.getAllOrders().subList(0, Math.min(5, orderService.getAllOrders().size())));
        return data;
    }

    @GetMapping("/sellers")
    public List<User> getAllSellers() { return userService.getByRole("seller"); }

    @GetMapping("/buyers")
    public List<User> getAllBuyers() { return userService.getByRole("buyer"); }

    @GetMapping("/orders")
    public List<Order> getAllOrders() { return orderService.getAllOrders(); }

    @GetMapping("/users")
    public List<User> getAllUsers() { return userService.getAllUsers(); }
}
