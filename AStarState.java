import java.util.HashMap;


public class AStarState {
    /**
     * This is a reference to the map that the A* algorithm is navigating.
     **/
    private final Map2D map;
    private final HashMap<Location, Waypoint> closedWaypoints;
    private final HashMap<Location, Waypoint> openWaypoints;


    public AStarState(Map2D map) {
        if (map == null)
            throw new NullPointerException("map cannot be null");

        this.map = map;
        this.closedWaypoints = new HashMap<>();
        this.openWaypoints = new HashMap<>();
    }

    public Map2D getMap() {
        return map;
    }

    public Waypoint getMinOpenWaypoint() {
        if (openWaypoints.isEmpty())
            return null;
        return openWaypoints.values().stream()
                .min((w1, w2) -> Float.compare(w1.getTotalCost(), w2.getTotalCost()))
                .get();
    }

    public boolean addOpenWaypoint(Waypoint newWP) {
        Location loc = newWP.getLocation();
        if (!openWaypoints.containsKey(loc)) {
            openWaypoints.put(loc, newWP);
            return true;
        }

        Waypoint oldWP = openWaypoints.get(loc);
        if (Float.compare(newWP.getPreviousCost(), oldWP.getPreviousCost()) < 0) {
            openWaypoints.put(loc, newWP);
            return true;
        }
        return false;
    }


    public int numOpenWaypoints() {
        return openWaypoints.size();
    }


    public void closeWaypoint(Location loc) {
        Waypoint wp = openWaypoints.remove(loc);
        closedWaypoints.put(loc, wp);
    }


    public boolean isLocationClosed(Location loc) {
        return closedWaypoints.containsKey(loc);
    }
}

