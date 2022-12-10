
public class Location {

    public int xCord;

    public int yCord;


    public Location(int x, int y) {
        xCord = x;
        yCord = y;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o)
            return true;
        if (o == null || getClass() != o.getClass())
            return false;

        Location location = (Location) o;

        if (xCord != location.xCord)
            return false;
        return yCord == location.yCord;
    }

    @Override
    public int hashCode() {
        int result = 7;
        result = 31 * result + xCord;
        result = 31 * result + yCord;
        return result;
    }
}
