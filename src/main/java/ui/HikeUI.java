package ui;

import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import javafx.util.Duration;
import ui.Scenes.AddHikeScene;
import ui.Scenes.AverageHeartStepScene;
import ui.Scenes.CheckListScene;
import ui.Scenes.HeartScene;
import ui.Scenes.ViewHikeScene;
import ui.Scenes.WaitingScene;

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
        stage.setScene(WaitingScene.waitingScene());
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
            buttons[i] = new Button(menuLabel[i], new ImageView(images[i]));
            final String label = menuLabel[i];
            buttons[i].setOnAction(new EventHandler<ActionEvent>() {
                @Override
                public void handle(ActionEvent event) {
                    if (label.equals(menuLabel[0])) {
                        stage.setScene(ViewHikeScene.viewHikeScene(stage, HikeUI.this));
                    } else if (label.equals(menuLabel[1])) {
                        stage.setScene(HeartScene.addHeartScene(stage, HikeUI.this));
                    } else if (label.equals(menuLabel[2])) {
                        stage.setScene(AverageHeartStepScene.averageHeartStepScene(stage, HikeUI.this));
                    } else if (label.equals(menuLabel[3])) {
                        stage.setScene(AddHikeScene.addHikeScene(stage, HikeUI.this));
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
}
