package Railway;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

public class RailwayStation {
    private String name;
    private UUID stationID;
    private List<RailwayStation> stations;

    public RailwayStation(String name) {
        this.name = name;
        this.stationID = UUID.randomUUID();
        this.stations = new ArrayList<>();
    }

    public String getName() {
        return name;
    }



    public UUID getStationID() {
        return stationID;
    }

    //bak
    public List<RailwayStation> getConnectedStations() {
        return stations;
    }



    public void removeConnectedStation(RailwayStation station) {
        if (stations.contains(station)) {
            stations.remove(station);
            station.removeConnectedStation(this);
        }
    }

    @Override
    public String toString() {
        return "Railway.RailwayStation{" +
                "name='" + name + '\'' +
                ", stationID=" + stationID +
                '}';
    }
}
