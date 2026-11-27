# Final Report

## Project summary

FoodFinda is a console-based simulation of a food delivery workflow. It accepts orders, prioritizes urgent orders in the displayed order list, assigns the nearest available rider, computes an obstacle-free grid route, and tracks manual status changes through delivery.

## DSA concepts demonstrated

- Array-backed lists store orders, riders, and route coordinates.
- A comparator orders urgent and earlier orders first.
- Manhattan distance supports rider selection and shortest paths on the simple grid.
- Object-oriented models represent orders, riders, restaurants, locations, and statuses.

## Current limitations

The app uses demo data and volatile in-memory storage. It has no graphical interface, map data, payments, persistence, or automated test suite. Routes do not account for road networks, traffic, or obstacles. `HashMap`, queue, linked list, and Dijkstra graph routing are not implemented.

## Future work

Add automated tests, persistent storage, explicit pending-order dispatch, a graph-based road model, and a graphical interface if required by the project goals.
