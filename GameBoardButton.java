package javafxProjectLab;


import javafx.scene.control.Button;

public class GameBoardButton extends Button {
    private int row;
    private int col;
    private boolean hasFish;
    private boolean isGuessed;


    public GameBoardButton(int row, int col, boolean hasFish)
    {

        this.row = row;
        this.col = col;
        this.hasFish = hasFish;

        // TODO: set min/pref width, default text
        setText("?");
        setPrefSize(80,30);
    }

    public void handleClick() {
        // TODO: update text
        if(hasFish) {
            setText("<><");
            //setStyle("-fx-background-color: green");
        }
        else {
            setText("X");
            //setStyle("-fx-background-color: red");
        }
        isGuessed = true;
        setDisabled(true);
    }
}



