package Railroadcar;

public class RailroadPostOffice extends RailroadCar {
    private int numberOfMailbags;
    private static String SecurityInfo;
    private boolean requiresElectricConnection;

    public RailroadPostOffice(String id, double netWeight, double grossWeight, int numberOfMailbags) {
        super(id,SecurityInfo, netWeight, grossWeight);
        this.numberOfMailbags = numberOfMailbags;
        this.requiresElectricConnection = true;
    }

    public int getNumberOfMailbags() {
        return numberOfMailbags;
    }

    public void setNumberOfMailbags(int numberOfMailbags) {
        this.numberOfMailbags = numberOfMailbags;
    }

    @Override
    public String getTypeSpecificFeatures() {
        return null;
    }

    @Override
    public boolean requiresElectricConnection() {
        return requiresElectricConnection;
    }

    @Override
    public String toString() {
        return "Railroadcar.RailroadPostOffice{" +
                "id='" + getRailroadCarID()+ '\'' +
                ", netWeight=" + getNetWeight() +
                ", grossWeight=" + getGrossWeight() +
                ", numberOfMailbags=" + numberOfMailbags +
                ", requiresElectricConnection=" + requiresElectricConnection +
                '}';
    }
}
