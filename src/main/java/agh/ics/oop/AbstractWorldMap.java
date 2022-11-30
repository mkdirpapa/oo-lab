package agh.ics.oop;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public abstract class AbstractWorldMap implements IWorldMap, IPositionChangeObserver{

    private final ArrayList<Animal> animalList = new ArrayList<>();
    protected final Map<Vector2d, Animal> animals = new HashMap<>();

    protected ArrayList<Animal> getAnimals() {
        return animalList;
    }
    public boolean place(Animal animal) {
        if (this.canMoveTo(animal.getPosition())) {
            animalList.add(animal);
            animals.put(animal.getPosition(), animal);
            animal.addObserver(this);
            return true;
        }
        return false;
    }

    public Object objectAt(Vector2d position) {
        return animals.get(position);
    }

    public boolean isOccupied(Vector2d position) {

        return (objectAt(position) != null);
        }
    protected abstract Vector2d lowerLeftCorner();
    protected abstract Vector2d upperRightCorner();

    @Override
    public String toString() {
        MapVisualizer map = new MapVisualizer(this);
        return map.draw(lowerLeftCorner(), upperRightCorner());
    }
    public void positionChanged(Vector2d oldPosition, Vector2d newPosition){
        Animal animal = animals.remove(oldPosition);
        animals.put(newPosition, animal);
    }
}
