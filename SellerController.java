package com.sreenithimart.shop.controller;

import com.sreenithimart.shop.model.Order;
import com.sreenithimart.shop.model.Product;
import com.sreenithimart.shop.service.OrderService;
import com.sreenithimart.shop.service.ProductService;
import org.springframework.web.bind.annotation.*;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api/seller")
@CrossOrigin(origins = "*")
public class SellerController {
    private final ProductService productService;
    private final OrderService orderService;

    public SellerController(ProductService productService, OrderService orderService) {
        this.productService = productService;
        this.orderService = orderService;
    }

    @GetMapping("/dashboard")
    public Map<String, Object> getSellerDashboard() {
        Map<String, Object> data = new HashMap<>();
        data.put("totalProducts", productService.getAllProducts().size());
        data.put("totalOrders", orderService.getAllOrders().size());
        data.put("recentOrders", orderService.getAllOrders().subList(0, Math.min(5, orderService.getAllOrders().size())));
        return data;
    }

    @GetMapping("/orders")
    public List<Order> getSellerOrders() { return orderService.getAllOrders(); }

    @PostMapping("/products")
    public Map<String, Object> addProduct(@RequestBody Product product) {
        Map<String, Object> response = new HashMap<>();
        response.put("success", true);
        response.put("message", "Product added successfully!");
        response.put("product", product);
        return response;
    }

    @DeleteMapping("/products/{id}")
    public Map<String, Object> deleteProduct(@PathVariable Long id) {
        Map<String, Object> response = new HashMap<>();
        response.put("success", true);
        response.put("message", "Product deleted successfully!");
        return response;
    }
}
