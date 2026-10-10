package com.sreenithimart.shop.model;

public class Order {
    private Long id;
    private Long buyerId;
    private String buyerName;
    private Long sellerId;
    private String sellerName;
    private Long productId;
    private String productName;
    private int quantity;
    private double amount;
    private String status;
    private String orderDate;
    private String deliveryAddress;

    public Order() {}

    public Order(Long id, Long buyerId, String buyerName, Long sellerId, String sellerName,
                Long productId, String productName, int quantity, double amount,
                String status, String orderDate, String deliveryAddress) {
        this.id = id;
        this.buyerId = buyerId;
        this.buyerName = buyerName;
        this.sellerId = sellerId;
        this.sellerName = sellerName;
        this.productId = productId;
        this.productName = productName;
        this.quantity = quantity;
        this.amount = amount;
        this.status = status;
        this.orderDate = orderDate;
        this.deliveryAddress = deliveryAddress;
    }

    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }
    public Long getBuyerId() { return buyerId; }
    public void setBuyerId(Long buyerId) { this.buyerId = buyerId; }
    public String getBuyerName() { return buyerName; }
    public void setBuyerName(String buyerName) { this.buyerName = buyerName; }
    public Long getSellerId() { return sellerId; }
    public void setSellerId(Long sellerId) { this.sellerId = sellerId; }
    public String getSellerName() { return sellerName; }
    public void setSellerName(String sellerName) { this.sellerName = sellerName; }
    public Long getProductId() { return productId; }
    public void setProductId(Long productId) { this.productId = productId; }
    public String getProductName() { return productName; }
    public void setProductName(String productName) { this.productName = productName; }
    public int getQuantity() { return quantity; }
    public void setQuantity(int quantity) { this.quantity = quantity; }
    public double getAmount() { return amount; }
    public void setAmount(double amount) { this.amount = amount; }
    public String getStatus() { return status; }
    public void setStatus(String status) { this.status = status; }
    public String getOrderDate() { return orderDate; }
    public void setOrderDate(String orderDate) { this.orderDate = orderDate; }
    public String getDeliveryAddress() { return deliveryAddress; }
    public void setDeliveryAddress(String deliveryAddress) { this.deliveryAddress = deliveryAddress; }
}
