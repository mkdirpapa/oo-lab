
package agh.ics.oop;


import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.*;

public class AnimalTest {
    @Test
    void move_test(){
        Animal floppa = new Animal();
        //orientacja
        floppa.move(MoveDirection.LEFT);
        assertEquals("<", floppa.toString());

        floppa.move(MoveDirection.RIGHT);
        assertEquals("^", floppa.toString());

        //ruch
        floppa.move(MoveDirection.FORWARD);
        assertEquals(new Vector2d(2,3), floppa.getPosition());
        floppa.move(MoveDirection.RIGHT);
        floppa.move(MoveDirection.BACKWARD);
        assertEquals(new Vector2d(1,3), floppa.getPosition());

    }

    @Test
    void parse_test(){
        String[] directions1 = new String[]{"f", "f", "b", "r", "l", "rr", "ucx", "u"};
        MoveDirection[] directions2 = new MoveDirection[] {MoveDirection.FORWARD, MoveDirection.FORWARD, MoveDirection.BACKWARD, MoveDirection.RIGHT, MoveDirection.LEFT};
        assertTrue(Arrays.deepEquals(directions2, OptionsParser.parse(directions1)));

    }

}

