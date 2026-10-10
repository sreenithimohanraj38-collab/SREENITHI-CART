package com.sreenithimart.shop.service;

import com.sreenithimart.shop.model.Product;
import org.springframework.stereotype.Service;
import java.util.ArrayList;
import java.util.List;

@Service
public class ProductService {
    private final List<Product> products = new ArrayList<>();

    public ProductService() { loadProducts(); }

    private void loadProducts() {
        products.add(new Product(1L, "Wireless Bluetooth Earbuds", "Premium sound with noise cancellation, 24hr battery", "Electronics", 1999, 4999, 4.3, 2847, "🎧", true));
        products.add(new Product(2L, "Smart Watch Pro", "AMOLED display, fitness tracking, heart rate monitor", "Electronics", 3499, 7999, 4.5, 1523, "⌚", true));
        products.add(new Product(3L, "4K Ultra HD Smart TV - 55\"", "Android TV with voice assistant, HDR10+", "Electronics", 28990, 45990, 4.4, 892, "📺", true));
        products.add(new Product(4L, "Gaming Laptop RTX 4060", "i7 13th Gen, 16GB RAM, 1TB SSD, 144Hz display", "Electronics", 89990, 129990, 4.6, 456, "💻", true));
        products.add(new Product(5L, "Wireless Gaming Mouse", "RGB lighting, 16000 DPI, ergonomic design", "Electronics", 1299, 2499, 4.2, 3245, "🖱️", true));
        products.add(new Product(6L, "Portable Power Bank 20000mAh", "Fast charging, dual USB output, LED display", "Electronics", 1499, 2999, 4.4, 5678, "🔋", true));
        products.add(new Product(7L, "Men's Casual Slim Fit Shirt", "100% cotton, breathable fabric, modern cut", "Fashion", 799, 1599, 4.1, 2134, "👔", true));
        products.add(new Product(8L, "Women's Floral Summer Dress", "Lightweight, comfortable, perfect for outings", "Fashion", 1199, 2499, 4.3, 987, "👗", true));
        products.add(new Product(9L, "Running Shoes - Ultra Boost", "Memory foam insole, shock absorption, lightweight", "Fashion", 2999, 5999, 4.5, 4521, "👟", true));
        products.add(new Product(10L, "Leather Wallet - Genuine", "RFID blocking, multiple card slots, slim design", "Fashion", 599, 1299, 4.2, 1876, "👛", true));
        products.add(new Product(11L, "Polarized Aviator Sunglasses", "UV400 protection, metal frame, scratch resistant", "Fashion", 899, 1999, 4.0, 1543, "🕶️", true));
        products.add(new Product(12L, "Hooded Sweatshirt - Unisex", "Fleece lined, kangaroo pocket, casual style", "Fashion", 999, 2199, 4.3, 2890, "🧥", true));
        products.add(new Product(13L, "Air Fryer - 5.5 Liter", "Oil-free cooking, digital timer, 8 presets", "Home & Kitchen", 4999, 8999, 4.4, 1234, "🍳", true));
        products.add(new Product(14L, "Robot Vacuum Cleaner", "Smart mapping, auto recharge, app control", "Home & Kitchen", 14990, 24990, 4.5, 678, "🤖", true));
        products.add(new Product(15L, "Egyptian Cotton Bedsheet Set", "King size, 400 thread count, hypoallergenic", "Home & Kitchen", 1999, 3999, 4.3, 2345, "🛏️", true));
        products.add(new Product(16L, "Non-Stick Cookware Set (5 pc)", "Dishwasher safe, even heat distribution", "Home & Kitchen", 2499, 4999, 4.2, 1567, "🍲", true));
        products.add(new Product(17L, "LED Desk Lamp with USB Port", "Adjustable brightness, 5 color modes, eye care", "Home & Kitchen", 899, 1799, 4.1, 987, "💡", true));
        products.add(new Product(18L, "Atomic Habits - James Clear", "Build good habits, transform your life", "Books", 299, 599, 4.8, 12453, "📚", true));
        products.add(new Product(19L, "The Psychology of Money", "Timeless lessons on wealth and happiness", "Books", 249, 499, 4.7, 9876, "📖", true));
        products.add(new Product(20L, "Code: The Hidden Language", "How software works - from bits to browsers", "Books", 399, 799, 4.6, 3456, "💻", true));
        products.add(new Product(21L, "Deep Work - Cal Newport", "Rules for focused success in a distracted world", "Books", 349, 699, 4.5, 7654, "📕", true));
        products.add(new Product(22L, "Vitamin C Face Serum", "Brightening, anti-aging, 20% vitamin C", "Beauty", 599, 999, 4.3, 4321, "🧴", true));
        products.add(new Product(23L, "Wireless Hair Trimmer Kit", "Cordless, waterproof, multiple guards", "Beauty", 1299, 2499, 4.2, 2345, "✂️", true));
        products.add(new Product(24L, "Yoga Mat - Extra Thick 8mm", "Non-slip, eco-friendly TPE, carry strap", "Sports", 799, 1599, 4.4, 3456, "🧘", true));
        products.add(new Product(25L, "Adjustable Dumbbells 24kg", "Space-saving, quick change weights", "Sports", 3999, 6999, 4.6, 1234, "🏋️", true));
        products.add(new Product(26L, "Insulated Water Bottle 1L", "Keeps cold 24hrs/hot 12hrs, BPA free", "Sports", 499, 999, 4.3, 5678, "🍶", true));
        products.add(new Product(27L, "Smartphone XYZ Pro", "5G, 128GB, 64MP camera, 5000mAh battery", "Electronics", 24999, 32999, 4.5, 2345, "📱", true));
        products.add(new Product(28L, "USB-C Fast Charger 65W", "GaN technology, dual port, laptop compatible", "Electronics", 1499, 2999, 4.4, 6789, "🔌", true));
        products.add(new Product(29L, "Phone Case - Military Grade", "Shockproof, magnetic compatible, kickstand", "Electronics", 499, 999, 4.2, 3456, "📱", true));
        products.add(new Product(30L, "Webcam 1080p Full HD", "Auto focus, noise reduction, privacy cover", "Electronics", 1799, 3499, 4.1, 1234, "📷", true));
    }

    public List<Product> getAllProducts() { return new ArrayList<>(products); }

    public List<Product> searchProducts(String keyword) {
        List<Product> results = new ArrayList<>();
        String lower = keyword.toLowerCase();
        for (Product p : products) {
            if (p.getName().toLowerCase().contains(lower) ||
                p.getDescription().toLowerCase().contains(lower) ||
                p.getCategory().toLowerCase().contains(lower)) {
                results.add(p);
            }
        }
        return results;
    }

    public List<Product> getByCategory(String category) {
        List<Product> results = new ArrayList<>();
        for (Product p : products) {
            if (p.getCategory().equalsIgnoreCase(category)) results.add(p);
        }
        return results;
    }

    public Product getById(Long id) {
        for (Product p : products) { if (p.getId().equals(id)) return p; }
        return null;
    }
}
