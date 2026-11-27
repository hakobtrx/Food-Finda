# Routes Module

`RoutePlanner` constructs a grid route as a list of coordinate locations. For an assigned order, `DeliveryService.route()` concatenates the path from the rider's current position to the restaurant with the path from the restaurant to the customer. The grid has no obstacles or road restrictions.
