package com.sreenithimart.shop.service;

import com.sreenithimart.shop.model.User;
import org.springframework.stereotype.Service;
import java.util.ArrayList;
import java.util.List;

@Service
public class UserService {
    private final List<User> users = new ArrayList<>();

    public UserService() { loadUsers(); }

    private void loadUsers() {
        users.add(new User(1L, "Super Admin", "admin@sreenithimart.com", "admin123", "admin", "9876543210", "Chennai, TN", true));
        users.add(new User(2L, "Manager", "manager@sreenithimart.com", "manager123", "admin", "9876543211", "Mumbai, MH", true));
        users.add(new User(101L, "Kumar Electronics", "kumar@sreenithimart.com", "seller123", "seller", "9876543220", "Chennai, TN", true));
        users.add(new User(102L, "Fashion Hub", "fashion@sreenithimart.com", "seller123", "seller", "9876543221", "Delhi, DL", true));
        users.add(new User(103L, "Home Essentials", "home@sreenithimart.com", "seller123", "seller", "9876543222", "Bangalore, KA", true));
        users.add(new User(104L, "Book World", "books@sreenithimart.com", "seller123", "seller", "9876543223", "Hyderabad, TS", true));
        users.add(new User(105L, "Beauty Store", "beauty@sreenithimart.com", "seller123", "seller", "9876543224", "Pune, MH", false));
        users.add(new User(201L, "Arun Kumar", "arun@email.com", "buyer123", "buyer", "9876543230", "Chennai, TN", true));
        users.add(new User(202L, "Priya Sharma", "priya@email.com", "buyer123", "buyer", "9876543231", "Mumbai, MH", true));
        users.add(new User(203L, "Rahul Verma", "rahul@email.com", "buyer123", "buyer", "9876543232", "Delhi, DL", true));
        users.add(new User(204L, "Sneha Patel", "sneha@email.com", "buyer123", "buyer", "9876543233", "Bangalore, KA", true));
        users.add(new User(205L, "Vikram Singh", "vikram@email.com", "buyer123", "buyer", "9876543234", "Hyderabad, TS", true));
    }

    public User login(String email, String password, String role) {
        for (User u : users) {
            if (u.getEmail().equalsIgnoreCase(email) && u.getPassword().equals(password) && u.getRole().equalsIgnoreCase(role)) return u;
        }
        return null;
    }

    public List<User> getByRole(String role) {
        List<User> result = new ArrayList<>();
        for (User u : users) { if (u.getRole().equalsIgnoreCase(role)) result.add(u); }
        return result;
    }

    public List<User> getAllUsers() { return new ArrayList<>(users); }

    public User getById(Long id) {
        for (User u : users) { if (u.getId().equals(id)) return u; }
        return null;
    }
}
