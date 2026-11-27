# FoodFinda

A small Java console simulator for an online food delivery workflow. It accepts orders, prioritizes urgent orders, assigns the nearest available rider, prints a grid route, and tracks pickup and delivery.

## Requirements

- Java 17 or newer
- Maven (optional if using the PowerShell launcher)

## Run

From the project root:

```powershell
.\run.ps1
```

With Maven, run `mvn compile exec:java`.

## Project layout

```text
Food-Finda/
├── pom.xml
├── README.md
├── .gitignore
└── src/
    ├── main/
    │   ├── java/com/foodfinda/
    │   │   ├── Main.java
    │   │   ├── app/
    │   │   ├── ui/
    │   │   ├── models/
    │   │   ├── services/
    │   │   ├── algorithms/
    │   │   ├── data/
    │   │   └── utils/
    │   └── resources/
    │       ├── icons/
    │       ├── images/
    │       └── fonts/
    └── test/
        └── java/
```

Orders and riders currently live in memory and reset when the program exits. Grid routing is a deterministic shortest path; the simulator uses no real maps, payment processing, or live delivery service.
