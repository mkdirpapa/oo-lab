package agh.ics.oop;
import java.util.ArrayList;
import java.util.List;
import static java.lang.System.out;
import  java.lang.Thread;
import agh.ics.oop.gui.App;
public class SimulationEngine implements IEngine, Runnable{
    private MoveDirection[] directions;
    private AbstractWorldMap map;
    private final ArrayList<Animal> allAnimals = new ArrayList<>();
    private int moveDelay = 0;

    private App app;
    public SimulationEngine(MoveDirection[] directions, AbstractWorldMap map, Vector2d[] positions){
        this.directions = directions;
        this.map = map;

        for (Vector2d position : positions){
            Animal animal = new Animal(this.map, position);
            if(this.map.canMoveTo(position)){
                this.map.place(animal);
                this.allAnimals.add(animal);
                animal.addObserver(
                        (oldPosition, newPosition) -> System.out.print(oldPosition + " " + newPosition));
            }
        }

    }
    public SimulationEngine(MoveDirection[] directions, AbstractWorldMap map, Vector2d[] positions, App app){
        this.directions = directions;
        this.map = map;
        this.app = app;
        for (Vector2d position : positions){
            Animal animal = new Animal(this.map, position);
            if(this.map.canMoveTo(position)){
                this.map.place(animal);
                this.allAnimals.add(animal);
                //animal.addObserver(
                //        (oldPosition, newPosition) -> this.map.mapBoundaryUpdate(animal));
            }
        }

    }
    public void run() {
        int numberOfAnimals = this.allAnimals.size();
        int i = 0;

        for (MoveDirection direction : directions) {
            try {
                Thread.sleep(moveDelay);
                Animal animal = this.allAnimals.get(i % numberOfAnimals);
                animal.move(direction);
                map.mapBoundaryUpdate(animal);
                i += 1;
                app.refresh();
            }
             catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
        //out.print(map.toString());
    }

    public void setMoveDelay(int delay){
        this.moveDelay = delay;
    }
}
