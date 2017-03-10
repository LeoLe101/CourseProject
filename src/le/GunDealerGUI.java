package le;

import java.util.ArrayList;
import java.util.List;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.HPos;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.geometry.Rectangle2D;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.ScrollPane;
import javafx.scene.control.TextField;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.CornerRadii;
import javafx.scene.layout.FlowPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.stage.Screen;
import javafx.stage.Stage;
import numberlist.InvalidIndexException;
import numberlist.primitivelist.IntegerArrayList;

/**
 * This GUI class is the user interface for the whole course project
 *
 * @author Phuc Hong Le
 * @version 1 (3/7/2017)
 */
public class GunDealerGUI extends Application {

    //fields
    final static GunStorage gunCollection = new GunStorage("Thompson");
    //text field for the user and the edit
    private TextField txtId;
    private TextField txtYear;
    private TextField txtCost;
    private TextField txtEditId;
    private TextField txtEditYear;
    private TextField txtEditCost;
    //pane for the GUI
    private FlowPane bottomPane;
    private FlowPane topPane;
    private BorderPane mainPane;
    private ScrollPane leftPane;
    private Pane centerPane;
    private GridPane editPane;
    //the main stage
    Stage pStage;
    private IntegerArrayList buttonCounter = new IntegerArrayList();
    

    //GUI declaration method
    /**
     * The GUI start up method
     *
     * @param primaryStage the primary stage to load the GUI
     */
    @Override
    public void start(Stage primaryStage) throws InvalidIndexException {
        pStage = primaryStage;
        //create pane for the scene
        topPane = getTopPane();
        bottomPane = getBottomPane();
        leftPane = getLeftPane();
        centerPane = new Pane();
        mainPane = getRootPane(topPane, leftPane, centerPane, bottomPane);
        //set up a scene with pane in it
        Scene scene = new Scene(mainPane);
        //fill the scene with color
        scene.setFill(Color.ALICEBLUE);
        //set the stage for the sceen
        pStage.setScene(scene);
        pStage.setTitle("Gun Dealer Application");
        //set the location when the program pop up
        Rectangle2D screenBounds = Screen.getPrimary().getVisualBounds();
        pStage.setX((screenBounds.getWidth()
                - pStage.getWidth()) / 2);
        pStage.setY((screenBounds.getHeight()
                - pStage.getHeight()) / 2);
        //set the size of the program
        pStage.setWidth(1000);
        pStage.setHeight(800);
        pStage.show();

    }

    //methods for Panes and Buttons
    /**
     * This is the root pane for the whole GUI. It will setup the location of
     * each pane in this project
     *
     * @param topPane the top layout of the project
     * @param leftPane the left layout of the project
     * @param centerPane the center layout of the project
     * @param bottomPane the bottom layout of the project
     * @return the root pane which includes every single pane in it
     */
    public BorderPane getRootPane(Pane topPane, ScrollPane leftPane,
            Pane centerPane, Pane bottomPane) {
        BorderPane pane = new BorderPane();
        pane.setTop(topPane);
        pane.setLeft(leftPane);
        pane.setBottom(bottomPane);
        pane.setBackground(new Background(new BackgroundFill(Color.GHOSTWHITE,
                CornerRadii.EMPTY, Insets.EMPTY)));
        return pane;
    }

