
package agh.ics.oop;

public enum MapDirection {
    NORTH,
    SOUTH,
    WEST,
    EAST;

    public String toString() {
        switch (this) {
            case NORTH:
                return "^";

            case SOUTH:
                return "v";

            case EAST:
                return ">";

            case WEST:
                return "<";
        }
        return null;
    }

    public MapDirection next() {
        switch (this) {
            case NORTH:
                return MapDirection.EAST;

            case SOUTH:
                return MapDirection.WEST;

            case EAST:
                return MapDirection.SOUTH;

            case WEST:
                return MapDirection.NORTH;
        }
        return null;
    }
    public MapDirection previous() {
        switch (this) {
            case NORTH:
                return MapDirection.WEST;

            case SOUTH:
                return MapDirection.EAST;

            case EAST:
                return MapDirection.NORTH;

            case WEST:
                return MapDirection.SOUTH;
        }
        return null;
    }

    public Vector2d toUnitVector() {
        switch (this) {
            case NORTH:
                return new Vector2d(0, 1);

            case SOUTH:
                return new Vector2d(0, -1);

            case EAST:
                return new Vector2d(1, 0);

            case WEST:
                return new Vector2d(-1, 0);
        }
        return null;
    }
}
