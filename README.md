# FoodFinda

FoodFinda is a Java console simulator for an online food delivery workflow. It accepts orders, prioritizes urgent orders, assigns the nearest available rider, displays a simple grid route, and tracks pickup and delivery.

## Requirements

- Java 17 or newer
- Maven (optional when using the PowerShell launcher)

## Run

From the project root in PowerShell:

```powershell
.\run.ps1
```

With Maven:

```powershell
mvn compile exec:java
```

## Documentation

Project documentation is organized under [`docs/`](docs/): overview and scope, environment setup, system design, UI notes, DSA implementation, module descriptions, testing guidance, collaboration log, and final evaluation.

## Project structure

```text
Food-Finda/
├── docs/
│   ├── 01_Project_Overview/
│   ├── 02_Environment_Setup/
│   ├── 03_System_Design/
│   ├── 04_UI_Development/
│   ├── 05_DSA_Implementation/
│   ├── 06_Module_Development/
│   ├── 07_Testing/
│   ├── 08_Collaboration/
│   └── 09_Final_Evaluation/
├── pom.xml
├── run.ps1
└── src/
```

Orders and riders are held in memory and reset when the app exits. Routes use a simple grid and do not model real roads, maps, or traffic. Payments and live delivery tracking are out of scope.
