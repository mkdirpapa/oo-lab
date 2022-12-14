package agh.ics.oop;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Stream;

import static java.lang.System.out;


public class OptionsParser {
    public static MoveDirection[] parse(String[] directions) throws IllegalArgumentException{
        return Stream.of(directions)
                .map(getStringMoveDirection()
                )
                .filter(moveDirection -> moveDirection != null)
                .toArray(MoveDirection[]::new);
    }

    private static Function<String, MoveDirection> getStringMoveDirection() throws IllegalArgumentException{
        return instruction ->
                switch (instruction) {
                    case "f", "forward" -> MoveDirection.FORWARD;
                    case "b", "backward" -> MoveDirection.BACKWARD;
                    case "l", "left" -> MoveDirection.LEFT;
                    case "r", "right" -> MoveDirection.RIGHT;
                    default -> throw new IllegalArgumentException(instruction + " is not a valid argument!");
                };
    }
}
