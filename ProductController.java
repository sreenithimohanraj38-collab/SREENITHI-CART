package com.sreenithimart.shop.controller;

import com.sreenithimart.shop.model.Product;
import com.sreenithimart.shop.service.ProductService;
import org.springframework.web.bind.annotation.*;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api")
@CrossOrigin(origins = "*")
public class ProductController {
    private final ProductService productService;
    public ProductController(ProductService productService) { this.productService = productService; }

    @GetMapping("/products")
    public Map<String, Object> getAllProducts() {
        Map<String, Object> response = new HashMap<>();
        response.put("brand", "Sreenithi Mart");
        response.put("tagline", "Shop the Best - Only at Sreenithi Mart!");
        response.put("totalProducts", productService.getAllProducts().size());
        response.put("products", productService.getAllProducts());
        return response;
    }

    @GetMapping("/products/{id}")
    public Product getProductById(@PathVariable Long id) { return productService.getById(id); }

    @GetMapping("/search")
    public Map<String, Object> searchProducts(@RequestParam String keyword) {
        Map<String, Object> response = new HashMap<>();
        response.put("keyword", keyword);
        response.put("results", productService.searchProducts(keyword));
        return response;
    }

    @GetMapping("/category/{category}")
    public List<Product> getByCategory(@PathVariable String category) { return productService.getByCategory(category); }

    @GetMapping
    public Map<String, Object> apiInfo() {
        Map<String, Object> info = new HashMap<>();
        info.put("app", "Sreenithi Mart");
        info.put("version", "1.0.0");
        info.put("endpoints", List.of(
            "/api/products - All products",
            "/api/products/{id} - Product by ID",
            "/api/search?keyword=xxx - Search products",
            "/api/category/{category} - Filter by category"
        ));
        return info;
    }
}
