public class Route {
    String destination;
    int distance;
    int travelTime;
    double fare;

    public Route(String destination, int distance, int travelTime, double fare) {
        this.destination = destination;
        this.distance = distance;
        this.travelTime = travelTime;
        this.fare = fare;
    }

    @Override
    public String toString() {
        return "Destination=" + destination +
                ", Distance=" + distance +
                " km, Time=" + travelTime +
                " min, Fare=Rp" + fare;
    }
}