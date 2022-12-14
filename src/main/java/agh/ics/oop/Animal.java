package agh.ics.oop;
import java.util.ArrayList;
import java.util.List;

public class Animal extends AbstractWorldMapElement {
    private MapDirection orientation = MapDirection.NORTH;
    private IWorldMap map;
    private List<IPositionChangeObserver> observers = new ArrayList<>();

    public Animal(){
        this(new RectangularMap(4,4));
    }

    public Animal(IWorldMap map) {
        this(map, new Vector2d(2,2));
    }

    public Animal(IWorldMap map, Vector2d startingPosition) {
        this.map = map;
        this.position = startingPosition;
        this.orientation = MapDirection.NORTH;
    }


    public String toString() {
        return this.orientation.toString();
    }

    @Override
    public String getImagePath() {
        switch(this.orientation) {
            case NORTH -> {return "src/main/resources/N2.jpg";}
            case EAST-> {return "src/main/resources/E2.jpg";}
            case SOUTH-> {return "src/main/resources/S2.jpg";}
            case WEST -> {return "src/main/resources/W2.jpg";}
        }
        return null;
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
            positionChanged(this.position, newPosition);
            this.position = newPosition;

        }


    }

    public void removeObserver(IPositionChangeObserver observer) {
        observers.remove(observer);
    }
    public void addObserver(IPositionChangeObserver observer) {
        observers.add(observer);
    }
    private void positionChanged(Vector2d oldPosition, Vector2d newPosition){
        for (IPositionChangeObserver observer : observers){
            observer.positionChanged(oldPosition, newPosition);
        }
    }
}


