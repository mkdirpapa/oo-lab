package agh.ics.oop;
import static java.lang.System.out;


public class World {

    public static Direction[] enumTab(String[] directions) {
        int l = directions.length;
        Direction[] dir = new Direction[l];

        for (int i=0; i<l; i++) {
            switch (directions[i]) {
                case "f" -> dir[i] = Direction.FORWARD;
                case "b" -> dir[i] = Direction.BACKWARD;
                case "l" -> dir[i] = Direction.LEFT;
                case "r" -> dir[i] = Direction.RIGHT;
            }
        }
        return dir;
    }

    public static void run(Direction[] dir) {
        int l = dir.length;
        int i = 0;
        for (Direction arg : dir) {
            System.out.print("Zwierzak ");
            switch (arg) {
                case FORWARD -> out.print("idzie do przodu");
                case BACKWARD -> out.print("idzie do tyłu");
                case LEFT -> out.print("skręca w lewo");
                case RIGHT-> out.print("skręca w prawo");

            }
            if (i != l - 1) {
                System.out.print(", \n");
            }
            i = i + 1;
        }
    }
    public static void main(String[] directions) {
        System.out.print("Start \n");

        Direction[] dir = enumTab(directions);
        run(dir);

        System.out.print("\nStop");

    }

}
