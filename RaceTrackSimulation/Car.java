import java.util.Random;

public class Car implements Runnable {

    private String name;
    private int speed;       // steps per move
    private RaceTrack track;
    private static final int TOTAL_DISTANCE = 100;

    public Car(String name, int speed, RaceTrack track) {
        this.name = name;
        this.speed = speed;
        this.track = track;
    }

    @Override
    public void run() {
        int distance = 0;
        Random random = new Random();

        System.out.println("🚗 " + name + " is ready!");

        try {
            while (distance < TOTAL_DISTANCE) {

                // Check if race is already won
                if (track.isRaceOver()) {
                    System.out.println("🛑 " + name + " stopped (race over)");
                    return;
                }

                // Move forward by speed + small random boost
                int move = speed + random.nextInt(5);
                distance += move;

                // Cap at 100
                if (distance > TOTAL_DISTANCE) distance = TOTAL_DISTANCE;

                System.out.printf("🚗 %-15s → %d / %d km%n", name, distance, TOTAL_DISTANCE);

                // Simulate driving time
                Thread.sleep(300 + random.nextInt(300));
            }

            // Car finished — announce if first
            track.announceWinner(name);

        } catch (InterruptedException e) {
            System.out.println("⚠️ " + name + " was interrupted!");
            Thread.currentThread().interrupt();
        }
    }

    public String getName() { return name; }
}