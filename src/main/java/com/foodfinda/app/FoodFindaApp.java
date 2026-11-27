package com.foodfinda.app;

import com.foodfinda.data.DemoData;
import com.foodfinda.models.FoodOrder;
import com.foodfinda.models.Location;
import com.foodfinda.models.OrderStatus;
import com.foodfinda.models.Restaurant;
import com.foodfinda.services.DeliveryService;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Scanner;

public class FoodFindaApp {
    private final List<Restaurant> restaurants = DemoData.restaurants();
    private final DeliveryService delivery = new DeliveryService(DemoData.riders());
    private final Scanner input = new Scanner(System.in);
    private int nextOrderId = 1001;

    public void run() {
        System.out.println("=== FoodFinda: Food Delivery Simulator ===");
        boolean running = true;
        while (running) {
            System.out.println("\n1. Place order  2. View orders  3. Advance delivery  4. View riders  0. Exit");
            int choice = readInt("Choose: ");
            switch (choice) {
                case 1 -> placeOrder();
                case 2 -> showOrders();
                case 3 -> advanceDelivery();
                case 4 -> showRiders();
                case 0 -> running = false;
                default -> System.out.println("Choose one of the listed options.");
            }
        }
        System.out.println("Goodbye.");
    }

    private void placeOrder() {
        String customer = readText("Customer name: ");
        System.out.println("Restaurants:");
        for (int i = 0; i < restaurants.size(); i++)
            System.out.printf("%d. %s at %s%n", i + 1, restaurants.get(i).name(), restaurants.get(i).location());
        int restaurantIndex = readChoice("Restaurant: ", restaurants.size()) - 1;
        String item = readText("Food item: ");
        int x = readInt("Delivery grid X coordinate: ");
        int y = readInt("Delivery grid Y coordinate: ");
        boolean urgent = readYesNo("Urgent order? (y/n): ");
        FoodOrder order = new FoodOrder(nextOrderId++, customer, restaurants.get(restaurantIndex),
                new Location(x, y), item, urgent, LocalDateTime.now());
        delivery.addOrder(order);
        System.out.printf("Order #%d placed%s.%n", order.getId(), urgent ? " (URGENT)" : "");
        delivery.assignRider(order).ifPresentOrElse(rider -> {
            System.out.printf("Assigned rider %s. Route: %s%n", rider.getName(), delivery.route(order));
            System.out.println("Use 'Advance delivery' to simulate pickup and delivery.");
        }, () -> System.out.println("No riders are currently available. The order remains queued."));
    }

    private void showOrders() {
        List<FoodOrder> orders = delivery.getOrders();
        if (orders.isEmpty()) { System.out.println("No orders yet."); return; }
        System.out.println("Orders (urgent orders are listed first):");
        for (FoodOrder o : orders) {
            String rider = o.getRider() == null ? "unassigned" : o.getRider().getName();
            System.out.printf("#%d | %s | %s | %s | %s | rider: %s | to %s%n", o.getId(),
                    o.isUrgent() ? "URGENT" : "standard", o.getItem(), o.getRestaurant().name(),
                    o.getStatus(), rider, o.getDeliveryLocation());
        }
    }

    private void advanceDelivery() {
        showOrders();
        int id = readInt("Order ID to advance (0 to cancel): ");
        if (id == 0) return;
        FoodOrder order = delivery.getOrders().stream().filter(o -> o.getId() == id).findFirst().orElse(null);
        if (order == null) { System.out.println("Order not found."); return; }
        if (order.getRider() == null && order.getStatus() == OrderStatus.PLACED) {
            delivery.assignRider(order);
            if (order.getRider() == null) { System.out.println("No rider available yet."); return; }
        }
        if (!delivery.advance(id)) { System.out.println("This order cannot advance."); return; }
        System.out.printf("Order #%d is now %s.%n", id, order.getStatus());
        if (order.getStatus() == OrderStatus.DELIVERED)
            System.out.printf("Delivered to %s. Rider %s is available again.%n", order.getDeliveryLocation(), order.getRider().getName());
    }

    private void showRiders() {
        delivery.getRiders().forEach(r -> System.out.printf("%s | %s | %s%n", r.getName(),
                r.isAvailable() ? "available" : "on delivery", r.getLocation()));
    }

    private int readChoice(String prompt, int max) {
        while (true) { int value = readInt(prompt); if (value >= 1 && value <= max) return value; System.out.println("Enter a number from 1 to " + max + "."); }
    }
    private int readInt(String prompt) {
        while (true) {
            System.out.print(prompt);
            try { return Integer.parseInt(input.nextLine().trim()); }
            catch (NumberFormatException e) { System.out.println("Enter a whole number."); }
        }
    }
    private String readText(String prompt) {
        while (true) { System.out.print(prompt); String value = input.nextLine().trim(); if (!value.isEmpty()) return value; System.out.println("This field is required."); }
    }
    private boolean readYesNo(String prompt) {
        while (true) { System.out.print(prompt); String value = input.nextLine().trim().toLowerCase(); if (value.equals("y") || value.equals("yes")) return true; if (value.equals("n") || value.equals("no")) return false; System.out.println("Enter y or n."); }
    }
}
