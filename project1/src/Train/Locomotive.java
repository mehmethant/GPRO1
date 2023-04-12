package Train;

import Railroadcar.RailroadCar;
import Railway.RailwayStation;
import Railway.Route;

import java.util.UUID;

public class Locomotive {
    private String name;
    private RailwayStation homeStation;
    private RailwayStation currentStation;
    private RailwayStation destinationStation;
    private UUID locomotiveID;
    private int maxRailroadCars;
    private double maxWeight;
    private int maxElectricalConnections;
    private double currentSpeed;
    private Route route;


    public Locomotive(String name, Route route, int maxRailroadCars, double maxWeight, int maxElectricalConnections, double initialSpeed) {
        this.locomotiveID = UUID.randomUUID();
        this.name = name;
        this.homeStation = route.getOrigin();
        this.destinationStation = route.getDestination();
        this.maxRailroadCars = maxRailroadCars;
        this.maxWeight = maxWeight;
        this.maxElectricalConnections = maxElectricalConnections;
        this.currentSpeed = initialSpeed;
        this.route=route;

    }




    public String getName() {
        return name;
    }
    public UUID getLocomotiveID() {
        return locomotiveID;
    }
    public int getMaxRailroadCars() {
        return maxRailroadCars;
    }
    public double getMaxWeight() {
        return maxWeight;
    }
    public double getCurrentSpeed() {
        return currentSpeed;
    }

    public void setCurrentSpeed(double currentSpeed) {
        this.currentSpeed = currentSpeed;
    }

    public double distanceToNextStation(Locomotive locomotive){
        locomotive.route.getIntermediateStations();

        return 0;
    }

    @Override
    public String toString() {
        return "Train.Locomotive{" +
                "name='" + name + '\'' +
                ", homeStation=" + homeStation +
                ", sourceStation=" + currentStation +
                ", destinationStation=" + destinationStation +
                ", locomotiveID=" + locomotiveID +
                ", maxRailroadCars=" + maxRailroadCars +
                ", maxWeight=" + maxWeight +
                ", maxElectricalConnections=" + maxElectricalConnections +
                ", currentSpeed=" + currentSpeed +
                '}';
    }

    public void attachRailroadCar(RailroadCar railroadCar) {
        maxRailroadCars--;
    }
    public void updateSpeed(double increment) {
        setCurrentSpeed(getCurrentSpeed() + increment);
    }
    public void move(Route route, double acceleration, double deceleration, double maxSpeed) {
        double distance = route.getDistanceBetweenStations();
        double currentSpeed = this.getCurrentSpeed();
        double distanceCovered = 0;

        while (distanceCovered < distance) {
            // Accelerate the train
            if (currentSpeed < maxSpeed) {
                currentSpeed += acceleration;
                if (currentSpeed > maxSpeed) {
                    currentSpeed = maxSpeed;
                }
            }

            distanceCovered += currentSpeed / 60; // Assuming currentSpeed is in km/h and time step is 1 minute

            // Decelerate the train if it's close to the destination
            double remainingDistance = distance - distanceCovered;
            double requiredDistanceToStop = (currentSpeed * currentSpeed) / (2 * deceleration);

            if (remainingDistance <= requiredDistanceToStop) {
                currentSpeed -= deceleration;
                if (currentSpeed < 0) {
                    currentSpeed = 0;
                }
            }

            System.out.printf("Current speed of trainset %s: %.1f km/h%n", this.getName(), currentSpeed);
            System.out.printf("Distance covered: %.1f km%n", distanceCovered);
        }

        System.out.println("The trainset has arrived at the destination.");
    }

    public void setName(String name) {
        this.name = name;
    }
    public RailwayStation getHomeStation() {
        return homeStation;
    }
    public void setHomeStation(RailwayStation homeStation) {
        this.homeStation = homeStation;
    }
    public RailwayStation getSourceStation() {
        return currentStation;
    }
    public void setSourceStation(RailwayStation sourceStation) {
        this.currentStation = sourceStation;
    }
    public RailwayStation getDestinationStation() {
        return destinationStation;
    }
    public void setDestinationStation(RailwayStation destinationStation) {this.destinationStation = destinationStation;}
    public int getMaxElectricalConnections() {
        return maxElectricalConnections;
    }

}
