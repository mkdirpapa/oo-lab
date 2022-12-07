package agh.ics.oop;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class RectangularMap extends AbstractWorldMap{
    private final int width;
    private final int height;


    public RectangularMap(int width, int height){
        this.width = width;
        this.height = height;

    }
    public boolean canMoveTo(Vector2d position) {
        return (!this.isOccupied(position) && position.follows(new Vector2d(0,0)) &&
                position.precedes(new Vector2d(this.width,this.height)));
    }

    @Override
    protected Vector2d lowerLeftCorner() {
        return new Vector2d(0,0);
    }

    @Override
    protected Vector2d upperRightCorner() {
        return new Vector2d(this.width, this.height);
    }

    @Override
    public void positionChanged(Vector2d oldPosition, Vector2d newPosition) {

    }
}
