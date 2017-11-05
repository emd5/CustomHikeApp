
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
import java.util.HashSet;


/**
 * This class builds the Hike interface
 *
 * @author Liz Mahoney
 * @author Jacob Langham
 * @version 1.0
 */
public class HikeUI extends Application {

    public static final int WINDOW_WIDTH = 400;
    public static final int WINDOW_HEIGHT = 500;

    private String[] menuLabel = {"View Hikes", "+HeartRate", "Avg Heart/Steps", "+Hike",
              "+CheckList" , "View Checklist"};

    private static final String[] fileNames = {"images/hike.png", "images/redheart.png",
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

        VBox mainFrame = new VBox () ;
        mainFrame.setId("mainFrame");

        //top frame
        HBox headingFrame = new HBox ();
        headingFrame.setId ("headingFrame");

        Text headingText = new Text ("Welcome Jose");

        headingFrame.getChildren ().add (headingText);

        //body frame
        HBox bodyFrame = new HBox ();
        bodyFrame.setId("bodyFrame");

        VBox menuVbox = new VBox ();
        menuVbox.setId ("menuFrame");

        Image[] images = new Image[fileNames.length];
        Button[] buttons = new Button[fileNames.length];
        Scene[] scenes = {addHikeScene(), addChecklistScene()};
        for( int i=0; i<buttons.length; i++){
            String file = fileNames[i];
            images[i] = new Image(file, 60,50,
                    false, false);
            buttons[i] = new Button (new String (menuLabel[i]), new ImageView (images[i]));
                final String label = menuLabel[i];
                    buttons[i].setOnAction (new EventHandler<ActionEvent> () {
                        @Override
                        public void handle(ActionEvent event) {
                            if(label.equals (menuLabel[0])){
                                stage.setScene (viewHikeScene ());
                            }
                            else if(label.equals (menuLabel[1])){
                                stage.setScene (addHeartScene ());
                            }
                            else if(label.equals (menuLabel[2])){
                                stage.setScene (averageHeartStepScene ());
                            }
                            else if(label.equals (menuLabel[3])){
                                stage.setScene (addHikeScene ());
                            }
                            else if(label.equals (menuLabel[4])){
                                stage.setScene (addChecklistScene ());
                            }
                        }
                    });

            buttons[i].getStyleClass().add("menu-button");
            menuVbox.getChildren ().add (buttons[i]);
        }

        bodyFrame.getChildren ().add(menuVbox);

        //footer frame
        HBox footerFrame = footerPane ();

        mainFrame.getChildren ().addAll (headingFrame,bodyFrame,footerFrame);
        mainFrame.getStylesheets ().addAll ("css/hike.css");

        return new Scene (mainFrame, WINDOW_WIDTH, WINDOW_HEIGHT);
    }

    private Scene viewHikeScene(){

        VBox mainFrame = new VBox () ;
        mainFrame.setId("mainFrame");

        //top frame
        HBox headingFrame = new HBox ();
        headingFrame.setId ("headingFrame");

        Text headingText = new Text ("View All Hikes");

        headingFrame.getChildren ().add (headingText);

        //body frame
        HBox bodyFrame = new HBox ();
        bodyFrame.setId("bodyFrame");

        Button goBack = backButton ();
        bodyFrame.getChildren ().add(goBack);

        //footer frame
        HBox footerFrame = footerPane ();

        mainFrame.getChildren ().addAll (headingFrame,bodyFrame,footerFrame);
        mainFrame.getStylesheets ().addAll ("css/hike.css");

        return new Scene (mainFrame, WINDOW_WIDTH, WINDOW_HEIGHT);
    }
    private Scene addHeartScene(){
        VBox mainFrame = new VBox () ;
        mainFrame.setId("mainFrame");

        //top frame
        HBox headingFrame = new HBox ();
        headingFrame.setId ("headingFrame");

        Text headingText = new Text ("Add Heart Rate");

        headingFrame.getChildren ().add (headingText);

        //body frame
        HBox bodyFrame = new HBox ();
        bodyFrame.setId("bodyFrame");

        Button goBack = backButton ();
        bodyFrame.getChildren ().add(goBack);

        //footer frame
        HBox footerFrame = footerPane ();

        mainFrame.getChildren ().addAll (headingFrame,bodyFrame,footerFrame);
        mainFrame.getStylesheets ().addAll ("css/hike.css");

        return new Scene (mainFrame, WINDOW_WIDTH, WINDOW_HEIGHT);
    }

    private Scene averageHeartStepScene(){
        VBox mainFrame = new VBox () ;
        mainFrame.setId("mainFrame");

        //top frame
        HBox headingFrame = new HBox ();
        headingFrame.setId ("headingFrame");

        Text headingText = new Text
                ("Avg Heart rate & Steps");

        headingFrame.getChildren ().add (headingText);

        //body frame
        HBox bodyFrame = new HBox ();
        bodyFrame.setId("bodyFrame");

        Button backButton = backButton ();
        bodyFrame.getChildren ().add(backButton);

        //footer frame
        HBox footerFrame = footerPane ();

        mainFrame.getChildren ().addAll (headingFrame,bodyFrame,footerFrame);
        mainFrame.getStylesheets ().addAll ("css/hike.css");

        return new Scene (mainFrame, WINDOW_WIDTH, WINDOW_HEIGHT);
    }

