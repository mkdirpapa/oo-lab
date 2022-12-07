package agh.ics.oop;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import static java.lang.Math.sqrt;
import static java.lang.Math.random;
import java.util.HashMap;

public class GrassField extends AbstractWorldMap{
    protected HashMap<Vector2d,Grass> grasses = new HashMap<>();
    public GrassField(int grassAmount ){
        for(int i = 0; i<grassAmount; i++) {

            int x = (int) (random() * sqrt(grassAmount * 10));
            int y = (int) (random() * sqrt(grassAmount * 10));
            Vector2d field = new Vector2d(x, y);

            if(!isOccupied(field)) {
                grasses.put(new Vector2d(x, y),new Grass(field));
            }
            else{ i-=1; }
        }

    }
    @Override
    public boolean canMoveTo(Vector2d position) {
        return !animals.containsKey(position);
    }

    @Override
    public boolean isOccupied(Vector2d position) {
        return (this.grasses.containsKey(position) || super.isOccupied(position));
    }

    @Override
    protected Vector2d lowerLeftCorner() {
        Vector2d corner = new Vector2d(Integer.MAX_VALUE, Integer.MAX_VALUE);

        for(Vector2d position: grasses.keySet()){
            corner = corner.lowerLeft(position);
        }
        for(Vector2d position: animals.keySet()){
            corner = corner.lowerLeft(position);
        }
        return corner;
    }

    @Override
    protected Vector2d upperRightCorner() {
        Vector2d corner = new Vector2d(Integer.MIN_VALUE, Integer.MIN_VALUE);;

        for(Vector2d position : grasses.keySet()){
            corner = corner.upperRight(position);
        }
        for(Vector2d position : animals.keySet()){
            corner = corner.upperRight(position);
        }
        return corner;
    }
    public Object objectAt(Vector2d position) {
        if (super.objectAt(position) == null) {
            return grasses.get(position);
        }
        return  super.objectAt(position);
    }

    @Override
    public void positionChanged(Vector2d oldPosition, Vector2d newPosition) {

    }
}
