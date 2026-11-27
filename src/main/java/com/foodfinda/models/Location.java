package com.foodfinda.models;

/** A point on the simulator's simple city grid. */
public record Location(int x, int y) {
    public int manhattanDistanceTo(Location other) {
        return Math.abs(x - other.x) + Math.abs(y - other.y);
    }

    @Override
    public String toString() { return "(" + x + ", " + y + ")"; }
}
