package extra;

import Railway.Connection;
import Railway.RailwayStation;
import Railway.Route;

import java.util.ArrayList;
import java.util.List;

public class Test {
    public static void main(String[] args) {
        RailwayStation stationA = new RailwayStation("A");
        RailwayStation stationB = new RailwayStation("B");
        RailwayStation stationC = new RailwayStation("C");
        RailwayStation stationD = new RailwayStation("D");
        RailwayStation stationF = new RailwayStation("F");
        RailwayStation stationG = new RailwayStation("G");

        System.out.println("Created Railway Stations: " + stationA + ", " + stationB+ ", " + stationC+ ", " + stationD+ ", " + stationF+ ", " + stationG);


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
        System.out.println("Created Railway.Connection: " + connectionGF);



        List<Connection> railWayMap = new ArrayList<>();

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
        System.out.println("Created Railway.Route: " + route.getIntermediateStations()+" Railway.Route : "+route.getDistanceBetweenStations()+" Km");



    }
}
