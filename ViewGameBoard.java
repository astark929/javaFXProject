package javafxProjectLab;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

public class ViewGameBoard extends Application {

    private Canvas gameCanvas;
    private ControllerGameBoard controller;
    private GameBoardLabel fishRemaining;
    private GameBoardLabel guessesRemaining;
    private GameBoardLabel message;

    public static void main(String[] args)
    {
        // TODO: launch the app
        launch(args);
    }

    public void updateHeader() {
        //TODO update labels

        fishRemaining.setText("Fish: " + controller.modelGameBoard.getFishRemaining());
        guessesRemaining.setText("Bait: " + controller.modelGameBoard.getGuessesRemaining());
        if(controller.fishWin()) {
            message.setText("Fishes Win!");
        }
        else if(controller.playerWins()) {
            message.setText("You win!");
        }
        else {
            message.setText("Find the fish!");
        }
    }
    @Override
    public void start(Stage stage) throws Exception {
        try {

            // TODO initialize gameCanvas

            controller = new ControllerGameBoard();
            fishRemaining = new GameBoardLabel();
            guessesRemaining = new GameBoardLabel();
            message = new GameBoardLabel();
            gameCanvas = new Canvas();

            // TODO display game there are infinite ways to do this, I used BorderPane with HBox and VBox.
            HBox labelInformation = new HBox(fishRemaining, guessesRemaining, message);

            VBox clickingBoxes = new VBox(labelInformation);
            clickingBoxes.setSpacing(10);

            updateHeader();

            for (int row = 0; row < ModelGameBoard.DIMENSION; row++) {
                // TODO: create row container
                HBox rowContainer = new HBox();
                rowContainer.setSpacing(12);

                for (int col = 0; col < ModelGameBoard.DIMENSION; col++) {

                    GameBoardButton button = new GameBoardButton(row, col, controller.modelGameBoard.fishAt(row, col));
                    int finalRow = row;
                    int finalCol = col;

                    button.setOnAction(e -> {
                        controller.makeGuess(finalRow, finalCol);

                        if (!controller.isGameOver()) {
                            button.handleClick();
                            updateHeader();
                        }
                    });

                    // TODO: add button to row
                    rowContainer.getChildren().add(button);

                }
                // TODO: add row to column
                clickingBoxes.getChildren().add(rowContainer);
            }

            Scene scene = new Scene(clickingBoxes);

            stage.setScene(scene);
            stage.setTitle("Gone Fishing");
            stage.show();
            // TODO: create scene, stage, set title, and show
        }
        catch (Exception e){
            e.printStackTrace();
        }
    }
}

