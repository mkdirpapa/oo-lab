package agh.ics.oop;

public class Animal {
    private MapDirection orientation = MapDirection.NORTH;
    private Vector2d position = new Vector2d(2, 2);
    private IWorldMap map;

    public Animal(IWorldMap map) {
        this.map = map;
    }

    public Animal(IWorldMap map, Vector2d startingPosition) {
        this.map = map;
        this.position = startingPosition;
        this.orientation = MapDirection.NORTH;
    }


    public String toString() {
        return this.orientation.toString();
    }

    public Vector2d getPosition(){
        return this.position;
    }

    public boolean isAt(Vector2d position) {
        return this.position.equals(position);
    }

    public boolean isOriented(MapDirection orientation) {
        return this.orientation.equals(orientation);
    }

    public void move(MoveDirection direction) {
        Vector2d newPosition = position;
        switch (direction) {
            case RIGHT -> orientation = orientation.next();
            case LEFT -> orientation = orientation.previous();
            case FORWARD -> newPosition = position.add(orientation.toUnitVector());
            case BACKWARD -> newPosition = position.subtract(orientation.toUnitVector());


        }

        if (this.map.canMoveTo(newPosition)) {
            this.position = newPosition;
        }


    }


}

    //Aby uniknac zderzania się zwierząt, informację o tym, czy pole jest zajmowane, czy nie, można przechowywać
    // w tablicy, w nowym polu w klasie World, którą przekazujemy i modyfikujemy podczas ruchu zwierzecia


