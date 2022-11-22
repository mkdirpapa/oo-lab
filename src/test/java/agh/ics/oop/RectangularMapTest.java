package agh.ics.oop;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class RectangularMapTest {
    @Test
    void IWorldMap() {
        IWorldMap map = new RectangularMap(4,4);
        Vector2d position1 = new Vector2d(2, 2);
        Vector2d position2 = new Vector2d(5,5);
        Animal animal1 = new Animal(map, position1);
        Animal animal2 = new Animal(map, position1);
        Animal animal3 = new Animal(map, position2);

        assertFalse(map.objectAt(position1)  instanceof Grass);
        assertTrue(map.place(animal1));
        assertFalse(map.place(animal2));
        assertFalse(map.place(animal3));

        assertEquals(map.objectAt(position1), animal1);
        assertTrue(map.isOccupied(position1));
        assertFalse(map.canMoveTo(position1));
        assertFalse(map.canMoveTo(position2));

    }
}

