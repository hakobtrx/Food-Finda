package com.foodfinda.algorithms;

import com.foodfinda.models.FoodOrder;
import java.util.Comparator;

/** Urgent orders come first; orders with the same urgency stay in arrival order. */
public final class OrderPriority {
    private OrderPriority() { }
    public static Comparator<FoodOrder> comparator() {
        return Comparator.comparing(FoodOrder::isUrgent).reversed()
                .thenComparing(FoodOrder::getPlacedAt).thenComparingInt(FoodOrder::getId);
    }
}
