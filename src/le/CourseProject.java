package le;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.CornerRadii;
import javafx.scene.layout.FlowPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.layout.Priority;
import javafx.scene.layout.TilePane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.stage.Stage;

/**
 * This is the GUI class of the whole project. It will be called by the launcher
 * class in order to display to the user.
 *
 * @author Phuc Hong Le
 * @version 1 (01/17/2017)
 */
public class CourseProject extends Application {

    //fields
    private Button[] buttons;

    @Override
    public void start(Stage primaryStage) {
        //create some buttons
        buttons = getButtons(15);
        //get image view
        ImageView bonoboView = getBonoboView(buttons[3]);
        //plain pane
        Pane plainPane = new Pane();
        //top pane
        FlowPane topPane = getTopPane();
        //left pane
        VBox leftPane = getLeftPane();
        //bottom pane
        HBox bottomPane = getBottomPane();
        //center pane
        TilePane centerPane = getCenterPane();
        //drawing pane
        Pane drawPane = getDrawPane();
        //main pan
        BorderPane pane = getRootPane(topPane, leftPane,
                centerPane, bottomPane);
        //adding the image of bonobo to the centerPane and set the position
        centerPane.getChildren().add(bonoboView);
        centerPane.setAlignment(Pos.CENTER);

        //set on action for the buttons
        buttons[3].setOnAction(e -> pane.setCenter(centerPane));
        buttons[4].setOnAction(e -> pane.setCenter(drawPane));
        buttons[5].setOnAction(e -> pane.setCenter(plainPane));

        //set up a scene with pane in it
        Scene scene = new Scene(pane);
        scene.setFill(Color.CHARTREUSE); //fill the scene with color

        //set the stage for the sceen
        primaryStage.setScene(scene);
        primaryStage.setTitle("Hello World!");

        //set the location when the program pop up
        primaryStage.setX(0);
        primaryStage.setY(0);

        //set the size of the program
        primaryStage.setWidth(600);
        primaryStage.setHeight(400);
        primaryStage.show();
    }

    //get the image view for the button
    public ImageView getBonoboView(Button btn) {
        Image bonobo = new Image(getClass().getResourceAsStream("/images/bonobo.jpg"));
        ImageView image = new ImageView(bonobo);
        Image monkey = new Image(getClass()
                .getResourceAsStream("/images/monkey_icon.png"));
        ImageView imageIcon = new ImageView(monkey);
        imageIcon.setFitHeight(50);
        imageIcon.setFitWidth(50);
        btn.setGraphic(imageIcon);
        return image;
    }

    public Button[] getButtons(int numOfButton) {
        Button[] buttons = new Button[numOfButton];
        for (int i = 0; i < numOfButton; i++) {
            if (i == 3) {
                buttons[i] = new Button();
            } else {
                buttons[i] = new Button("Button " + i);
            }
        }
        return buttons;
    }

    public FlowPane getTopPane() {
        FlowPane topPane = new FlowPane();
        for (int i = 0; i < 3; i++) {
            topPane.getChildren().add(buttons[i]);
        }
        topPane.setAlignment(Pos.CENTER);
        topPane.setBackground(new Background(
                new BackgroundFill(Color.AQUAMARINE,
                        CornerRadii.EMPTY, Insets.EMPTY)));
        BorderPane.setMargin(topPane, new Insets(10, 10, 10, 10));
        return topPane;
    }

    public VBox getLeftPane() {
        VBox leftPane = new VBox();
        for (int i = 3; i < 6; i++) {
            leftPane.getChildren().add(buttons[i]);
        }
        leftPane.setBackground(new Background(
                new BackgroundFill(Color.DARKORANGE,
                        CornerRadii.EMPTY, Insets.EMPTY)));
        return leftPane;
    }

    public HBox getBottomPane() {
        HBox bottomPane = new HBox();
        for (int i = 6; i < 9; i++) {
            bottomPane.getChildren().add(buttons[i]);
            buttons[i].setMaxWidth(Double.MAX_VALUE);
            HBox.setHgrow(buttons[i], Priority.ALWAYS);
        }
        bottomPane.setAlignment(Pos.CENTER);
        bottomPane.setBackground(new Background(
                new BackgroundFill(Color.MEDIUMPURPLE,
                        CornerRadii.EMPTY, Insets.EMPTY)));
        return bottomPane;
    }

    public TilePane getCenterPane() {
        TilePane centerPane = new TilePane();
        centerPane.setBackground(new Background(
                new BackgroundFill(Color.MEDIUMPURPLE,
                        CornerRadii.EMPTY, Insets.EMPTY)));
        centerPane.setAlignment(Pos.CENTER);
        return centerPane;
    }

    public Pane getDrawPane() {
        Pane drawPane = new Pane();
        Circle pol1 = new Circle(150, 100, 100);
        pol1.setFill(Color.FUCHSIA);
        Circle pol2 = new Circle(400, 100, 100);
        pol2.setFill(Color.BLUE);
        Circle pol3 = new Circle(150, 100, 50);
        pol3.setFill(Color.AQUAMARINE);
        Circle pol4 = new Circle(400, 100, 50);
        pol4.setFill(Color.CHARTREUSE);

        //add the drawing into the drawPane
        drawPane.getChildren().add(pol1);
        drawPane.getChildren().add(pol2);
        drawPane.getChildren().add(pol3);
        drawPane.getChildren().add(pol4);
        return drawPane;
    }

    public BorderPane getRootPane(Pane topPane, Pane leftPane,
            Pane centerPane, Pane bottomPane) {
        BorderPane pane = new BorderPane();
        pane.setTop(topPane);
        pane.setLeft(leftPane);
        pane.setBottom(bottomPane);
        pane.setBackground(new Background(new BackgroundFill(Color.BLUEVIOLET,
                CornerRadii.EMPTY, Insets.EMPTY)));
        return pane;
    }
}
