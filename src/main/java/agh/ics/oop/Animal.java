package agh.ics.oop;

public class Animal {
    private MapDirection orientation = MapDirection.NORTH;
    private Vector2d position = new Vector2d(2,2);

    public String toString() {
        return this.position.toString() + this.orientation.toString();
    }
    public boolean isAt(Vector2d position){
        return this.position.equals(position);
    }

    public void move(MoveDirection direction){

        switch (direction) {
            case RIGHT:
                orientation = orientation.next();
                break;
            case LEFT:
                orientation = orientation.previous();
                break;
            case FORWARD:
                Vector2d pos_for = position.add(orientation.toUnitVector());
                if(pos_for.precedes(new Vector2d(4,4)) && pos_for.follows(new Vector2d(0,0))){
                    position = pos_for;
                }
                break;
            case BACKWARD:
                Vector2d pos_back = position.subtract(orientation.toUnitVector());
                if(pos_back.precedes(new Vector2d(4,4)) && pos_back.follows(new Vector2d(0,0))){
                    position = pos_back;
                }
                break;
        }
    }

    //Aby uniknac zderzania się zwierząt, informację o tym, czy pole jest zajmowane, czy nie, można przechowywać
    // w tablicy, w nowym polu w klasie World, którą przekazujemy i modyfikujemy podczas ruchu zwierzecia

}
