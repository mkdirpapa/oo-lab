
import agh.ics.oop.Vector2d;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;


public class Vector2dTest {

    @Test
    void equals_test(){
        Vector2d v1 = new Vector2d(1,2);
        Vector2d v2 = new Vector2d(1,2);
        int v3 = 10;
        Vector2d v4 = new Vector2d(2,1);
        assertEquals(v1, v2);
        assertNotEquals(v1, v3);
        assertNotEquals(v1, v4);


    }

    @Test
    void toString_test(){
        Vector2d v1 = new Vector2d(0,1);
        assertEquals("(0, 1)",v1.toString());

    }

    @Test
    void precedes_test(){
        Vector2d v1 = new Vector2d(0,1);
        Vector2d v2 = new Vector2d(1,0);
        Vector2d v3 = new Vector2d(-1,-1);

        assertFalse(v2.precedes(v1));
        assertTrue(v3.precedes(v1));

    }

    @Test
    void follows_test(){
        Vector2d v1 = new Vector2d(0,1);
        Vector2d v2 = new Vector2d(1,0);
        Vector2d v3 = new Vector2d(1,1);

        assertFalse(v1.follows(v2));
        assertTrue(v3.follows(v1));

    }

    @Test
    void upperRight_test(){
        Vector2d v1 = new Vector2d(1,2);
        Vector2d v2 = new Vector2d(2,1);
        Vector2d v3 = v1.upperRight(v2);

        assertEquals(2,v3.x);
        assertEquals(2,v3.y);
    }

    @Test
    void lowerLeft_test(){
        Vector2d v1 = new Vector2d(1,2);
        Vector2d v2 = new Vector2d(2,1);
        Vector2d v3 = v1.lowerLeft(v2);

        assertEquals(1,v3.x);
        assertEquals(1,v3.y);
    }

    @Test
    void add_test(){
        Vector2d v1 = new Vector2d(1,2);
        Vector2d v2 = new Vector2d(2,-1);
        Vector2d v3 = v1.add(v2);

        assertEquals(3,v3.x);
        assertEquals(1,v3.y);
    }

    @Test
    void subtract_test(){
        Vector2d v1 = new Vector2d(1,2);
        Vector2d v2 = new Vector2d(2,-1);
        Vector2d v3 = v1.subtract(v2);

        assertEquals(-1,v3.x);
        assertEquals(3,v3.y);
    }

    @Test
    void opposite_test(){
        Vector2d v1 = new Vector2d(1,2);
        Vector2d v2 = v1.opposite();

        assertEquals(-1,v2.x);
        assertEquals(-2,v2.y);
    }

}
