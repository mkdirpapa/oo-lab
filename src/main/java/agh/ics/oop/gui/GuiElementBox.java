
package agh.ics.oop.gui;

import agh.ics.oop.Animal;
import agh.ics.oop.Grass;
import agh.ics.oop.AbstractWorldMapElement;
import javafx.geometry.Pos;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.VBox;
import java.io.FileInputStream;
import java.io.FileNotFoundException;

public class GuiElementBox {
    private ImageView image;
    private VBox vBox = new VBox();

    public GuiElementBox(AbstractWorldMapElement element, int size){
        try{
            Image image = new Image(new FileInputStream(element.getImagePath()));
            this.image = new ImageView(image);
            this.image.setFitWidth(size);
            this.image.setFitHeight(size);

            Label position = new Label(element.getPosition().toString());
            this.vBox = new VBox(this.image, position);
            this.vBox.setAlignment(Pos.CENTER);
        }
        catch (FileNotFoundException e){
            throw new RuntimeException("File not found.");
        }
    }
    public VBox getVBox(){
        return this.vBox;
    }

}
