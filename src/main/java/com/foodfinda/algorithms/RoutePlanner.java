package com.foodfinda.algorithms;

import com.foodfinda.models.Location;
import java.util.List;

/** Plans a deterministic shortest path on a grid (horizontal, then vertical). */
public class RoutePlanner {
    public List<Location> plan(Location from, Location to) {
        java.util.ArrayList<Location> route = new java.util.ArrayList<>();
        int x = from.x();
        int y = from.y();
        while (x != to.x()) {
            x += Integer.compare(to.x(), x);
            route.add(new Location(x, y));
        }
        while (y != to.y()) {
            y += Integer.compare(to.y(), y);
            route.add(new Location(x, y));
        }
        return List.copyOf(route);
    }

    public int distance(Location from, Location to) { return from.manhattanDistanceTo(to); }
}
