
public class Map2D {

    private final int width;


    private final int height;


    private final int[][] cells;

    private Location start;

    private Location finish;


    public Map2D(int width, int height) {
        if (width <= 0 || height <= 0) {
            throw new IllegalArgumentException(
                    "width and height must be positive values; got " + width +
                            "x" + height);
        }

        this.width = width;
        this.height = height;

        cells = new int[width][height];


        start = new Location(0, height / 2);
        finish = new Location(width - 1, height / 2);
    }


    private void checkCoords(int x, int y) {
        if (x < 0 || x > width) {
            throw new IllegalArgumentException("x must be in range [0, " +
                    width + "), got " + x);
        }

        if (y < 0 || y > height) {
            throw new IllegalArgumentException("y must be in range [0, " +
                    height + "), got " + y);
        }
    }

    public int getWidth() {
        return width;
    }

    public int getHeight() {
        return height;
    }


    public boolean contains(int x, int y) {
        return (x >= 0 && x < width && y >= 0 && y < height);
    }


    public boolean contains(Location loc) {
        return contains(loc.xCord, loc.yCord);
    }


    public int getCellValue(int x, int y) {
        checkCoords(x, y);
        return cells[x][y];
    }


    public int getCellValue(Location loc) {
        return getCellValue(loc.xCord, loc.yCord);
    }


    public void setCellValue(int x, int y, int value) {
        checkCoords(x, y);
        cells[x][y] = value;
    }


    public Location getStart() {
        return start;
    }


    public void setStart(Location loc) {
        if (loc == null)
            throw new NullPointerException("loc cannot be null");

        start = loc;
    }


    public Location getFinish() {
        return finish;
    }


    public void setFinish(Location loc) {
        if (loc == null)
            throw new NullPointerException("loc cannot be null");

        finish = loc;
    }
}
