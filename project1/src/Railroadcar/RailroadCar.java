package Railroadcar;

import java.util.Random;
import java.util.UUID;

public abstract class RailroadCar {
    private String shipper;
    private String securityInfo;
    private double netWeight;
    private double grossWeight;
    private UUID railroadCarID;

    public RailroadCar(String shipper, String securityInfo, double netWeight, double grossWeight) {
        this.shipper = shipper;
        this.securityInfo = securityInfo;
        this.netWeight = netWeight;
        this.grossWeight = grossWeight;
        this.railroadCarID = UUID.randomUUID();
    }

    public abstract String getTypeSpecificFeatures();

    public String getShipper() {
        return shipper;
    }

    public void setShipper(String shipper) {
        this.shipper = shipper;
    }

    public String getSecurityInfo() {
        return securityInfo;
    }

    public void setSecurityInfo(String securityInfo) {
        this.securityInfo = securityInfo;
    }

    public double getNetWeight() {
        return netWeight;
    }

    public void setNetWeight(double netWeight) {
        this.netWeight = netWeight;
    }

    public double getGrossWeight() {
        return grossWeight;
    }

    public void setGrossWeight(double grossWeight) {
        this.grossWeight = grossWeight;
    }

    public String getRailroadCarID() {
        return railroadCarID.toString();
    }

    public abstract boolean requiresElectricConnection();

    @Override
    public String toString() {
        return "Railroadcar.RailroadCar{" +
                "shipper='" + shipper + '\'' +
                ", securityInfo='" + securityInfo + '\'' +
                ", netWeight=" + netWeight +
                ", grossWeight=" + grossWeight +
                ", railroadCarID=" + railroadCarID +
                '}';
    }
}
