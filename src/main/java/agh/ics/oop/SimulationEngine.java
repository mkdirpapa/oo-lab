package agh.ics.oop;
import java.util.ArrayList;
import java.util.List;
import static java.lang.System.out;
public class SimulationEngine implements IEngine{
    private MoveDirection[] directions;
    private AbstractWorldMap map;
    private final ArrayList<Animal> allAnimals = new ArrayList<>();

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
    public void run() {
        int numberOfAnimals = this.allAnimals.size();
        int i = 0;
        for (MoveDirection direction : directions) {
            Animal animal = this.allAnimals.get(i%numberOfAnimals);
            animal.move(direction);
            i+=1;
        }
        out.print(map.toString());
    }
}