    /**
     * Setting up the center pane for the GUI
     * 
     * @param index the index of the button
     * @param gunCollection the collection to get data
     */
    public void getCenterPane(int index, GunStorage gunCollection){
        editPane = new GridPane();
        //label for prompting ID
        Label lblId = new Label("Gun ID: ");
        GridPane.setHalignment(lblId, HPos.RIGHT);
        editPane.add(lblId, 0, 1);
        Label lblYear = new Label("Year: ");
        GridPane.setHalignment(lblYear, HPos.RIGHT);
        editPane.add(lblYear, 0, 2);
        //label for prompting cost
        Label lblCost = new Label("Cost: ");
        GridPane.setHalignment(lblCost, HPos.RIGHT);
        editPane.add(lblCost, 0, 3);
        //text field for ID
        txtEditId = new TextField();
        txtEditId.setPromptText("ID");
        txtEditId.setMaxWidth(100);
        editPane.add(txtEditId, 1, 1);
        //text field for year
        txtEditYear = new TextField();
        txtEditYear.setPromptText("Year");
        txtEditYear.setMaxWidth(100);
        editPane.add(txtEditYear, 1, 2);
        //text field for cost
        txtEditCost = new TextField();
        txtEditCost.setPromptText("Cost");
        txtEditCost.setMaxWidth(100);
        editPane.add(txtEditCost, 1, 3);
        //setting up the button for update and remove
        Button btnUpdate = new Button("Update gun info");
        GridPane.setHalignment(btnUpdate, HPos.CENTER);
        editPane.add(btnUpdate, 0, 4);
        Button btnRemove = new Button("Remove profile");
        GridPane.setHalignment(btnRemove, HPos.CENTER);
        editPane.add(btnRemove, 1, 4);
        btnUpdate.setOnAction(new EventHandler<ActionEvent>() { // This need some debugging because it only changes the first button WTF????
            @Override
            public void handle(ActionEvent event) {
                try {
                    gunCollection.removeAt(index);
                    gunCollection.addAt(index, Integer.valueOf(txtEditId.getText()),
                             Integer.valueOf(txtEditYear.getText()),
                             Integer.valueOf(txtEditCost.getText()));
                    start(pStage);
                } catch (InvalidIndexException ex) {
                    ;
                }
            }
        });
        btnRemove.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                try {
                    deleteGun();
                } catch (InvalidIndexException ex) {
                    ;
                }
            }
        });
        //setting up the center pane
        editPane.setAlignment(Pos.CENTER);
        editPane.setPadding(new Insets(25, 25, 25, 25));
        editPane.setVgap(30);
        editPane.setHgap(30);
        editPane.setBackground(new Background(new BackgroundFill(Color.GHOSTWHITE,
                CornerRadii.EMPTY, Insets.EMPTY)));
    }

    /**
     * This is the top pane of the GUI
     *
     * @return the top layout of the project
     */
    public FlowPane getTopPane() {
        //setting up the content in the pane
        Button btnSave = new Button("Save");
        Button btnDelete = new Button("Delete");
        btnSave.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {

            }
        });
        btnDelete.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                //this is where we code the delete button using file handler   
            }
        });
        //setting the top pane
        FlowPane topPane = new FlowPane();
        topPane.setHgap(500);
        topPane.setPadding(new Insets(15, 15, 15, 15));
        topPane.getChildren().addAll(btnSave, btnDelete);
        topPane.setAlignment(Pos.CENTER);
        topPane.setBackground(new Background(new BackgroundFill(Color.GOLD,
                CornerRadii.EMPTY, Insets.EMPTY)));
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
                "Sort by id", "Sort by year", "Sort by cost");
        sortingDropList.setEditable(false);
        sortingDropList.setPromptText("Select a sort method");
        //the sorting is not yet implemented!!!!

        //setting up the content in the pane
        Button btnAdd = new Button("Add new info");
        Button btnAverage = new Button("Average");
        //text field for name
        txtId = new TextField();
        txtId.setPromptText("ID");
        txtId.setMaxWidth(100);
        //text field for year
        txtYear = new TextField();
        txtYear.setPromptText("Year");
        txtYear.setMaxWidth(100);
        //text field for cost
        txtCost = new TextField();
        txtCost.setPromptText("Cost");
        txtCost.setMaxWidth(100);
        btnAdd.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                try {
                    addGun();
                } catch (InvalidIndexException ex) {
                    ;
                }
            }
        });
        btnAverage.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {

            }
        });
        //setting up the bottom layout
        FlowPane bottomPane = new FlowPane();
        bottomPane.getChildren().addAll(sortingDropList, txtId, txtYear,
                txtCost, btnAdd, btnAverage);
        bottomPane.setAlignment(Pos.CENTER);
        bottomPane.setHgap(30);
        bottomPane.setPadding(new Insets(15, 15, 15, 15));
        bottomPane.setBackground(new Background(new BackgroundFill(Color.GOLD,
                CornerRadii.EMPTY, Insets.EMPTY)));
        return bottomPane;
    }

    /**
     * This is the left pane of the GUI
     *
     * @return the left layout of the project
     */
    public ScrollPane getLeftPane() throws InvalidIndexException {
        List<Button> guns = new ArrayList<>();
        for (int i = 0; i < gunCollection.getSize(); i++) {
            guns.add(new Button(gunCollection.getId(i)
                    + " (" + gunCollection.getYear(i) + "): $"
                    + gunCollection.getCost(i)));
            
            guns.get(i).setMinSize(100, 20);
            final int index = i;
            guns.get(i).setOnAction(e -> {
                try {
                    getCenterPane(index, gunCollection);
                    mainPane.setCenter(editPane);
                    txtEditId.setText(String.valueOf(gunCollection.getId(index)));
                    txtEditCost.setText(String.valueOf(gunCollection.getCost(index)));
                    txtEditYear.setText(String.valueOf(gunCollection.getYear(index)));
                    buttonCounter.add(gunCollection.getIndex());
                } catch (InvalidIndexException ex) {
                }

            });
        }
        ScrollPane leftPane = new ScrollPane();
        //create a VBox
        VBox pane = new VBox();
        pane.setPadding(new Insets(20, 20, 20, 20));
        pane.setAlignment(Pos.CENTER);
        pane.getChildren().addAll(guns);
        leftPane.setContent(pane);
        leftPane.setBackground(new Background(new BackgroundFill(Color.ALICEBLUE,
                CornerRadii.EMPTY, Insets.EMPTY)));
        return leftPane;
    }

    /**
     * Add the information from the user input
     *
     * @throws InvalidIndexException the exception of the invalid index
     */
    public void addGun() throws InvalidIndexException {
        gunCollection.add(Integer.valueOf(txtId.getText()),
                Integer.valueOf(txtYear.getText()),
                Integer.valueOf(txtCost.getText()));
        start(pStage);
    }

    /**
     * Delete the information from the user input
     *
     * @throws InvalidIndexException the exception of the invalid index
     */
    public void deleteGun() throws InvalidIndexException {
        gunCollection.remove(Integer.valueOf(txtEditId.getText()),
                Integer.valueOf(txtEditYear.getText()),
                Integer.valueOf(txtEditCost.getText()));
        start(pStage);
    }
}
