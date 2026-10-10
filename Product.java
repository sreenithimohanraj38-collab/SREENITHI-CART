package com.sreenithimart.shop.model;

public class Product {
    private Long id;
    private String name;
    private String description;
    private String category;
    private double price;
    private double originalPrice;
    private double rating;
    private int reviews;
    private String imageUrl;
    private boolean inStock;

    public Product() {}

    public Product(Long id, String name, String description, String category,
                   double price, double originalPrice, double rating, int reviews,
                   String imageUrl, boolean inStock) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.category = category;
        this.price = price;
        this.originalPrice = originalPrice;
        this.rating = rating;
        this.reviews = reviews;
        this.imageUrl = imageUrl;
        this.inStock = inStock;
    }

    public double getDiscountPercent() {
        if (originalPrice <= 0) return 0;
        return Math.round(((originalPrice - price) / originalPrice) * 100);
    }

    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }
    public String getName() { return name; }
    public void setName(String name) { this.name = name; }
    public String getDescription() { return description; }
    public void setDescription(String description) { this.description = description; }
    public String getCategory() { return category; }
    public void setCategory(String category) { this.category = category; }
    public double getPrice() { return price; }
    public void setPrice(double price) { this.price = price; }
    public double getOriginalPrice() { return originalPrice; }
    public void setOriginalPrice(double originalPrice) { this.originalPrice = originalPrice; }
    public double getRating() { return rating; }
    public void setRating(double rating) { this.rating = rating; }
    public int getReviews() { return reviews; }
    public void setReviews(int reviews) { this.reviews = reviews; }
    public String getImageUrl() { return imageUrl; }
    public void setImageUrl(String imageUrl) { this.imageUrl = imageUrl; }
    public boolean isInStock() { return inStock; }
    public void setInStock(boolean inStock) { this.inStock = inStock; }
}
