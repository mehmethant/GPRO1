import Train.Trainset;

import java.util.HashMap;
import java.util.Map;
import java.util.Queue;
import java.util.LinkedList;

public class CollisionPrevention {
    private Map<String, Trainset> activeRoutes;
    private Map<String, Queue<Trainset>> waitingRoutes;

    public CollisionPrevention() {
        this.activeRoutes = new HashMap<>();
        this.waitingRoutes = new HashMap<>();
    }

    public synchronized void requestRoute(Trainset trainset, String route) {
        if (activeRoutes.containsKey(route)) {
            Queue<Trainset> waitingQueue = waitingRoutes.getOrDefault(route, new LinkedList<>());
            waitingQueue.add(trainset);
            waitingRoutes.put(route, waitingQueue);
            System.out.println("Train.Trainset " + trainset + " is waiting for route: " + route);
        } else {
            activeRoutes.put(route, trainset);
            System.out.println("Train.Trainset " + trainset + " has started on route: " + route);
        }
    }

    public synchronized void releaseRoute(String route) {
        if (activeRoutes.containsKey(route)) {
            activeRoutes.remove(route);
            if (waitingRoutes.containsKey(route) && !waitingRoutes.get(route).isEmpty()) {
                Trainset nextTrainset = waitingRoutes.get(route).poll();
                activeRoutes.put(route, nextTrainset);
                System.out.println("Train.Trainset " + nextTrainset + " has started on route: " + route);
            }
        } else {
            System.out.println("Railway.Route not found: " + route);
        }
    }
}
