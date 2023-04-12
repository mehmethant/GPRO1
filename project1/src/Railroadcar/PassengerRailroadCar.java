package Railroadcar;

import Railroadcar.RailroadCar;

public class PassengerRailroadCar extends RailroadCar {
    private int numberOfSeats;
    private boolean electricalConnectionRequired;
    // Additional unique features (add at least two)

    public PassengerRailroadCar(String shipper, String securityInfo, double netWeight, double grossWeight, int numberOfSeats, boolean electricalConnectionRequired) {
        super(shipper, securityInfo, netWeight, grossWeight);
        this.numberOfSeats = numberOfSeats;
        this.electricalConnectionRequired = electricalConnectionRequired;
        // Initialize additional unique features
    }

    @Override
    public String getTypeSpecificFeatures() {
        // Return a string with the unique features specific to this type of railroad car
        // Include additional unique features
        return "Number of seats: " + numberOfSeats + ", Electrical connection required: " + electricalConnectionRequired;
    }

    @Override
    public boolean requiresElectricConnection() {
        return false;
    }

    public int getNumberOfSeats() {
        return numberOfSeats;
    }

    public void setNumberOfSeats(int numberOfSeats) {
        this.numberOfSeats = numberOfSeats;
    }

    public boolean isElectricalConnectionRequired() {
        return electricalConnectionRequired;
    }

    public void setElectricalConnectionRequired(boolean electricalConnectionRequired) {
        this.electricalConnectionRequired = electricalConnectionRequired;
    }

    // Getter and setter methods for additional unique features

    @Override
    public String toString() {
        return "Railroadcar.PassengerRailroadCar{" +
                "numberOfSeats=" + numberOfSeats +
                ", electricalConnectionRequired=" + electricalConnectionRequired +
                // Include additional unique features
                "} " + super.toString();
    }
}
