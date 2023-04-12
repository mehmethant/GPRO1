package Train;

import Railroadcar.RailroadCar;

import java.util.ArrayList;
import java.util.List;

public class Trainset {
    private Locomotive locomotive;
    private List<RailroadCar> railroadCars;

    public Trainset(Locomotive locomotive) {
        this.locomotive = locomotive;
        this.railroadCars = new ArrayList<>();
    }


    public Locomotive getLocomotive() {
        return locomotive;
    }

    public void setLocomotive(Locomotive locomotive) {
        this.locomotive = locomotive;
    }

    public List<RailroadCar> getRailroadCars() {
        return railroadCars;
    }

    public void addRailroadCar(RailroadCar car) {
        // Check if the trainset can accommodate the new railroad car
        // based on the locomotive's limits
        if (railroadCars.size() < locomotive.getMaxRailroadCars()) {
            double totalWeight = getTotalWeight();
            if (totalWeight + car.getGrossWeight() <= locomotive.getMaxWeight()) {
                railroadCars.add(car);
            } else {
                System.out.println("Adding this railroad car exceeds the maximum weight limit.");
            }
        } else {
            System.out.println("Adding this railroad car exceeds the maximum number of railroad cars limit.");
        }
    }

    public void removeRailroadCar(RailroadCar car) {
        railroadCars.remove(car);
    }

    public double getTotalWeight() {
        double totalWeight = 0;
        for (RailroadCar car : railroadCars) {
            totalWeight += car.getGrossWeight();
        }
        return totalWeight;
    }

    @Override
    public String toString() {
        return "Train.Trainset{" +
                "locomotive=" + locomotive +
                ", railroadCars=" + railroadCars +
                '}';
    }
    public String getId() {
        return locomotive.getLocomotiveID().toString();
    }



}
