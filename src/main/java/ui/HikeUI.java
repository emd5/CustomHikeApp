package ui;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.Callable;

import controller.ProgramStatusController;
import controller.ReminderController;
import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import javafx.util.Duration;
import ui.Scenes.AddCheckListScene;
import ui.Scenes.AddHeartRateScene;
import ui.Scenes.AddHikeScene;
import ui.Scenes.AddStepsScene;
import ui.Scenes.AverageHeartStepScene;
import ui.Scenes.ReminderScene;
import ui.Scenes.SceneUtils;
import ui.Scenes.ViewHikeScene;
import ui.Scenes.WaitingScene;

/**
 * This class builds the Hike user interface
 *
 * @author Liz Mahoney
 * @author Jacob Langham
 * @version 1.0
 */
public class HikeUI extends Application {

    private static final int WINDOW_WIDTH = 400;

    private static final int WINDOW_HEIGHT = 500;

    private static final String[] menuLabel = { "+ New Hike", "View Hikes", "+HeartRate", "View Avg \n Heart/Steps",
            "+Steps", "View Checklist", "+/- Reminders" };

    private static final String[] iconFileNames = { "images/marker.png", "images/hike.png", "images/redheart.png",
            "images/data.png", "images/steps.png", "images/checklist.png", "images/reminder.png" };

    private static final int ICON_IMAGE_WIDTH = 60;

    private static final int ICON_IMAGE_HEIGHT = 50;

    private static final String TITLE = "Hike Log Application";

    private Stage stage;

    private static final Map<String, Callable> buttonsMap = new HashMap<>();

    /**
     * sets up the user interface
     *
     * @param stage the stage to use
     */
    @Override
    public void start(final Stage stage) {
        this.stage = stage;
        makeButtonMap();

        stage.setTitle(TITLE);
        stage.setScene(WaitingScene.waitingScene(this));
        stage.show();

        final KeyFrame frame = new KeyFrame(Duration.millis(3000), new EventHandler<ActionEvent>() {
            @Override
            public void handle(final ActionEvent event) {
                stage.setScene(homeScene());
            }
        });

        final Timeline animation = new Timeline(frame);
        animation.play();
    }

    /**
     * creates the home scene
     *
     * @return the home scene
     */
    public Scene homeScene() {
        final Text headerText = new Text("Welcome Jose");
        final VBox menuVbox = homeMenuButtons();
        final Text reminderMessage = reminderMessage();

        final VBox mainFrame = SceneUtils.mainFrame();

        final HBox header = SceneUtils.headingFrame(headerText);

        final Button exitButton = exitButton();

        final HBox bodyFrame = SceneUtils.bodyFrame(menuVbox);
        final HBox footer = SceneUtils.footerFrame(reminderMessage);

        mainFrame.getChildren().addAll(header, bodyFrame, exitButton, footer);
        mainFrame.getStylesheets().addAll("css/hike.css");

        return new Scene(mainFrame, WINDOW_WIDTH, WINDOW_HEIGHT);
    }

    private Text reminderMessage() {
        final String message = ReminderController.getInstance().getReminder().getMessage();
        final Text reminderMessage = new Text(message);
        reminderMessage.setId("reminder-message");
        return reminderMessage;
    }

    private VBox homeMenuButtons() {
        final VBox menuBox = new VBox();
        final GridPane menuGrid = new GridPane();
        menuGrid.setId("menuFrame");

        final Image[] images = new Image[iconFileNames.length];
        final Button[] buttons = new Button[iconFileNames.length];

        for (int i = 0; i < buttons.length; i++) {
            final String file = iconFileNames[i];
            images[i] = new Image(file, ICON_IMAGE_WIDTH, ICON_IMAGE_HEIGHT, true, true);
            buttons[i] = new Button(menuLabel[i], new ImageView(images[i]));

            final String label = menuLabel[i];
            buttons[i].setOnAction(new EventHandler<ActionEvent>() {
                @Override
                public void handle(final ActionEvent event) {
                    try {
                        stage.setScene((Scene) buttonsMap.get(label).call());
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                }
            });

            buttons[i].getStyleClass().add("menu-button");
            menuGrid.add(buttons[i], i % 2, i / 2);
        }

        menuBox.getChildren().add(menuGrid);
        return menuBox;
    }

    private void makeButtonMap() {
        buttonsMap.put(menuLabel[0], () -> AddHikeScene.addHikeScene(stage, HikeUI.this));
        buttonsMap.put(menuLabel[1], () -> ViewHikeScene.viewHikeScene(stage, HikeUI.this));
        buttonsMap.put(menuLabel[2], () -> AddHeartRateScene.addHeartScene(stage, HikeUI.this));
        buttonsMap.put(menuLabel[3], () -> AverageHeartStepScene.averageHeartStepScene(stage, HikeUI.this));
        buttonsMap.put(menuLabel[4], () -> AddStepsScene.addStepsScene(stage, HikeUI.this));
        buttonsMap.put(menuLabel[5], () -> AddCheckListScene.addChecklistScene(stage, HikeUI.this));
        buttonsMap.put(menuLabel[6], () -> ReminderScene.reminderScene(stage, HikeUI.this));
    }

    private static Button exitButton() {
        final Button submit = new Button("Exit");
        submit.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(final ActionEvent event) {
                ProgramStatusController programStatusController = new ProgramStatusController();
                programStatusController.exit();
            }
        });
        return submit;
    }

    /**
     * gets the window width
     *
     * @return the window width
     */
    public int getWindowWidth() {
        return WINDOW_WIDTH;
    }

    /**
     * gets the window height
     *
     * @return the window height
     */
    public int getWindowHeight() {
        return WINDOW_HEIGHT;
    }
}
