# HashMap

The current implementation does not use a `HashMap`. Order lookup scans the in-memory order list by ID. A map from order ID to order could make repeated lookups faster as the simulated order count grows, at the cost of maintaining both ordered and keyed views if display ordering is also needed.
