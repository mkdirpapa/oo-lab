package agh.ics.oop;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Stream;

import static java.lang.System.out;


public class OptionsParser {
    public static MoveDirection[] parse(String[] directions) {
        return Stream.of(directions)
                .map(getStringMoveDirection()
                )
                .filter(moveDirection -> moveDirection != null)
                .toArray(MoveDirection[]::new);
    }

    private static Function<String, MoveDirection> getStringMoveDirection() {
        return instruction ->
                switch (instruction) {
                    case "f", "forward" -> MoveDirection.FORWARD;
                    case "b", "backward" -> MoveDirection.BACKWARD;
                    case "l", "left" -> MoveDirection.LEFT;
                    case "r", "right" -> MoveDirection.RIGHT;
                    default -> null;
                };
    }
}
