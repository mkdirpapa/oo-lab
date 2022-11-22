package agh.ics.oop;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import static java.lang.Math.sqrt;
import static java.lang.Math.random;

public class GrassField extends AbstractWorldMap{
    private List<Grass> grasses = new ArrayList<>();
    public GrassField(int grassAmount ){
        for(int i = 0; i<grassAmount; i++) {

            int x = (int) (random() * sqrt(grassAmount * 10));
            int y = (int) (random() * sqrt(grassAmount * 10));
            Vector2d field = new Vector2d(x, y);

            if(!isOccupied(field)) {
                addGrass(field);
            }
            else{ i-=1; }
        }

    }
    public void addGrass(Vector2d position){
        grasses.add(new Grass(position));
    }
    @Override
    public boolean canMoveTo(Vector2d position) {
        return !(this.objectAt(position) instanceof Animal);
    }

    @Override
    public boolean isOccupied(Vector2d position) {
        return objectAt(position) != null;
    }

    @Override
    protected Vector2d lowerLeftCorner() {
        Vector2d corner = new Vector2d(0, 0);

        for(Grass grass : grasses){
            corner = corner.lowerLeft(grass.getPosition());
        }
        for(Animal animal : animals){
            corner = corner.lowerLeft(animal.getPosition());
        }
        return corner;
    }

    @Override
    protected Vector2d upperRightCorner() {
        Vector2d corner = new Vector2d(0, 0);

        for(Grass grass : grasses){
            corner = corner.upperRight(grass.getPosition());
        }
        for(Animal animal : animals){
            corner = corner.upperRight(animal.getPosition());
        }
        return corner;
    }
    public Object objectAt(Vector2d position) {
        for(Animal animal : animals){
            if(animal.getPosition().equals(position)){
                return animal;
            }
        }
        for(Grass grass : grasses){
            if(grass.getPosition().equals(position)){
                return grass;
            }
        }
        return null;
    }
}
