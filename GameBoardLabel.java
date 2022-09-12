package javafxProjectLab;



import javafx.geometry.Insets;
import javafx.scene.control.Label;

public class GameBoardLabel extends Label {

    public static Insets LABEL_PADDING = new Insets(30);

    public GameBoardLabel() {
        // TODO: set Label properties like padding
        //sets the dimensions of the heading labels
        this.setPadding(LABEL_PADDING);
    }
}



