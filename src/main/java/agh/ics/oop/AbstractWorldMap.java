package agh.ics.oop;
import java.util.HashMap;
import java.util.Map;

public abstract class AbstractWorldMap implements IWorldMap, IPositionChangeObserver{

    protected final Map<Vector2d, Animal> animals = new HashMap<>();
    protected final MapBoundary mapBoundary = new MapBoundary();
    public void place(Animal animal) throws IllegalArgumentException{
        if (this.canMoveTo(animal.getPosition())) {
            animals.put(animal.getPosition(), animal);
            animal.addObserver(this);
            mapBoundary.addPosition(animal.getPosition());
        }
        else {
            throw new IllegalArgumentException("cannot place an Animal on " + animal.getPosition());
        }
    }

    public Object objectAt(Vector2d position) {
        return animals.get(position);
    }

    public boolean isOccupied(Vector2d position) {

        return objectAt(position) != null;
        }
    public abstract Vector2d lowerLeftCorner();
    public abstract Vector2d upperRightCorner();

    @Override
    public String toString() {
        MapVisualizer map = new MapVisualizer(this);
        return map.draw(lowerLeftCorner(), upperRightCorner());
    }
    public void positionChanged(Vector2d oldPosition, Vector2d newPosition){
        Animal animal = animals.remove(oldPosition);
        if(animal != null) {
            animals.put(newPosition, animal);
        }
    }
}
