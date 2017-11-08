package ui.Scenes;/*
 *Liz Mahoney
 *11/6/17
 *ReminderScene.java
 */

import controller.ReminderController;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.VBox;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import ui.HikeUI;

/**
 * @author Liz Mahoney
 * @version 1.0
 */
public class ReminderScene {

    private static final Text headerText = new Text("Add/Remove reminders");

    private static final Text footerText = new Text("footer");

    public static Scene reminderScene(Stage stage, HikeUI hikeUI) {
        final Button back = SceneUtils.backButton(stage, hikeUI);
        final Button submit = submitButton(stage, hikeUI);
        final VBox bodyContent = bodyContent(back, submit);

        return SceneUtils.makeBasicScene(headerText, bodyContent, footerText, stage, hikeUI);
    }

    private static VBox bodyContent(final Button back, final Button submit) {

        final VBox bodyContent = new VBox();
        final Label getLabelReminder = getReminders();

        bodyContent.getChildren().addAll(getLabelReminder);

        return bodyContent;
    }

    private static Label getReminders() {

        final String getReminder = ReminderController.getInstance().getReminder().getMessage();

        final Label getLabelReminder = new Label(getReminder);

        return getLabelReminder;
    }

    private static Button submitButton(final Stage stage, final HikeUI hikeUI) {
        final Button submit = new Button("Submit");
        submit.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                stage.setScene(hikeUI.homeScene());
            }
        });
        return submit;
    }

}
