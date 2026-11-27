package com.foodfinda.services;

import com.foodfinda.algorithms.OrderPriority;
import com.foodfinda.algorithms.RoutePlanner;
import com.foodfinda.models.FoodOrder;
import com.foodfinda.models.Location;
import com.foodfinda.models.OrderStatus;
import com.foodfinda.models.Rider;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Optional;

public class DeliveryService {
    private final List<Rider> riders;
    private final List<FoodOrder> orders = new ArrayList<>();
    private final RoutePlanner routePlanner = new RoutePlanner();

    public DeliveryService(List<Rider> riders) { this.riders = new ArrayList<>(riders); }
    public List<Rider> getRiders() { return List.copyOf(riders); }
    public List<FoodOrder> getOrders() { return orders.stream().sorted(OrderPriority.comparator()).toList(); }
    public void addOrder(FoodOrder order) { orders.add(order); }

    public Optional<Rider> assignRider(FoodOrder order) {
        Optional<Rider> choice = riders.stream().filter(Rider::isAvailable)
                .min(Comparator.comparingInt(r -> routePlanner.distance(r.getLocation(), order.getRestaurant().location())));
        choice.ifPresent(rider -> {
            rider.setAvailable(false);
            order.setRider(rider);
            order.setStatus(OrderStatus.ASSIGNED);
        });
        return choice;
    }

    public List<Location> route(FoodOrder order) {
        if (order.getRider() == null) return List.of();
        List<Location> result = new ArrayList<>(routePlanner.plan(order.getRider().getLocation(), order.getRestaurant().location()));
        result.addAll(routePlanner.plan(order.getRestaurant().location(), order.getDeliveryLocation()));
        return List.copyOf(result);
    }

    public boolean advance(int orderId) {
        FoodOrder order = orders.stream().filter(o -> o.getId() == orderId).findFirst().orElse(null);
        if (order == null || order.getStatus() == OrderStatus.DELIVERED || order.getRider() == null) return false;
        OrderStatus next = order.getStatus().next();
        order.setStatus(next);
        if (next == OrderStatus.DELIVERED) {
            order.getRider().setLocation(order.getDeliveryLocation());
            order.getRider().setAvailable(true);
        } else if (next == OrderStatus.PICKED_UP) {
            order.getRider().setLocation(order.getRestaurant().location());
        }
        return true;
    }
}
