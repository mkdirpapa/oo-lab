package agh.ics.oop;

import java.util.List;
import java.util.Objects;
import java.util.ArrayList;
public abstract class AbstractWorldMap implements IWorldMap{
    protected List<Animal> animals = new ArrayList<>();
    public abstract boolean canMoveTo(Vector2d position);
    public boolean place(Animal animal) {
        if (this.canMoveTo(animal.getPosition())){
            animals.add(animal);
            return true;
        }
        return false;
    }
    public List<Animal> getAnimals() {
        return List.copyOf(animals);
    }
    public Object objectAt(Vector2d position) {
        return animals.stream()
                .filter(animal -> Objects.equals(position, animal.getPosition()))
                .findFirst()
                .orElse(null);
    }
    public boolean isOccupied(Vector2d position){
        return animals.stream()
                .anyMatch(animal -> Objects.equals(position, animal.getPosition()));
    }

    protected abstract Vector2d lowerLeftCorner();
    protected abstract Vector2d upperRightCorner();

    @Override
    public String toString() {
        MapVisualizer map = new MapVisualizer(this);
        return map.draw(lowerLeftCorner(), upperRightCorner());
    }
}
