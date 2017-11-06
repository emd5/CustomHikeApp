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
import ui.Scenes.*;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.Callable;

/**
 * This class builds the Hike interface
 *
 * @author Liz Mahoney
 * @author Jacob Langham
 * @version 1.0
 */
public class HikeUI extends Application {

    private static final int WINDOW_WIDTH = 400;

    private static final int WINDOW_HEIGHT = 500;

    private static final String[] menuLabel =
            { "View Hikes", "+HeartRate", "Avg Heart/Steps",
                    "+Hike", "+CheckList", "View Checklist" };

    private static final String[] iconFileNames =
            { "images/hike.png", "images/redheart.png", "images/data.png",
            "images/marker.png", "images/checklist.png" };

    private Stage stage;

    private static final Map<String, Callable> buttonsMap = new HashMap<>();

    @Override
    public void start(final Stage stage) {
        this.stage = stage;
        makeButtonMap();

        stage.setTitle("Hike Log Application");
        stage.setScene(WaitingScene.waitingScene(this));
        //stage.setResizable (false);
        stage.show();

        final KeyFrame frame = new KeyFrame(Duration.millis(1000), new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                stage.setScene(homeScene());
            }
        });

        final Timeline animation = new Timeline(frame);
        animation.play();
    }

    public Scene homeScene() {
        final Text headerText = new Text("Welcome Jose");
        final AnchorPane menuVbox = homeMenuButtons();
        final Text reminderMessage = reminderMessage();

        final VBox mainFrame = SceneUtils.mainFrame();

        final HBox header = SceneUtils.headingFrame(headerText);

        final HBox bodyFrame = SceneUtils.bodyFrame(menuVbox);
        final HBox footer = SceneUtils.footerFrame(reminderMessage);

        mainFrame.getChildren().addAll(header, bodyFrame, footer);
        mainFrame.getStylesheets().addAll("css/hike.css");

        return new Scene(mainFrame, WINDOW_WIDTH, WINDOW_HEIGHT);
    }

    private Text reminderMessage() {

        final Text reminderMessage = new Text("Stop eating junk!");
        reminderMessage.setId("reminder-message");
        return reminderMessage;
    }

    private AnchorPane homeMenuButtons() {
        final AnchorPane anchorPane = new AnchorPane();
        final VBox menuVbox = new VBox();
        menuVbox.setId("menuFrame");

        final Image[] images = new Image[iconFileNames.length];
        final Button[] buttons = new Button[iconFileNames.length];

        for (int i = 0; i < buttons.length; i++) {
            final String file = iconFileNames[i];
            images[i] = new Image(file, 60, 50,
                    false, false);
            buttons[i] = new Button(menuLabel[i], new ImageView(images[i]));
            final String label = menuLabel[i];
            buttons[i].setOnAction(new EventHandler<ActionEvent>() {
                @Override
                public void handle(ActionEvent event) {
                    try {
                        stage.setScene((Scene) buttonsMap.get(label).call());
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                }
            });

            buttons[i].getStyleClass().add("menu-button");
            menuVbox.getChildren().add(buttons[i]);
        }

        anchorPane.getChildren().add(menuVbox);
        return anchorPane;
    }

    private void makeButtonMap() {
        buttonsMap.put(menuLabel[0], () ->
                ViewHikeScene.viewHikeScene(stage, HikeUI.this));
        buttonsMap.put(menuLabel[1], () ->
                HeartScene.addHeartScene(stage, HikeUI.this));
        buttonsMap.put(menuLabel[2], () ->
                AverageHeartStepScene.averageHeartStepScene (stage, HikeUI.this));
        buttonsMap.put(menuLabel[3], () ->
                AddHikeScene.addHikeScene(stage, HikeUI.this));
        buttonsMap.put(menuLabel[4], () ->
                CheckListScene.addChecklistScene(stage, HikeUI.this));
    }

    public int getWindowWidth() {

        return WINDOW_WIDTH;
    }

    public int getWindowHeight() {

        return WINDOW_HEIGHT;
    }
}
