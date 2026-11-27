package com.foodfinda.data;

import com.foodfinda.models.Location;
import com.foodfinda.models.Restaurant;
import com.foodfinda.models.Rider;
import java.util.List;

public final class DemoData {
    private DemoData() { }
    public static List<Restaurant> restaurants() {
        return List.of(new Restaurant("Noodle House", new Location(2, 3)),
                new Restaurant("Green Bowl", new Location(7, 2)),
                new Restaurant("Burger Corner", new Location(4, 8)));
    }
    public static List<Rider> riders() {
        return List.of(new Rider("Ari", new Location(0, 0)),
                new Rider("Bea", new Location(5, 4)),
                new Rider("Chen", new Location(9, 7)));
    }
}
