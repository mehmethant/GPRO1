import Railroadcar.PassengerRailroadCar;
import Railroadcar.RailroadCar;
import Railway.Connection;
import Railway.RailwayStation;
import Railway.Route;
import Train.Locomotive;
import Train.Trainset;

import java.util.ArrayList;
import java.util.List;

public class Presentation {
    public static void runPresentation() {


        // Create railway stations


       /* Railway.RailwayStation stationA = new Railway.RailwayStation("A");
        Railway.RailwayStation stationB = new Railway.RailwayStation("B");
        Railway.RailwayStation stationC = new Railway.RailwayStation("C");
        Railway.RailwayStation stationD = new Railway.RailwayStation("D");
        Railway.RailwayStation stationF = new Railway.RailwayStation("F");
        Railway.RailwayStation stationG = new Railway.RailwayStation("G");

        System.out.println("Created Railway Stations: " + stationA + ", " + stationB+ ", " + stationC+ ", " + stationD+ ", " + stationF+ ", " + stationG);


        // Create connections

        Railway.Connection connectionAB = new Railway.Connection(stationA, stationB, 100);
        System.out.println("Created Railway.Connection: " + connectionAB);



        Railway.Connection connectionBC = new Railway.Connection(stationB, stationC, 150);
        System.out.println("Created Railway.Connection: " + connectionBC);


        Railway.Connection connectionCD = new Railway.Connection(stationC, stationD, 50);
        System.out.println("Created Railway.Connection: " + connectionCD);


        Railway.Connection connectionDF = new Railway.Connection(stationD, stationF, 200);
        System.out.println("Created Railway.Connection: " + connectionDF);


        Railway.Connection connectionFG = new Railway.Connection(stationF, stationG, 100);
        System.out.println("Created Railway.Connection: " + connectionFG);



        List<Railway.Connection> railWayMap = new ArrayList<>();

        railWayMap.add(connectionAB);
        railWayMap.add(connectionBC);
        railWayMap.add(connectionCD);
        railWayMap.add(connectionDF);
        railWayMap.add(connectionFG);









        Railway.Route route = new Railway.Route(stationA, stationB,railWayMap);
        System.out.println("Created Railway.Route: " + route.getIntermediateStations());

        */
        RailwayStation stationA = new RailwayStation("A");
        RailwayStation stationB = new RailwayStation("B");
        RailwayStation stationC = new RailwayStation("C");
        RailwayStation stationD = new RailwayStation("D");
        RailwayStation stationF = new RailwayStation("F");
        RailwayStation stationG = new RailwayStation("G");

        System.out.println("Created Railway Stations: " + stationA + ", " + stationB+ ", " + stationC+ ", " + stationD+ ", " + stationF+ ", " + stationG+"\n");


        // Create connections

        Connection connectionAB = new Connection(stationA, stationB, 100);
        System.out.println("Created Railway.Connection: " + connectionAB);
        Connection connectionBA = new Connection(stationB, stationA, 100);
        System.out.println("Created Railway.Connection: " + connectionBA);

        Connection connectionBC = new Connection(stationB, stationC, 150);
        System.out.println("Created Railway.Connection: " + connectionBC);
        Connection connectionCB = new Connection(stationC, stationB, 150);
        System.out.println("Created Railway.Connection: " + connectionCB);

        Connection connectionCD = new Connection(stationC, stationD, 50);
        System.out.println("Created Railway.Connection: " + connectionCD);
        Connection connectionDC = new Connection(stationD, stationC, 50);
        System.out.println("Created Railway.Connection: " + connectionDC);

        Connection connectionDF = new Connection(stationD, stationF, 200);
        System.out.println("Created Railway.Connection: " + connectionDF);
        Connection connectionFD = new Connection(stationF, stationD, 200);
        System.out.println("Created Railway.Connection: " + connectionFD);

        Connection connectionFG = new Connection(stationF, stationG, 100);
        System.out.println("Created Railway.Connection: " + connectionFG);
        Connection connectionGF = new Connection(stationG, stationF, 100);
        System.out.println("Created Railway.Connection: " + connectionGF+"\n");



        List<Connection> railWayMap = new ArrayList<>();
        //---------------
        railWayMap.add(connectionAB);
        railWayMap.add(connectionBC);
        railWayMap.add(connectionCD);
        railWayMap.add(connectionDF);
        railWayMap.add(connectionFG);
        railWayMap.add(connectionBA);
        railWayMap.add(connectionCB);
        railWayMap.add(connectionDC);
        railWayMap.add(connectionFD);
        railWayMap.add(connectionGF);




        Route route = new Route(stationC, stationG,railWayMap);
        System.out.println("Created Railway.Route: " + route.getIntermediateStations().replaceAll(","," ---").replace("[","").replace("]","")+
                "\n"+"Distance : "+route.getDistanceBetweenStations()+" Km"+"\n");


        // Create a locomotive
        Locomotive locomotive1 = new Locomotive("Locomotive1", route,
                10, 500, 1000, 5);
        System.out.println("Created Train.Locomotive: " + locomotive1+"\n");

        // Create railroad cars
        PassengerRailroadCar passengerCar1 = new PassengerRailroadCar("P1", "SecurityInfo1",
                10, 30, 50, true);
        System.out.println("Created Railroadcar.PassengerRailroadCar: " + passengerCar1);

        // Attach railroad cars to the locomotive
        locomotive1.attachRailroadCar(passengerCar1);
        System.out.println("Attached Railroadcar.PassengerRailroadCar to Train.Locomotive");

        // Create a trainset
        List<RailroadCar> cars = new ArrayList<>();
        cars.add(passengerCar1);
        Trainset trainset1 = new Trainset(locomotive1);
        trainset1.addRailroadCar(passengerCar1);
        System.out.println("Created Train.Trainset: " + trainset1);



        // New loop to simulate train movement and speed changes
        int distanceCovered = 0;
        int totalDistance = 100; // This should be the total distance of the route, e.g., connectionAB.getDistance()

        while (distanceCovered < totalDistance) {
            locomotive1.setCurrentSpeed(locomotive1.getCurrentSpeed() + 10);
            distanceCovered += 10;
            System.out.println("Current speed of trainset Locomotive1: " + locomotive1.getCurrentSpeed() + " km/h");
            System.out.println("Distance covered: " + distanceCovered + " km");

            if (distanceCovered >= totalDistance) {
                System.out.println("The trainset has arrived at the destination.");
                break;
            }
        }

        while (locomotive1.getCurrentSpeed() > 0) {
            locomotive1.setCurrentSpeed(locomotive1.getCurrentSpeed() - 10);
            System.out.println("Current speed of trainset Locomotive1: " + locomotive1.getCurrentSpeed() + " km/h");
        }

    }

    }

