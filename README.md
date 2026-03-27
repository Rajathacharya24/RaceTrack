# Race Track Simulation (Java)

A simple multithreaded Java console project where multiple cars race on a 100 km track.
Each car runs on its own thread, and the first car to finish is declared the winner.

## Features

- Multithreaded race using `Runnable`
- `ExecutorService` to manage car threads
- Thread-safe winner announcement using `synchronized`
- Shared race state with `volatile` visibility
- Random speed boost each move for realistic race variation
- Clean race-start and race-finish console output

## Project Structure

- `RaceSimulator.java` - Main class to start the race and manage threads
- `Car.java` - Car behavior (`Runnable`), movement logic, and progress output
- `RaceTrack.java` - Shared race state and winner announcement logic

## How It Works

1. `RaceSimulator` creates one shared `RaceTrack` object.
2. Four cars are created with different base speeds.
3. Each car is submitted to an `ExecutorService` thread pool.
4. Cars move forward in loops until one reaches 100 km.
5. The first car to finish calls `announceWinner()`.
6. Other cars stop when race is over or finish after the winner.

## Requirements

- Java 11 or later (uses `String.repeat()`)

## Compile and Run

From the project folder in PowerShell:

```powershell
javac *.java
java RaceSimulator
```

## Example Output (Sample)

```text
========================================
       JAVA RACE TRACK SIMULATION
========================================
Track Distance: 100 km
Cars: 4

GO GO GO!

Ferrari         -> 12 / 100 km
BMW             -> 10 / 100 km
Lamborghini     -> 13 / 100 km
Mustang         -> 9 / 100 km
...

========================================
WINNER: Ferrari wins the race!
========================================

RACE FINISHED!
Champion: Ferrari
```

Note: Actual winner and progress will vary each run due to randomness.

## Learning Concepts Demonstrated

- Java threads and `Runnable`
- Concurrency with `ExecutorService`
- Synchronization (`synchronized`)
- Visibility guarantees with `volatile`
- Graceful task shutdown with `awaitTermination`

## Possible Enhancements

- Add lap-based racing instead of fixed distance
- Add obstacle/weather effects
- Add configurable number of cars from user input
- Save race results to a file
- Build a GUI version (JavaFX/Swing)
# RaceTrack
