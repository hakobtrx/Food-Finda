# Riders Module

`Rider` stores a name, current grid location, and availability. Demo riders are created by `DemoData`. `DeliveryService` assigns the available rider with the smallest Manhattan distance to the order's restaurant. An assigned rider becomes unavailable until the delivery reaches `DELIVERED`.
