package agh.ics.oop;
import static java.lang.System.out;


public class OptionsParser {
    public static MoveDirection[] parse(String[] directions) {
        int l1 = directions.length;
        int l2 = 0;

        for (int i=0; i<l1; i++) {
            if(directions[i].equals("f") || directions[i].equals("b") || directions[i].equals("l") || directions[i].equals("r")){
                l2+=1;
            }
        }

        MoveDirection[] directions_tab = new MoveDirection[l2];

        for (int i=0; i<l2; i++) {
            switch (directions[i]) {
                case "f" -> directions_tab[i] = MoveDirection.FORWARD;
                case "b" -> directions_tab[i] = MoveDirection.BACKWARD;
                case "l" -> directions_tab[i] = MoveDirection.LEFT;
                case "r" -> directions_tab[i] = MoveDirection.RIGHT;
            }
        }
        return directions_tab;
    }
}
