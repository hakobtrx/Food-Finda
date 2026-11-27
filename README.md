# Food-Finda

Food-Finda is a Java console simulator for a small food delivery operation. Place orders from a sample restaurant list, assign available riders, and advance deliveries through pickup and completion. The project demonstrates object-oriented modeling and basic data structures and algorithms.

## Requirements

- Java Development Kit (JDK) 17 or newer
- PowerShell to use the included launcher
- Maven 3.6 or newer if using Maven commands

Check that Java is available with:

```powershell
java -version
javac -version
```

## Run the simulator

From the repository root in PowerShell:

```powershell
.\run.ps1
```

The launcher compiles the Java files into `target/classes` with `javac` and starts `com.foodfinda.Main`. To compile and run with Maven instead:

```powershell
mvn compile exec:java
```

## Using the app

The interactive menu lets you:

1. Place an order by entering a customer name, choosing a restaurant, entering an item and delivery grid coordinates, and marking whether it is urgent.
2. View orders, with urgent orders displayed first.
3. Advance a selected order through its statuses until it is delivered.
4. View riders and their availability and current locations.
0. Exit.

The sample data includes three restaurants and three riders. Each available rider is assigned to the order whose restaurant is nearest by Manhattan distance. The route travels horizontally and then vertically on an unobstructed grid. An assigned rider becomes available again after delivery.

## Project structure

```text
Food-Finda/
├── pom.xml
├── run.ps1
├── README.md
└── src/main/java/com/foodfinda/
    ├── Main.java
    ├── app/FoodFindaApp.java
    ├── algorithms/
    │   ├── OrderPriority.java
    │   └── RoutePlanner.java
    ├── data/DemoData.java
    ├── models/
    └── services/DeliveryService.java
```

## Notes

- Orders and rider state exist only in memory and reset when the app exits.
- The grid is a simple simulation; routes do not account for streets or obstacles.
- The app does not process payments or connect to a real delivery service.
- The Maven project currently uses only the Java standard library. A Swing interface is described in project documentation but is not part of the current runnable prototype.
