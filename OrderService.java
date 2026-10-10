package com.sreenithimart.shop.service;

import com.sreenithimart.shop.model.Order;
import org.springframework.stereotype.Service;
import java.util.ArrayList;
import java.util.List;

@Service
public class OrderService {
    private final List<Order> orders = new ArrayList<>();

    public OrderService() { loadOrders(); }

    private void loadOrders() {
        orders.add(new Order(1L, 201L, "Arun Kumar", 101L, "Kumar Electronics", 1L, "Wireless Bluetooth Earbuds", 1, 1999, "Delivered", "2024-01-15", "Chennai, TN"));
        orders.add(new Order(2L, 202L, "Priya Sharma", 102L, "Fashion Hub", 8L, "Women's Floral Summer Dress", 1, 1199, "Shipped", "2024-01-14", "Mumbai, MH"));
        orders.add(new Order(3L, 203L, "Rahul Verma", 103L, "Home Essentials", 13L, "Air Fryer - 5.5 Liter", 1, 4999, "Processing", "2024-01-13", "Delhi, DL"));
        orders.add(new Order(4L, 204L, "Sneha Patel", 104L, "Book World", 18L, "Atomic Habits", 2, 598, "Delivered", "2024-01-12", "Bangalore, KA"));
        orders.add(new Order(5L, 205L, "Vikram Singh", 105L, "Beauty Store", 22L, "Vitamin C Face Serum", 1, 599, "Cancelled", "2024-01-11", "Hyderabad, TS"));
        orders.add(new Order(6L, 201L, "Arun Kumar", 101L, "Kumar Electronics", 2L, "Smart Watch Pro", 1, 3499, "Delivered", "2024-01-10", "Chennai, TN"));
        orders.add(new Order(7L, 202L, "Priya Sharma", 102L, "Fashion Hub", 9L, "Running Shoes", 1, 2999, "Shipped", "2024-01-09", "Mumbai, MH"));
        orders.add(new Order(8L, 203L, "Rahul Verma", 103L, "Home Essentials", 14L, "Robot Vacuum Cleaner", 1, 14990, "Processing", "2024-01-08", "Delhi, DL"));
    }

    public List<Order> getAllOrders() { return new ArrayList<>(orders); }

    public List<Order> getOrdersByBuyer(Long buyerId) {
        List<Order> result = new ArrayList<>();
        for (Order o : orders) { if (o.getBuyerId().equals(buyerId)) result.add(o); }
        return result;
    }

    public List<Order> getOrdersBySeller(Long sellerId) {
        List<Order> result = new ArrayList<>();
        for (Order o : orders) { if (o.getSellerId().equals(sellerId)) result.add(o); }
        return result;
    }

    public Order getById(Long id) {
        for (Order o : orders) { if (o.getId().equals(id)) return o; }
        return null;
    }

    public Order createOrder(Order order) {
        Long newId = orders.stream().mapToLong(Order::getId).max().orElse(0) + 1;
        order.setId(newId);
        if (order.getStatus() == null || order.getStatus().isEmpty()) order.setStatus("Processing");
        if (order.getOrderDate() == null || order.getOrderDate().isEmpty()) order.setOrderDate(java.time.LocalDate.now().toString());
        orders.add(order);
        return order;
    }
}
