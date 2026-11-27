package com.foodfinda.models;

import java.time.LocalDateTime;

public class FoodOrder {
    private final int id;
    private final String customerName;
    private final Restaurant restaurant;
    private final Location deliveryLocation;
    private final String item;
    private final boolean urgent;
    private final LocalDateTime placedAt;
    private Rider rider;
    private OrderStatus status = OrderStatus.PLACED;

    public FoodOrder(int id, String customerName, Restaurant restaurant, Location deliveryLocation,
                     String item, boolean urgent, LocalDateTime placedAt) {
        this.id = id;
        this.customerName = customerName;
        this.restaurant = restaurant;
        this.deliveryLocation = deliveryLocation;
        this.item = item;
        this.urgent = urgent;
        this.placedAt = placedAt;
    }

    public int getId() { return id; }
    public String getCustomerName() { return customerName; }
    public Restaurant getRestaurant() { return restaurant; }
    public Location getDeliveryLocation() { return deliveryLocation; }
    public String getItem() { return item; }
    public boolean isUrgent() { return urgent; }
    public LocalDateTime getPlacedAt() { return placedAt; }
    public Rider getRider() { return rider; }
    public void setRider(Rider rider) { this.rider = rider; }
    public OrderStatus getStatus() { return status; }
    public void setStatus(OrderStatus status) { this.status = status; }
}
