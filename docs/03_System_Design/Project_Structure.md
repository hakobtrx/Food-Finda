# Project Structure

```text
Food-Finda/
├── docs/                         # Project and implementation documentation
├── pom.xml                       # Maven build configuration (Java 17)
├── run.ps1                       # Compile and run without Maven
├── README.md
└── src/
    ├── main/java/com/foodfinda/
    │   ├── Main.java
    │   ├── app/                  # Console workflow
    │   ├── ui/                   # Reserved for UI code
    │   ├── models/               # Domain objects
    │   ├── services/             # Delivery workflow
    │   ├── algorithms/           # Route and priority logic
    │   ├── data/                 # Demo data
    │   └── utils/                # Reserved for shared utilities
    ├── main/resources/           # Reserved for assets
    └── test/java/                # Reserved for automated tests
```

See [Class_Diagram.png](Class_Diagram.png) for the main class relationships.
