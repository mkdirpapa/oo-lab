package agh.ics.oop;
import java.util.ArrayList;
import static java.lang.System.out;
public class SimulationEngine implements IEngine{
    private MoveDirection[] directions;
    private IWorldMap map;
    private ArrayList<Animal> allAnimals;
    public SimulationEngine(MoveDirection[] directions, IWorldMap map, Vector2d[] positions){
        this.directions = directions;
        this.map = map;

        for (Vector2d position : positions){
            Animal animal = new Animal(this.map, position);
            map.place(animal);
        }
        this.allAnimals = map.getAnimals();
    }
    public void run() {
        int numberOfAnimals = this.allAnimals.toArray().length;
        int i = 0;
        for (MoveDirection direction : directions) {
            Animal animal = this.allAnimals.get(i);
            animal.move(direction);
            i+=1;
            if (i == numberOfAnimals) {i = 0;}
        }
        out.print(map.toString());
    }
}