    private Scene addChecklistScene(){

        VBox mainFrame = new VBox () ;
        mainFrame.setId("mainFrame");

        //top frame
        HBox headingFrame = new HBox ();
        headingFrame.setId ("headingFrame");

        Text headingText = new Text ("Add CheckList");

        headingFrame.getChildren ().add (headingText);

        //body frame
        HBox bodyFrame = new HBox ();
        bodyFrame.setId("bodyFrame");

        VBox menuVbox = new VBox ();
        menuVbox.setId ("menuFrame");

        CheckBox checkBoxes = new CheckBox ();
        checkBoxes.setText ("Backpack");

        Button backButton = backButton ();
        bodyFrame.getChildren ().addAll(menuVbox,backButton);

        //footer frame
        HBox footerFrame = footerPane ();

        mainFrame.getChildren ().addAll (headingFrame,bodyFrame,footerFrame);
        mainFrame.getStylesheets ().addAll ("css/hike.css");

        return new Scene (mainFrame, WINDOW_WIDTH, WINDOW_HEIGHT);

    }


    private Scene addHikeScene(){

        VBox mainFrame = new VBox () ;
        mainFrame.setId("mainFrame");

        //title box
        HBox headingFrame = new HBox ();
        headingFrame.setId ("headingFrame");

        Text headingText = new Text ("Add a Hike");

        headingFrame.getChildren ().add (headingText);

        //body box
        HBox bodyFrame = new HBox ();
        bodyFrame.setId("bodyFrame");

        //box to stack input fields
        VBox formFrame = new VBox ();
        formFrame.setId ("padding10");

        //name field
        HBox row1 = new HBox();
        row1.setId ("padding10");

        Label nameLabel = new Label("Name: ");
        nameLabel.setId("form-label");

        TextField nameField = new TextField();
        nameField.setId ("form-field");

        row1.getChildren().addAll(nameLabel, nameField);

        //location field
        HBox row2 = new HBox();
        row2.setId ("padding10");

        Label locationLabel = new Label("Location: ");
        locationLabel.setId("form-label");

        TextField locationField = new TextField ();
        locationField.setId ("form-field");

        row2.getChildren().addAll(locationLabel, locationField);

        //date field
        HBox row3 = new HBox();
        row3.setId ("padding10");

        Label dateLabel = new Label("Date: ");
        dateLabel.setId("form-label");

        DatePicker datePicker = new DatePicker ();
        datePicker.setId ("form-field");

        row3.getChildren().addAll(dateLabel, datePicker);

        //heartrate field
        HBox row4 = new HBox();
        row4.setId ("padding10");

        Label heartLabel = new Label("Heart Rate: ");
        heartLabel.setId("form-label");

        TextField heartField = new TextField ();
        heartField.setId ("form-field");

        row4.getChildren().addAll(heartLabel, heartField);

        //steps field
        HBox row5 = new HBox();
        row5.setId ("padding10");

        Label stepLabel = new Label("Total Steps: ");
        stepLabel.setId("form-label");

        TextField stepField = new TextField ();
        stepField.setId ("form-field");

        row5.getChildren().addAll(stepLabel, stepField);

        //button row
        HBox row6 = new HBox ();
        row6.setId("formButton");


        //submit button
        Button submit = new Button ("Submit");
        submit.setOnAction (new EventHandler<ActionEvent> () {
            @Override
            public void handle(ActionEvent event) {

                HikeController addHike = HikeController.getInstance ();
                stage.setScene (homeScene ());
            }
        });

        //go back button??
        Button goBack = backButton ();


        row6.getChildren ().addAll (goBack,submit);
        formFrame.getChildren ().addAll
                (row1,row2,row3, row4, row5,row6);
        bodyFrame.getChildren ().addAll (formFrame);

        //bottom box
        HBox footerFrame = footerPane ();

        mainFrame.getChildren ().addAll (headingFrame,bodyFrame,footerFrame);
        mainFrame.getStylesheets ().addAll ("css/hike.css");

        return new Scene (mainFrame, WINDOW_WIDTH, WINDOW_HEIGHT);

    }

    private Button backButton(){

        Button goBack = new Button("Go Back");
        goBack.setOnAction (new EventHandler<ActionEvent> () {
            @Override
            public void handle(ActionEvent event) {
                stage.setScene (homeScene ());

            }
        });
        return goBack;
    }

    private HBox footerPane(){

        HBox footerFrame = new HBox ();
        footerFrame.setId("footerFrame");

        Text reminderMessage = new Text("Stop eating junk!");
        reminderMessage.setId ("reminder-message");

        footerFrame.getChildren ().addAll (reminderMessage);

        return footerFrame;
    }



    private static void createButtons(){

    }

    private static void addButtons(){

    }

}


