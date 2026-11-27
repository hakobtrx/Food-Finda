package com.foodfinda.models;

public enum OrderStatus {
    PLACED, ASSIGNED, PICKED_UP, DELIVERED;

    public OrderStatus next() {
        return switch (this) {
            case PLACED -> ASSIGNED;
            case ASSIGNED -> PICKED_UP;
            case PICKED_UP -> DELIVERED;
            case DELIVERED -> DELIVERED;
        };
    }
}
