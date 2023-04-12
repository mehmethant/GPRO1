package Railway;

import java.util.List;

public class Connection {
    private RailwayStation station1;
    private RailwayStation station2;
    private double distance;

    public Connection(RailwayStation station1, RailwayStation station2, double distance) {
        this.station1 = station1;
        this.station2 = station2;
        this.distance = distance;
    }

    public RailwayStation getStation1() {
        return station1;
    }

    public void setStation1(RailwayStation station1) {
        this.station1 = station1;
    }

    public RailwayStation getStation2() {
        return station2;
    }

    public void setStation2(RailwayStation station2) {
        this.station2 = station2;
    }

    public double getDistance() {
        return distance;
    }

    public void setDistance(double distance) {
        this.distance = distance;
    }
    public double calculateTravelTime(double speed) {
        // Assuming speed is in km/h
        return (getDistance() / speed) * 60; // Convert the time to minutes
    }

    public void saveConnection(){

    }
    private static void addConnection(List<Connection> railWayMap, RailwayStation from, RailwayStation to, int distance) {
        Connection connection = new Connection(from, to, distance);
        railWayMap.add(connection);

        Connection reverseConnection = new Connection(to, from, distance);
        railWayMap.add(reverseConnection);

        System.out.printf("Created Railway.Connection: %s%n", connection);
        System.out.printf("Created Railway.Connection: %s%n", reverseConnection);
    }


    @Override
    public String toString() {
        return "Railway.Connection{" +
                "station1=" + station1 +
                ", station2=" + station2 +
                ", distance=" + distance +
                '}';
    }
}
