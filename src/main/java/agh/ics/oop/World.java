package agh.ics.oop;
import static java.lang.System.out;


public class World {
    public static void run(MoveDirection[] dir, Animal animal) {
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
            animal.move(arg);
            if (i != l - 1) {
                System.out.print(", \n");
            }
            i = i + 1;
        }
    }
    public static void main(String[] directions) {
        out.print("Start \n");

        MoveDirection[] dir = OptionsParser.parse(directions);

        Animal doggo = new Animal();
        out.print(doggo.toString());
        out.print("\n");

        run(dir, doggo);
        out.print("\n");

        out.print(doggo.toString());

        out.print("\nStop");

    }

}
