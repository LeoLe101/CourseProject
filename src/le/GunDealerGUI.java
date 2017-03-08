package le;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.FlowPane;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

/**
 * This GUI class is the user interface for the whole course project
 * 
 * @author Phuc Hong Le
 * @version 1 (3/7/2017)
 */
public class GunDealerGUI extends Application {
    
    //fields
    private Button[] buttons;

    //GUI declaration method
    @Override
    public void start(Stage primaryStage) {
        //create buttons for the GUI
        buttons = getButtons(5);

        //create pane for the scene
        Pane mainPane = new Pane();

        //set up a scene with pane in it
        Scene scene = new Scene(mainPane);
        scene.setFill(Color.CHARTREUSE); //fill the scene with color

        //set the stage for the sceen
        primaryStage.setScene(scene);
        primaryStage.setTitle("Hello World!");

        //set the location when the program pop up
        primaryStage.setX(0);
        primaryStage.setY(0);

        //set the size of the program
        primaryStage.setWidth(600);
        primaryStage.setHeight(600);
        primaryStage.show();
    }

    public BorderPane getRootPane(Pane topPane, Pane leftPane, Pane rightPane,
            Pane centerPane, Pane bottomPane) {
        BorderPane pane = new BorderPane();

        return pane;
    }

    public FlowPane getTopPane(){
        FlowPane topPane = new FlowPane();
        
        return topPane;
    }
    
    public Scroll
    
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
    
    

}
