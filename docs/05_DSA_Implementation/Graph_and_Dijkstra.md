# Graph and Dijkstra

The current route planner does not model roads as a graph and does not run Dijkstra's algorithm. `RoutePlanner` creates a deterministic shortest Manhattan path on an obstacle-free grid: it moves horizontally to the target X coordinate, then vertically to the target Y coordinate. This path has length `|dx| + |dy|`.

The nearest available rider is selected using Manhattan distance from the rider's current location to the restaurant. A weighted road graph and Dijkstra's algorithm would be needed for realistic route costs, obstacles, or different travel times.
