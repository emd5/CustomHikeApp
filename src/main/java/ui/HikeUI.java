
package ui;

import controller.HikeController;
import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.*;


import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import javafx.util.Duration;
import model.Hike;

import java.util.HashMap;


/**
 * This class builds the Hike interface
 *
 * @author Liz Mahoney
 * @author Jacob Langham
 * @version 1.0
 */
public class HikeUI extends Application {

    //public static GridPane gridPane;
    public static final int WINDOW_WIDTH = 400;
    public static final int WINDOW_HEIGHT = 500;
    public static final int HBOX_MAX_WIDTH = 400;
    private  String[] menuLabel = {"View Hikes", "+HeartRate", "Avg Heart/Steps", "+Hike",
              "+CheckList" , "View Checklist"};

    private static  String[] fileNames = {"images/hike.png", "images/redheart.png",
            "images/data.png", "images/checklist.png", "images/profile.png"};

    private Stage stage;

    @Override
    public void start(Stage stage) {

        this.stage = stage;

        stage.setTitle ("Hike Log Application");
        stage.setScene (getWaitingScene());
        //stage.setResizable (false);
        stage.show ();


        KeyFrame frame = new KeyFrame(Duration.millis(1000),
                new EventHandler<ActionEvent> () {
                    @Override
                    public void handle(ActionEvent event)
                    {
                        stage.setScene(homeScene());
                    }
                });

        Timeline animation = new Timeline(frame);
        animation.play();
    }

    private Scene getWaitingScene(){
        VBox vBox = new VBox ();

        ImageView backgroundImage = new ImageView ("progress/boots.jpg");
        backgroundImage.setFitHeight (WINDOW_HEIGHT);
        backgroundImage.setFitWidth (WINDOW_WIDTH);


        ProgressBar progress = new ProgressBar ();
        progress.setMaxWidth (WINDOW_WIDTH/2);

        progress.getStyleClass ().add ("progress-bar");


        Text text = new Text("Lets Hike!");

        StackPane stackPane = new StackPane ();
        stackPane.setAlignment (progress, Pos.CENTER);
        stackPane.setAlignment (text, Pos.CENTER);
        stackPane.getChildren().addAll( backgroundImage,progress, text );


        vBox.getChildren ().addAll (stackPane);
        vBox.getStylesheets ().addAll ("css/hike.css");
        return new Scene (vBox, WINDOW_WIDTH, WINDOW_HEIGHT);
    }


    private Scene homeScene(){

        VBox mainBox = new VBox () ;
        mainBox.setId("mainBox");

        //tophbox
        HBox headingBox = new HBox ();
        headingBox.setId ("headingBox");

        Text headingText = new Text ("Welcome Jose");

        headingBox.getChildren ().add (headingText);

        //middle hbox
        HBox bodyBox = new HBox ();
        bodyBox.setId("bodyBox");

        VBox menuVbox = new VBox ();
        menuVbox.setSpacing (5);

        Image[] images = new Image[fileNames.length];
        Button[] buttons = new Button[fileNames.length];


        for( int i=0; i<buttons.length; i++){
            String file = fileNames[i];
            images[i] = new Image(file, 60,50,
                    false, false);
            buttons[i] = new Button (new String (menuLabel[i]), new ImageView (images[i]));
            buttons[i].setPrefWidth (WINDOW_WIDTH/2);
            buttons[i].setContentDisplay (ContentDisplay.LEFT);
            buttons[i].setAlignment (Pos.CENTER_LEFT);
            buttons[i].getStyleClass().add("menu-button");

            buttons[i].setOnAction (new EventHandler<ActionEvent> () {
                @Override
                public void handle(ActionEvent event) {
                    stage.setScene (hikeScene ());
                }
            });
            menuVbox.getChildren ().add (buttons[i]);


        }

        bodyBox.getChildren ().add(menuVbox);

        //bottom hbox
        HBox footerBox = new HBox ();
        footerBox.setId("footerBox");


        Text reminderMessage = new Text("Stop eating junk!");
        reminderMessage.setId ("reminder-message");

        footerBox.getChildren ().addAll (reminderMessage);

        mainBox.getChildren ().addAll (headingBox,bodyBox,footerBox);
        mainBox.getStylesheets ().addAll ("css/hike.css");

        return new Scene (mainBox, WINDOW_WIDTH, WINDOW_HEIGHT);
    }


    private Scene hikeScene(){
        VBox vBox = new VBox();
        vBox.setAlignment(Pos.CENTER);
        vBox.setSpacing(10);
        vBox.setPadding(new Insets(10));

        //add a header
        Text header = new Text("Add New Hike");
        header.setFont(Font.font("Century Gothic",
                FontWeight.MEDIUM, 30));
        header.setUnderline(true);

        vBox.getChildren().add(header);

        //name field
        HBox row1 = new HBox();
        row1.setSpacing(10);

        Label nameLabel = new Label("Name: ");
        nameLabel.setPrefWidth(80);
        nameLabel.setAlignment(Pos.CENTER_RIGHT);

        TextField nameField = new TextField();
        nameField.setPrefWidth(180);

        row1.getChildren().addAll(nameLabel, nameField);
        //vBox.getChildren().add(row1);

        //location field
        HBox row2 = new HBox();
        row2.setSpacing(10);

        Label locationLabel = new Label("Location: ");
        locationLabel.setPrefWidth(80);
        locationLabel.setAlignment(Pos.CENTER_RIGHT);

        TextField locationField = new TextField ();
        locationField.setPrefWidth(180);

        row2.getChildren().addAll(locationLabel, locationField);
        //vBox.getChildren().add(row2);

        //date field
        HBox row3 = new HBox();
        row3.setSpacing (10);

        Label dateLabel = new Label("Date: ");
        dateLabel.setPrefWidth(80);
        dateLabel.setAlignment(Pos.CENTER_RIGHT);

        DatePicker datePicker = new DatePicker ();
        datePicker.setPrefWidth(180);

        row3.getChildren().addAll(dateLabel, datePicker);
        //vBox.getChildren().add(row3);

        //button row
        HBox rowButton = new HBox ();
        rowButton.setSpacing (10);
        rowButton.setPrefWidth (80);
        rowButton.setAlignment (Pos.CENTER);

        //submit button
        Button submit = new Button ("submit");
        submit.setOnAction (new EventHandler<ActionEvent> () {
            @Override
            public void handle(ActionEvent event) {

                HikeController addHike = HikeController.getInstance ();
                stage.setScene (homeScene ());
            }
        });

        //go back button??
        Button goBack = new Button("Go Back");
        goBack.setOnAction (new EventHandler<ActionEvent> () {
            @Override
            public void handle(ActionEvent event) {
                stage.setScene (homeScene ());

            }
        });

        rowButton.getChildren ().addAll (submit,goBack);

        vBox.getChildren ().addAll (row1,row2,row3,rowButton);

        vBox.getStylesheets ().addAll ("css/hike.css");

        return new Scene(vBox, WINDOW_WIDTH, WINDOW_HEIGHT);
    }





    private static void createButtons(){

    }

    private static void addButtons(){

    }



    private static void eventHandling(){

    }

}


