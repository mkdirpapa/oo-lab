package agh.ics.oop.gui;

import agh.ics.oop.*;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;
import javafx.scene.layout.ColumnConstraints;
import javafx.scene.layout.RowConstraints;
import javafx.geometry.HPos;

public class App extends Application {
    private AbstractWorldMap map;
    private int windowHeight = 400;
    private int windowWidth = 400;
    private String title = "Aplikacja";

    public void init(){
        String[] args = getParameters().getRaw().toArray(new String[0]);
        this.map = new GrassField(10);
        Vector2d[] positions = {new Vector2d(2, 2), new Vector2d(3, 4)};

        try {
            MoveDirection[] directions = new OptionsParser().parse(args);
            IEngine engine = new SimulationEngine(directions, map, positions);
            engine.run();
        }
        catch (IllegalArgumentException exception){
            System.out.println(exception);
            System.exit(0);
        }

    }


    public void start(Stage primaryStage){
        int minX = map.lowerLeftCorner().x;
        int maxX = map.upperRightCorner().x;
        int minY = map.lowerLeftCorner().y;
        int maxY = map.upperRightCorner().y;

        int width = windowWidth / (maxX - minX+2) ;
        int height = windowHeight / (maxY - minY+2);

        GridPane grid = new GridPane();

        grid.setGridLinesVisible(true);
        grid.setMinWidth(width);
        grid.setMinHeight(height);
        grid.getColumnConstraints().add(new ColumnConstraints(width));
        Label startLabel = new Label("y\\x");
        grid.getRowConstraints().add(new RowConstraints(height));
        GridPane.setHalignment(startLabel, HPos.CENTER);
        grid.add(startLabel, 0, 0);


        for (int i = 1; i <= maxX - minX + 1; i++){
            Label label = new Label(Integer.toString(minX + i -1));
            grid.getColumnConstraints().add(new ColumnConstraints(width));
            grid.add(label, i, 0);
            GridPane.setHalignment(label, HPos.CENTER);

        }
        for (int i =1 ; i <=  maxY - minY + 1; i++){
            Label label = new Label(Integer.toString(maxY - i + 1));
            grid.getRowConstraints().add(new RowConstraints(height));
            grid.add(label, 0,i);
            GridPane.setHalignment(label, HPos.CENTER);

        }
        for (int x = minX; x <= maxX; x++){
            for (int y = minY; y <= maxY; y++){
                Vector2d position = new Vector2d(x, y);
                if (map.isOccupied( position )){
                    Label label = new Label(map.objectAt(position).toString());
                    int xOnMap = x - minX + 1;
                    int yOnMap = maxY - y + 1;

                    grid.add(label, xOnMap, yOnMap);
                    GridPane.setHalignment(label, HPos.CENTER);
                }
            }
        }

        Scene scene = new Scene(grid, windowWidth, windowHeight);
        primaryStage.setTitle(title);
        primaryStage.setScene(scene);
        primaryStage.show();
    }
}
