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
import javafx.scene.layout.VBox;
import javafx.application.Platform;
import javafx.scene.control.TextField;
import javafx.scene.control.Button;

public class App extends Application {
    private AbstractWorldMap map = new GrassField(10);
    private SimulationEngine engine;
    private int windowHeight = 700;
    private int windowWidth = 700;
    private GridPane grid = new GridPane();
    private String title = "Fire walk with me";
    private int moveDelay  = 300;
/*
    public void init(){
        String[] args = getParameters().getRaw().toArray(new String[0]);
        this.map = new GrassField(10);
        Vector2d[] positions = {new Vector2d(2, 2), new Vector2d(3, 4)};

        try {
            MoveDirection[] directions = new OptionsParser().parse(args);
            this.engine = new SimulationEngine(directions, map, positions, this);
            engine.setMoveDelay(this.moveDelay);
        }
        catch (IllegalArgumentException exception){
            System.out.println(exception);
            System.exit(0);
        }
    }
    */

    public void start(Stage primary_stage) {
        TextField textField = new TextField();

        newGrid();
        VBox vBox = new VBox(
                grid,
                textField,
                startButton(textField));

        Scene scene = new Scene(vBox, windowWidth, windowHeight + 63);
        primary_stage.setTitle(title);
        primary_stage.setScene(scene);
        primary_stage.show();
    }

    public Button startButton(TextField textField) {
        Button startButton = new Button("Let's rock");
        startButton.setOnAction((action) -> {
            String text = textField.getText();

            Vector2d[] positions = {new Vector2d(2, 2)};
            try {
                MoveDirection[] directions = OptionsParser.parse(text.split(" "));
                this.engine = new SimulationEngine(directions, map, positions, this);
                engine.setMoveDelay(this.moveDelay);
                Thread thread = new Thread(engine);
                thread.start();
            }
            catch (IllegalArgumentException exception){
                System.out.println(exception);
                System.exit(0);
            }
        });
        return startButton;
    }

    public void newGrid(){
        int minX = map.lowerLeftCorner().x;
        int maxX = map.upperRightCorner().x;
        int minY = map.lowerLeftCorner().y;
        int maxY = map.upperRightCorner().y;

        int width = windowWidth / (maxX - minX+2) ;
        int height = windowHeight / (maxY - minY+2);

        int objectSize = Math.min(width-6, height-6);

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
                    AbstractWorldMapElement object = (AbstractWorldMapElement) map.objectAt(position);
                    VBox box = new GuiElementBox(object, objectSize).getVBox();
                    int xOnMap = x - minX + 1;
                    int yOnMap = maxY - y + 1;

                    grid.add(box, xOnMap, yOnMap);
                    GridPane.setHalignment(box, HPos.CENTER);
                }
            }
        }
    }
    public void refresh() {
        Platform.runLater( () -> {
            this.grid.getChildren().clear();
            this.grid.getColumnConstraints().clear();
            this.grid.getRowConstraints().clear();
            grid.setGridLinesVisible(false);
            this.newGrid();
        });
    }
}
