package com.sreenithimart.shop.controller;

import com.sreenithimart.shop.model.User;
import com.sreenithimart.shop.service.UserService;
import org.springframework.web.bind.annotation.*;
import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/api/auth")
@CrossOrigin(origins = "*")
public class AuthController {
    private final UserService userService;
    public AuthController(UserService userService) { this.userService = userService; }

    @PostMapping("/login")
    public Map<String, Object> login(@RequestBody Map<String, String> credentials) {
        String email = credentials.get("email");
        String password = credentials.get("password");
        String role = credentials.get("role");
        User user = userService.login(email, password, role);
        Map<String, Object> response = new HashMap<>();
        if (user != null) {
            response.put("success", true);
            response.put("message", "Login successful!");
            response.put("user", user);
        } else {
            response.put("success", false);
            response.put("message", "Invalid email, password, or role!");
        }
        return response;
    }
}
