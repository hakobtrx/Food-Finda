# PriorityQueue

The current implementation does not use `PriorityQueue`. `OrderPriority` defines a comparator that sorts urgent orders first, then earlier placement time, then lower order ID. `DeliveryService.getOrders()` applies that comparator when returning orders. A priority queue would be useful if dispatch were changed to continuously remove the next highest-priority pending order.
