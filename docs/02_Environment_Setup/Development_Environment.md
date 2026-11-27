# Development Environment

## Requirements

- JDK 17 or newer (the project uses Java records and targets release 17).
- PowerShell on Windows to use `run.ps1`.
- Maven is optional.

## Run with the included script

From the repository root:

```powershell
.\run.ps1
```

The script compiles all Java files under `src/main/java` into `target/classes` and starts `com.foodfinda.Main`.

## Run with Maven

```powershell
mvn compile exec:java
```

Run commands from the project root. Compiling `Main.java` by itself inside the package directory will not compile its dependent packages.
