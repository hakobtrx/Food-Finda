# Architecture

FoodFinda is structured as a small layered application. The current workflow can be exercised through a temporary console prototype while a user interface is integrated:

- `Main` starts `FoodFindaApp`.
- `app` currently handles the prototype prompts, input validation, and display; UI integration can use the service and model layers.
- `models` holds order, rider, restaurant, location, and status data.
- `services` coordinates rider assignment, routes, and order progress.
- `algorithms` contains the grid route planner and order priority comparator.
- `data` supplies the in-memory demo restaurant and rider lists.

The app depends on the delivery service; the service uses model classes and the route and priority algorithms. No database or network service is used.
