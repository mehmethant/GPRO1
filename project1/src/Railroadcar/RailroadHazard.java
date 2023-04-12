package Railroadcar;

import Train.Trainset;

public class RailroadHazard extends Exception {
    private Trainset trainset;

    public RailroadHazard(Trainset trainset) {
        super("Railroad hazard: Train.Trainset " + trainset.getId() + " exceeded the speed of 200 km/h.");
        this.trainset = trainset;
    }

    public Trainset getTrainset() {
        return trainset;
    }

    public void setTrainset(Trainset trainset) {
        this.trainset = trainset;
    }
}
