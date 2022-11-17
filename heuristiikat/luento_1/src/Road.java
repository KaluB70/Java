public class Road {
    private final long distance;
    private final long speedLimit;

    public Road(long distance, long speedLimit) {
        this.distance = distance;
        this.speedLimit = speedLimit;
    }

    public long getDistance() {
        return distance;
    }

    public long getSpeedLimit() {
        return speedLimit;
    }

    public double getTravelTime() {
        return toMinutes(((double)distance / (double) speedLimit));
    }

    private double toMinutes(double hours) {
        // Return hours in minutes with 2 decimal places
        return Math.round(hours * 60 * 100) / 100.0;
    }

    @Override
    public String toString() {

        return System.lineSeparator() +
                "Distance: " + distance + " km" + System.lineSeparator() +
                "Speed limit: " + speedLimit + " km/h" + System.lineSeparator() +
                "Time: " + getTravelTime() + " min" + System.lineSeparator();
    }
}