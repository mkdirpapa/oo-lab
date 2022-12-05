package agh.ics.oop;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class GrassFieldTests {

    @Test
    void IWorldMap() {
        AbstractWorldMap map = new GrassField(0);
        Vector2d position = new Vector2d(2, 2);
        Animal animal1 = new Animal(map, position);
        Animal animal2 = new Animal(map, position);

        assertFalse(map.objectAt(position)  instanceof Grass);


        assertTrue(map.isOccupied(position));
        assertEquals(map.objectAt(position), animal1);
        assertFalse(map.canMoveTo(position));

    }
}