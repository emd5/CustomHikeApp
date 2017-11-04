
package ui;

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
    private static String[] menuLabel = {"View Hikes","+Hike",
            "+HeartRate", "Avg Heart/Steps", "+CheckList" , "View Checklist"};

    private static HashMap<String, Scene>  pages = new HashMap<> ();
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

        VBox vBox = new VBox () ;
        vBox.setPadding (new Insets (10));

        //tophbox
        HBox topHbox = new HBox ();
        topHbox.setPadding (new Insets (20));
        topHbox.setPrefWidth (HBOX_MAX_WIDTH);
        topHbox.setAlignment (Pos.CENTER);
        topHbox.setBorder (new Border(new BorderStroke(Color.BLACK,
                BorderStrokeStyle.SOLID, CornerRadii.EMPTY, BorderWidths.DEFAULT)));

        Text text1 = new Text ("Log your apps Jose");

        text1.setFont (Font.font ("Verdana", 20));

        topHbox.getChildren ().add (text1);

        //middle hbox
        HBox middleHbox = new HBox ();
        middleHbox.setPadding (new Insets (10));
        middleHbox.setPrefSize (HBOX_MAX_WIDTH, 400);
        middleHbox.setBorder (new Border(new BorderStroke(Color.BLACK,
                BorderStrokeStyle.SOLID, CornerRadii.EMPTY, BorderWidths.DEFAULT)));

        VBox menuVbox = new VBox ();
        menuVbox.setSpacing (5);

        //vBox.setVgap (5);
        //gridPane.setHgap (5);

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
            buttons[i].getStyleClass().add("menu-button");

        }


        middleHbox.getChildren ().add(menuVbox);

        //bottom hbox
        HBox bottomHbox = new HBox ();
        bottomHbox.setAlignment (Pos.CENTER);
        bottomHbox.setPadding (new Insets (5));
        bottomHbox.setPrefWidth (HBOX_MAX_WIDTH);
        bottomHbox.setBorder (new Border(new BorderStroke(Color.BLACK,
                BorderStrokeStyle.SOLID, CornerRadii.EMPTY, BorderWidths.DEFAULT)));

        Text reminderMessage = new Text("Stop eating junk!");
        reminderMessage.setId ("reminder-message");

        bottomHbox.getChildren ().addAll (reminderMessage);

        vBox.getChildren ().addAll (topHbox,middleHbox,bottomHbox);
        vBox.getStylesheets ().addAll ("css/hike.css");

        return new Scene (vBox, WINDOW_WIDTH, WINDOW_HEIGHT);
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

        //add form controls
        HBox row1 = new HBox();
        row1.setSpacing(10);

        Label nameLabel = new Label("Hike Name: ");
        nameLabel.setPrefWidth(90);
        nameLabel.setAlignment(Pos.CENTER_RIGHT);

        TextField field = new TextField();
        field.setPrefWidth(180);

        row1.getChildren().addAll(nameLabel, field);
        vBox.getChildren().add(row1);

        //add more form controls
        HBox row2 = new HBox();
        row2.setSpacing(10);

        Label bioLabel = new Label("Bio: ");
        bioLabel.setPrefWidth(90);
        bioLabel.setAlignment(Pos.CENTER_RIGHT);

        TextArea area = new TextArea();
        area.setPrefWidth(180);

        Button goBack = new Button("Go Back");
        goBack.setOnAction (new EventHandler<ActionEvent> () {
            @Override
            public void handle(ActionEvent event) {
                stage.setScene (homeScene ());
            }
        });

        row2.getChildren().addAll(bioLabel, area, goBack);
        vBox.getChildren().add(row2);

        return new Scene(vBox, WINDOW_WIDTH, WINDOW_HEIGHT);
    }


//    private Scene hikeFormScene(){
//
//
//
//
//        return new Scene(vBox, WINDOW_WIDTH, WINDOW_HEIGHT);
//
//
//    }


    private static void createButtons(){

    }

    private static void addButtons(){

    }



    private static void eventHandling(){

    }

}


