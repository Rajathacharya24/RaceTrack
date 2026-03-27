import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class RaceSimulator {

    public static void main(String[] args) throws InterruptedException {

        System.out.println("========================================");
        System.out.println("       🏁 JAVA RACE TRACK SIMULATION     ");
        System.out.println("========================================");
        System.out.println("Track Distance: 100 km");
        System.out.println("Cars: 4");
        System.out.println("========================================\n");

        // Shared race track
        RaceTrack track = new RaceTrack();

        // Create cars with different speeds
        List<Car> cars = new ArrayList<>();
        cars.add(new Car("Ferrari",    10, track));
        cars.add(new Car("Lamborghini", 9, track));
        cars.add(new Car("BMW",         8, track));
        cars.add(new Car("Mustang",     7, track));

        // ExecutorService manages all threads
        ExecutorService executor = Executors.newFixedThreadPool(cars.size());

        System.out.println("🚦 GET READY...");
        Thread.sleep(1000);
        System.out.println("🚦 SET...");
        Thread.sleep(1000);
        System.out.println("🟢 GO GO GO!\n");

        // Submit each car as a task
        for (Car car : cars) {
            executor.submit(car);
        }

        // Wait for all threads to finish
        executor.shutdown();
        executor.awaitTermination(5, TimeUnit.MINUTES);

        // Final result
        System.out.println("\n========================================");
        System.out.println("🏁 RACE FINISHED!");
        System.out.println("🥇 Champion: " + track.getWinner());
        System.out.println("========================================");
    }
}