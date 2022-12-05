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
                mapBoundary.addPosition(field);
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
    public Vector2d lowerLeftCorner() {
        return this.mapBoundary.getLowerLeft();
    }

    @Override
    public Vector2d upperRightCorner() {
        return this.mapBoundary.getUpperRight();
    }
    public Object objectAt(Vector2d position) {
        Object foundObject = super.objectAt(position);
        if (foundObject  == null) {
            return grasses.get(position);
        }
        return  foundObject ;
    }
}
