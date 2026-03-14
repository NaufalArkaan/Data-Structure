public class Schedule {

    private static int counter = 1;

    private int scheduleId;
    private String trainCode;
    private String trainName;
    private String origin;
    private String destination;
    private String departureTime;
    private double fare;

    public Schedule(String trainCode, String trainName, String origin,
                    String destination, String departureTime, double fare) {

        this.scheduleId = counter++;
        this.trainCode = trainCode;
        this.trainName = trainName;
        this.origin = origin;
        this.destination = destination;
        this.departureTime = departureTime;
        this.fare = fare;
    }

    public String getOrigin() {
        return origin;
    }

    public String getDestination() {
        return destination;
    }

    public void setTrainName(String trainName) {
        this.trainName = trainName;
    }

    public void displayInfo() {

        System.out.println(scheduleId + " | " + trainCode + " | " + trainName +
                " | " + origin + " -> " + destination +
                " | " + departureTime + " | " + fare);
    }
}