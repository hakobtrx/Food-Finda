# ArrayList

`DeliveryService` stores the riders and orders in `ArrayList` instances. The service adds new orders, scans riders to find an available candidate, and returns an immutable sorted view of orders. The in-memory lists are appropriate for this small simulator; their contents are lost when the process exits.
