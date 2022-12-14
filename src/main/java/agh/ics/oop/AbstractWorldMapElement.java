package agh.ics.oop;

public abstract class AbstractWorldMapElement {
    protected Vector2d position;
    public Vector2d getPosition(){
        return this.position;
    }
    public abstract String toString();

    public abstract String getImagePath();

}
