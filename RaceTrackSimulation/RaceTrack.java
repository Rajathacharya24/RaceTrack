public class RaceTrack {

    // volatile ensures all threads see the updated value immediately
    private volatile boolean raceOver = false;
    private String winner = null;

    // synchronized ensures only ONE thread announces winner
    public synchronized void announceWinner(String carName) {
        if (!raceOver) {
            raceOver = true;
            winner = carName;
            System.out.println("\n" + "=".repeat(40));
            System.out.println("🏆 WINNER: " + carName + " wins the race!");
            System.out.println("=".repeat(40) + "\n");
        } else {
            System.out.println("🥈 " + carName + " finished (but " + winner + " already won)");
        }
    }

    public boolean isRaceOver() { return raceOver; }
    public String getWinner()   { return winner; }
}