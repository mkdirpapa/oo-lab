package agh.ics.oop;
import static java.lang.System.out;


public class World {

    public static MoveDirection[] enumTab(String[] directions) {
        int l = directions.length;
        MoveDirection[] dir = new MoveDirection[l];

        for (int i=0; i<l; i++) {
            switch (directions[i]) {
                case "f" -> dir[i] = MoveDirection.FORWARD;
                case "b" -> dir[i] = MoveDirection.BACKWARD;
                case "l" -> dir[i] = MoveDirection.LEFT;
                case "r" -> dir[i] = MoveDirection.RIGHT;
            }
        }
        return dir;
    }

    public static void run(MoveDirection[] dir) {
        int l = dir.length;
        int i = 0;
        for (MoveDirection arg : dir) {
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

        MoveDirection[] dir = enumTab(directions);
        run(dir);

        System.out.print("\nStop");

    }

}
