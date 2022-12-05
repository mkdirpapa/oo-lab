package agh.ics.oop;
import static java.lang.System.out;
import agh.ics.oop.gui.App;
import javafx.application.Application;

public class World {
    public static final Vector2d LOWER_BOUND = new Vector2d(0, 0);
    public static final Vector2d UPPER_BOUND = new Vector2d(4, 4);

    public static void main(String[] args) {
        Application.launch(App.class, args);
    }

}
