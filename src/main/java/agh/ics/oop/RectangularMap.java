package agh.ics.oop;

import java.util.ArrayList;


public class RectangularMap implements IWorldMap{
    private int width;
    private int height;
    public ArrayList <Animal> animals;
    private MapVisualizer mapVisualizer;

    public RectangularMap(int width, int height){
        this.width = width;
        this.height = height;
        this.animals = new ArrayList<>();
        this.mapVisualizer = new MapVisualizer(this);


    }

    public boolean isOccupied(Vector2d position){
        for (Animal object : animals){
            if (object.isAt(position)){ return true; }
        }
        return false;
    }


    public Object objectAt(Vector2d position) {
        for (Animal object : animals){
            if(object.getPosition().equals(position)){
                return object;
            }
        }
        return null;
    }

    public boolean canMoveTo(Vector2d position) {

        return (!this.isOccupied(position) && position.follows(new Vector2d(0,0)) &&
                position.precedes(new Vector2d(this.width,this.height)));
    }

    public boolean place(Animal animal) {
        if (this.canMoveTo(animal.getPosition())){
            animals.add(animal);
            return true;
        }
        return false;
    }

    public String toString() {
        return mapVisualizer.draw(new Vector2d(0,0), new Vector2d(this.width, this.height));
    }

    public ArrayList<Animal> getAnimals(){
        return this.animals;
    }
}
