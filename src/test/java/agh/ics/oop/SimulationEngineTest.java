package agh.ics.oop;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class SimulationEngineTest {

    @Test
    void default1() {
        String[] args = {"f", "b", "r", "l", "f", "f", "r", "r", "f", "f", "f", "f", "f", "f", "f", "f"};
        MoveDirection[] directions = new OptionsParser().parse(args);
        IWorldMap map = new RectangularMap(10, 5);
        Vector2d[] positions = {new Vector2d(2, 2), new Vector2d(3, 4)};
        IEngine engine = new SimulationEngine(directions, map, positions);
        engine.run();
        assertTrue(map.isOccupied(new Vector2d(2, 0)));
        assertTrue(map.isOccupied(new Vector2d(3, 5)));
    }

    @Test
    void movingToTheSamePoint(){
        String[] args = {"f", "b"};
        MoveDirection[] directions = new OptionsParser().parse(args);
        IWorldMap map = new RectangularMap(4, 4);
        Vector2d[] positions = {new Vector2d(0,0), new Vector2d(0, 2)};
        IEngine engine = new SimulationEngine(directions, map, positions);
        engine.run();
        assertTrue(map.isOccupied(new Vector2d(0, 1)));
        assertTrue(map.isOccupied(new Vector2d(0, 2)));

    }

    @Test
    void leavingMap(){
        String[] args = {"b", "f", "l", "r", "f", "f"};
        MoveDirection[] directions = new OptionsParser().parse(args);
        IWorldMap map = new RectangularMap(2, 2);
        Vector2d[] positions = {new Vector2d(0,0), new Vector2d(2,2)};
        IEngine engine = new SimulationEngine(directions, map, positions);
        engine.run();
        assertTrue(map.isOccupied(new Vector2d(0, 0)));
        assertTrue(map.isOccupied(new Vector2d(2, 2)));
    }

    @Test
    void placingAtTheSamePoint(){
        String[] args = {"f"};
        MoveDirection[] directions = new OptionsParser().parse(args);
        IWorldMap map = new RectangularMap(2, 2);
        Vector2d[] positions = {new Vector2d(0,0), new Vector2d(0,0)};
        IEngine engine = new SimulationEngine(directions, map, positions);
        engine.run();
        assertEquals(map.getAnimals().toArray().length, 1);

    }
}

