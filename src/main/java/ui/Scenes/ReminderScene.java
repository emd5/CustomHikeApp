package ui.Scenes;

import java.util.List;

import controller.ReminderController;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.VBox;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import ui.HikeUI;

/**
 * this class creates a reminder scene
 *
 * @author Liz Mahoney
 * @author Jacob Langham
 * @version 1.0
 */
public class ReminderScene {

    private static final Text headerText = new Text("Add reminders");

    private static final Text footerText = new Text("");

    private final static String PADDING_10 = "padding10";

    private static TextField reminderText;

    /**
     * creates a reminder scene
     *
     * @param stage  the stage to use
     * @param hikeUI the hikeui to use
     * @return the scene
     */
    public static Scene reminderScene(final Stage stage, final HikeUI hikeUI) {
        final Button back = SceneUtils.backButton(stage, hikeUI);
        final Button submit = submitButton(stage, hikeUI);
        final VBox bodyContent = bodyContent(back, submit);

        return SceneUtils.makeBasicScene(headerText, bodyContent, footerText, stage, hikeUI);
    }

    private static VBox bodyContent(final Button back, final Button submit) {
        final VBox bodyContent = new VBox();
        bodyContent.setId(PADDING_10);

        final GridPane gridPane = new GridPane();
        gridPane.setId("form-grid-spacing");

        final Label addReminderLabel = SceneUtils.label("Add Reminder: ", "reminder-label");
        reminderText = SceneUtils.inputTextField("form-field");

        final VBox reminderFrame = new VBox();
        reminderFrame.setId("view-reminderList");

        final ListView reminderList = new ListView();

        final List<String> list = ReminderController.getInstance().getReminderList();

        final ObservableList<String> items = FXCollections.observableArrayList(list);

        reminderList.getItems().addAll(items);
        reminderFrame.getChildren().addAll(reminderList, back);

        gridPane.add(addReminderLabel, 0, 0);
        gridPane.add(reminderText, 1, 0, 1, 1);
        gridPane.add(reminderFrame, 1, 2);
        gridPane.add(back, 0, 15);
        gridPane.add(submit, 2, 0);

        bodyContent.getChildren().addAll(gridPane);

        return bodyContent;
    }

    private static Button submitButton(final Stage stage, final HikeUI hikeUI) {
        final Button submit = new Button("Submit");
        submit.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(final ActionEvent event) {
                ReminderController.getInstance().addReminder(reminderText.getText());
                stage.setScene(hikeUI.homeScene());
            }
        });
        return submit;
    }

}
