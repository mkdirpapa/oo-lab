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
        assertEquals("(2, 2)WEST", floppa.toString());

        floppa.move(MoveDirection.RIGHT);
        assertEquals("(2, 2)NORTH", floppa.toString());

        //ruch
        floppa.move(MoveDirection.FORWARD);
        assertEquals("(2, 3)NORTH", floppa.toString());
        floppa.move(MoveDirection.RIGHT);
        floppa.move(MoveDirection.BACKWARD);
        assertEquals("(1, 3)EAST", floppa.toString());

        //wyjscie poza mape
        floppa.move(MoveDirection.BACKWARD);
        floppa.move(MoveDirection.BACKWARD);
        assertEquals("(0, 3)EAST", floppa.toString());
    }

    @Test
    void parse_test(){
        String[] directions1 = new String[]{"f", "f", "b", "r", "l", "rr", "ucx", "u"};
        MoveDirection[] directions2 = new MoveDirection[] {MoveDirection.FORWARD, MoveDirection.FORWARD, MoveDirection.BACKWARD, MoveDirection.RIGHT, MoveDirection.LEFT};
        assertTrue(Arrays.deepEquals(directions2, OptionsParser.parse(directions1)));

    }

}
