package le;

import java.util.ArrayList;
import java.util.List;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.geometry.Rectangle2D;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.ScrollPane;
import javafx.scene.control.TextField;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.CornerRadii;
import javafx.scene.layout.FlowPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.layout.TilePane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.stage.Screen;
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
    /**
     * The GUI start up method
     *
     * @param primaryStage the primary stage to load the GUI
     */
    @Override
    public void start(Stage primaryStage) {
        //create buttons for the GUI
        buttons = getButtons(5); //this is going to be called inside the add btn method

        //create pane for the scene
        Pane mainPane = new Pane();

        //set up a scene with pane in it
        Scene scene = new Scene(mainPane);
        //fill the scene with color
        scene.setFill(Color.ALICEBLUE);

        //set the stage for the sceen
        primaryStage.setScene(scene);
        primaryStage.setTitle("Gun Dealer Application");

        //set the location when the program pop up
        Rectangle2D screenBounds = Screen.getPrimary().getVisualBounds();
        primaryStage.setX((screenBounds.getWidth()
                - primaryStage.getWidth()) / 2);
        primaryStage.setY((screenBounds.getHeight()
                - primaryStage.getHeight()) / 2);

        //set the size of the program
        primaryStage.setWidth(1000);
        primaryStage.setHeight(800);
        primaryStage.show();
    }

    //methods for Panes and Buttons
    /**
     * This is the root pane for the whole GUI. It will setup the location of
     * each pane in this project
     *
     * @param topPane the top layout of the project
     * @param leftPane the left layout of the project
     * @param rightPane the right layout of the project
     * @param centerPane the center layout of the project
     * @param bottomPane the bottom layout of the project
     * @return the root pane which includes every single pane in it
     */
    public BorderPane getRootPane(Pane topPane, Pane leftPane, Pane rightPane,
            Pane centerPane, Pane bottomPane) {
        BorderPane pane = new BorderPane();
        pane.setTop(topPane);
        pane.setLeft(leftPane);
        pane.setBottom(bottomPane);
        pane.setRight(rightPane);
        pane.setBackground(new Background(new BackgroundFill(Color.GHOSTWHITE,
                CornerRadii.EMPTY, Insets.EMPTY)));
        return pane;
    }

    /**
     * Setting up the center layout for the GUI
     *
     * @return the center layout
     */
    public TilePane getCenterPane() {
        //setting up the content in the pane
        //label for prompting name
        TextField lblName = new TextField("Name: ");
        lblName.setEditable(false);
        lblName.setMouseTransparent(true);
        lblName.setFocusTraversable(false);
        //label for prompting year
        TextField lblYear = new TextField("Year: ");
        lblYear.setEditable(false);
        lblYear.setMouseTransparent(true);
        lblYear.setFocusTraversable(false);
        //label for prompting cost
        TextField lblCost = new TextField("Cost: ");
        lblCost.setEditable(false);
        lblCost.setMouseTransparent(true);
        lblCost.setFocusTraversable(false);
        //text field for name
        TextField txtName = new TextField();
        txtName.setPromptText("Gun name");
        txtName.setMaxWidth(100);
        //text field for year
        TextField txtYear = new TextField();
        txtName.setPromptText("Year");
        txtName.setMaxWidth(100);
        //text field for cost
        TextField txtCost = new TextField();
        txtName.setPromptText("Cost");
        txtName.setMaxWidth(100);
        //setting up the center pane
        TilePane centerPane = new TilePane();
        centerPane.getChildren().addAll(lblName, txtName, 
                lblYear, txtYear, lblCost, txtCost);
        centerPane.setBackground(new Background(new BackgroundFill(Color.GHOSTWHITE,
                CornerRadii.EMPTY, Insets.EMPTY)));
        centerPane.setAlignment(Pos.CENTER);
        return centerPane;
    }

    /**
     * This is the top pane of the GUI
     *
     * @return the top layout of the project
     */
    public FlowPane getTopPane() {
        //setting the top pane
        FlowPane topPane = new FlowPane();
        topPane.setHgap(20);
        topPane.setVgap(20);
        //setting up the content in the pane
        Button btnSave = new Button("Save");
        Button btnDelete = new Button("Delete");
        btnSave.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                //this is where we code the save button using file handler
                //SOMETHING FOUND ONLINE!!!!
//                FileChooser fileChooser = new FileChooser();
//
//                //Set extension filter
//                FileChooser.ExtensionFilter extFilter = new FileChooser.ExtensionFilter("TXT files (*.txt)", "*.txt");
//                fileChooser.getExtensionFilters().add(extFilter);
//
//                //Show save file dialog
//                File file = fileChooser.showSaveDialog(primaryStage);
//
//                if (file != null) {
//                    SaveFile(Santa_Claus_Is_Coming_To_Town, file);
//                }
            }
        });
        btnDelete.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                //this is where we code the delete button using file handler   
            }
        });
        topPane.getChildren().addAll(btnSave, btnDelete);
        return topPane;
    }

    /**
     * This is the bottom pane of the GUI
     *
     * @return the bottom layout of the project
     */
    public FlowPane getBottomPane() {
        //setting up the sort list
        ComboBox<String> sortingDropList = new ComboBox<>();
        sortingDropList.getItems().addAll(
                "Sort by gun name", "Sort by year", "Sort by cost");
        sortingDropList.setEditable(false);
        sortingDropList.setPromptText("Select a sort method");
        //the sorting is not yet implemented!!!!

        //setting up the content in the pane
        Button btnAdd = new Button("Add new info");
        Button btnGraph = new Button("Graph");
        //text field for name
        TextField txtName = new TextField();
        txtName.setPromptText("Gun name");
        txtName.setMaxWidth(100);
        //text field for year
        TextField txtYear = new TextField();
        txtName.setPromptText("Year");
        txtName.setMaxWidth(100);
        //text field for cost
        TextField txtCost = new TextField();
        txtName.setPromptText("Cost");
        txtName.setMaxWidth(100);

        btnAdd.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                //this is where we code the save button using file handler
            }
        });
        btnGraph.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                //createGraph() this method need to be written first!!!
            }
        });
        //setting up the bottom layout
        FlowPane bottomPane = new FlowPane();
        bottomPane.getChildren().addAll(sortingDropList, txtName, txtYear,
                txtCost, btnAdd, btnGraph);
        bottomPane.setAlignment(Pos.CENTER);
        bottomPane.setHgap(10);
        return bottomPane;
    }

    /**
     * This is the left pane of the GUI
     *
     * @return the left layout of the project
     */
    public ScrollPane getLeftPane() {
        ScrollPane leftPane = new ScrollPane();
        //create a VBox
        VBox pane = new VBox();
        pane.setPadding(new Insets(10, 10, 10, 10));
        List<Button> guns = new ArrayList<>();
        //half way on the button :)
//        for (int i = 0; i < gunStorage.getSize(); i++) {
//            guns.add(new Button(gunStorage.getName() + 
//                    " (" + gunStorage.getYear() + "): $" 
//                    + gunStorage.getCost()));
//            guns.get(i).setOnAction(e ->{})
//        }
        pane.getChildren().addAll(guns);
        leftPane.setContent(pane);
        leftPane.setBackground(new Background(new BackgroundFill(Color.GAINSBORO,
                CornerRadii.EMPTY, Insets.EMPTY)));
        return leftPane;
    }

    /**
     * This is the right layout of the GUI This only pop-up when the information
     * from button is being populated
     *
     * @return the right layout of the GUI
     */
    public VBox getRightPane() {
        VBox rightPane = new VBox();
        //setting up the content in the pane
        Button btnUpdate = new Button("Update gun info");
        Button btnRemove = new Button("Remove profile");
        btnUpdate.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                //this is where we code the save button using file handler
            }
        });
        btnRemove.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                //this is where we code the delete button using file handler   
            }
        });
        rightPane.getChildren().addAll(btnUpdate, btnRemove);
        return rightPane;
    }

    /**
     * Setting up an array of button. This number will grow according to user's
     * data
     *
     * @param numOfButton the number of button to be made
     * @return the array of buttons
     */
    public Button[] getButtons(int numOfButton) {
        Button[] buttons = new Button[numOfButton];
        for (int i = 0; i < numOfButton; i++) {
            buttons[i] = new Button("Button " + i);
        }
        return buttons;
    }

}
