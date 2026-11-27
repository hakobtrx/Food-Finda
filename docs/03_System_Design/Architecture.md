# Architecture

FoodFinda is a small layered console application:

- `Main` starts `FoodFindaApp`.
- `app` handles prompts, input validation, and display.
- `models` holds order, rider, restaurant, location, and status data.
- `services` coordinates rider assignment, routes, and order progress.
- `algorithms` contains the grid route planner and order priority comparator.
- `data` supplies the in-memory demo restaurant and rider lists.

The app depends on the delivery service; the service uses model classes and the route and priority algorithms. No database or network service is used.
