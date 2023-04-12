import Railroadcar.PassengerRailroadCar;
import Railway.Connection;
import Railway.RailwayStation;
import Railway.Route;
import Train.Locomotive;
import Train.Trainset;

import java.util.ArrayList;
import java.util.List;

public class Application {

    public static void runApplication() {
        // Move the existing code from the main method here



        // Create railway stations
        RailwayStation stationA = new RailwayStation("A");
        RailwayStation stationB = new RailwayStation("B");
        RailwayStation stationC = new RailwayStation("C");

        // Create connections
        Connection connectionAB = new Connection(stationA, stationB, 100);
        Connection connectionBC = new Connection(stationB, stationC, 150);
        List<Connection> railwayMap= new ArrayList<>();
        railwayMap.add(connectionAB);
        railwayMap.add(connectionBC);
        Route route=new Route(stationA,stationB,railwayMap);
        // Create a locomotive
        // Create a locomotive
        // Create a locomotive
        Locomotive locomotive1 = new Locomotive("Locomotive1",route ,
                10, 1000, 5, 0);

        // Create railroad cars
        PassengerRailroadCar passengerCar1 = new PassengerRailroadCar("P1", "Passenger",
                10, 30, 50, true);

        // Attach railroad cars to the locomotive
        locomotive1.attachRailroadCar(passengerCar1);

        // Create a trainset
        Trainset trainset1 = new Trainset(locomotive1);

        System.out.println("Created Train.Trainset: " + trainset1);

        // Start the trainset movement simulation
        simulateTrainMovement(trainset1);
    }

    private static void simulateTrainMovement(Trainset trainset) {
        // This is a simple demonstration of a train movement simulation
        // In a complete application, you would need to implement more complex logic,
        // such as moving the trainset between railway stations and handling collisions
        Thread trainMovementThread = new Thread(() -> {
            while (true) {
                try {
                    double speed = trainset.getLocomotive().getCurrentSpeed();
                    System.out.println("Current speed of trainset " + trainset.getLocomotive().getName() + ": " + speed + " km/h");
                    trainset.getLocomotive().updateSpeed(10);
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        });

        trainMovementThread.start();

    }

}
