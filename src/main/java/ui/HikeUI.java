package ui;

import controller.HikeController;
import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import javafx.scene.control.ProgressBar;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import javafx.util.Duration;

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

    private String[] menuLabel = { "View Hikes", "+HeartRate", "Avg Heart/Steps", "+Hike", "+CheckList",
            "View Checklist" };

    private static final String[] fileNames = { "images/hike.png", "images/redheart.png", "images/data.png",
            "images/marker.png", "images/checklist.png" };

    private Stage stage;

    @Override
    public void start(Stage stage) {

        this.stage = stage;

        stage.setTitle("Hike Log Application");
        stage.setScene(getWaitingScene());
        //stage.setResizable (false);
        stage.show();

        KeyFrame frame = new KeyFrame(Duration.millis(1000), new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {

                stage.setScene(homeScene());
            }
        });

        Timeline animation = new Timeline(frame);
        animation.play();
    }

    private Scene getWaitingScene() {

        VBox vBox = new VBox();

        ImageView backgroundImage = new ImageView("progress/boots.jpg");
        backgroundImage.setFitHeight(WINDOW_HEIGHT);
        backgroundImage.setFitWidth(WINDOW_WIDTH);

        ProgressBar progress = new ProgressBar();
        progress.setMaxWidth(WINDOW_WIDTH / 2);
        progress.getStyleClass().add("progress-bar");

        Text text = new Text("Lets Hike!");

        StackPane stackPane = new StackPane();
        stackPane.setAlignment(progress, Pos.CENTER);
        stackPane.setAlignment(text, Pos.CENTER);
        stackPane.getChildren().addAll(backgroundImage, progress, text);

        vBox.getChildren().addAll(stackPane);
        vBox.getStylesheets().addAll("css/hike.css");

        return new Scene(vBox, WINDOW_WIDTH, WINDOW_HEIGHT);
    }

    public Scene homeScene() {

        Text headerText = new Text("Welcome Jose");
        AnchorPane menuVbox = homeMenuButtons();
        Text reminderMessage = reminderMessage();

        VBox mainFrame = SceneUtils.mainFrame();
        HBox header = SceneUtils.headingFrame(headerText);

        HBox bodyFrame = SceneUtils.bodyFrame(menuVbox);
        HBox footer = SceneUtils.footerFrame(reminderMessage);

        mainFrame.getChildren().addAll(header, bodyFrame, footer);
        mainFrame.getStylesheets().addAll("css/hike.css");

        return new Scene(mainFrame, WINDOW_WIDTH, WINDOW_HEIGHT);
    }

    private Text reminderMessage() {

        Text reminderMessage = new Text("Stop eating junk!");
        reminderMessage.setId("reminder-message");
        return reminderMessage;
    }

    private AnchorPane homeMenuButtons() {

        AnchorPane anchorPane = new AnchorPane();
        VBox menuVbox = new VBox();
        menuVbox.setId("menuFrame");

        Image[] images = new Image[fileNames.length];
        Button[] buttons = new Button[fileNames.length];

        for (int i = 0; i < buttons.length; i++) {
            String file = fileNames[i];
            images[i] = new Image(file, 60, 50, false, false);
            buttons[i] = new Button(new String(menuLabel[i]), new ImageView(images[i]));
            final String label = menuLabel[i];
            buttons[i].setOnAction(new EventHandler<ActionEvent>() {
                @Override
                public void handle(ActionEvent event) {
                    if (label.equals(menuLabel[0])) {
                        stage.setScene(viewHikeScene());
                    } else if (label.equals(menuLabel[1])) {
                        //stage.setScene(addHeartScene());
                        stage.setScene(HeartScene.addHeartScene(stage, HikeUI.this));
                    } else if (label.equals(menuLabel[2])) {
                        stage.setScene(averageHeartStepScene());
                    } else if (label.equals(menuLabel[3])) {
                        stage.setScene(addHikeScene());
                    } else if (label.equals(menuLabel[4])) {
                        stage.setScene(CheckListScene.addChecklistScene(stage, HikeUI.this));
                    }
                }
            });

            buttons[i].getStyleClass().add("menu-button");
            menuVbox.getChildren().add(buttons[i]);

        }

        anchorPane.getChildren().add(menuVbox);

        return anchorPane;
    }

    private Scene viewHikeScene() {

        Text headerText = new Text("View All Hikes");

        Text footerText = new Text("footer");

        VBox mainFrame = SceneUtils.mainFrame();

        HBox header = SceneUtils.headingFrame(headerText);

        AnchorPane anchorPane = SceneUtils.backButton(stage, HikeUI.this);
        HBox body = SceneUtils.bodyFrame(anchorPane);
        HBox footer = SceneUtils.footerFrame(footerText);

        mainFrame.getChildren().addAll(header, body, footer);

        mainFrame.getStylesheets().addAll("css/hike.css");

        return new Scene(mainFrame, WINDOW_WIDTH, WINDOW_HEIGHT);
    }

    private Scene averageHeartStepScene() {

        Text headerText = new Text("Average Heart and Steps");

        VBox mainFrame = SceneUtils.mainFrame();
        HBox header = SceneUtils.headingFrame(headerText);

        AnchorPane anchorPane = SceneUtils.backButton(stage, HikeUI.this);
        HBox body = SceneUtils.bodyFrame(anchorPane);

        Text footerText = new Text("footer");
        HBox footer = SceneUtils.footerFrame(footerText);

        mainFrame.getChildren().addAll(header, body, footer);
        mainFrame.getStylesheets().addAll("css/hike.css");

        return new Scene(mainFrame, WINDOW_WIDTH, WINDOW_HEIGHT);
    }

    private Scene addHikeScene() {

        Text headerText = new Text("View All Hikes");

        VBox mainFrame = SceneUtils.mainFrame();

        HBox header = SceneUtils.headingFrame(headerText);

        //box to stack input fields
        VBox formPane = new VBox();
        formPane.setId("padding10");

        AnchorPane anchorPane = new AnchorPane();
        anchorPane.getChildren().addAll(formPane);
        //body box
        HBox body = SceneUtils.bodyFrame(anchorPane);
        //name field
        HBox row1 = new HBox();
        row1.setId("padding10");

        Label nameLabel = new Label("Name: ");
        nameLabel.setId("form-label");

        TextField nameField = new TextField();
        nameField.setId("form-field");

        row1.getChildren().addAll(nameLabel, nameField);

        //location field
        HBox row2 = new HBox();
        row2.setId("padding10");

        Label locationLabel = new Label("Location: ");
        locationLabel.setId("form-label");

        TextField locationField = new TextField();
        locationField.setId("form-field");

        row2.getChildren().addAll(locationLabel, locationField);

        //date field
        HBox row3 = new HBox();
        row3.setId("padding10");

        Label dateLabel = new Label("Date: ");
        dateLabel.setId("form-label");

        DatePicker datePicker = new DatePicker();
        datePicker.setId("form-field");

        row3.getChildren().addAll(dateLabel, datePicker);

        //heartrate field
        HBox row4 = new HBox();
        row4.setId("padding10");

        Label heartLabel = new Label("Heart Rate: ");
        heartLabel.setId("form-label");

        TextField heartField = new TextField();
        heartField.setId("form-field");

        row4.getChildren().addAll(heartLabel, heartField);

        //steps field
        HBox row5 = new HBox();
        row5.setId("padding10");

        Label stepLabel = new Label("Total Steps: ");
        stepLabel.setId("form-label");

        TextField stepField = new TextField();
        stepField.setId("form-field");

        row5.getChildren().addAll(stepLabel, stepField);

        //button row
        HBox row6 = new HBox();
        row6.setId("formButton");

        //submit button
        Button submit = new Button("Submit");
        submit.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {

                HikeController addHike = HikeController.getInstance();
                stage.setScene(homeScene());
            }
        });

        //go back button??
        AnchorPane goBack = SceneUtils.backButton(stage, HikeUI.this);

        row6.getChildren().addAll(goBack, submit);

        formPane.getChildren().addAll(row1, row2, row3, row4, row5, row6);

        //body.getChildren ().addAll (formFrame);

        //bottom box
        Text footerText = new Text("footer");
        HBox footer = SceneUtils.footerFrame(footerText);

        mainFrame.getChildren().addAll(header, body, footer);
        mainFrame.getStylesheets().addAll("css/hike.css");

        return new Scene(mainFrame, WINDOW_WIDTH, WINDOW_HEIGHT);
    }
}
