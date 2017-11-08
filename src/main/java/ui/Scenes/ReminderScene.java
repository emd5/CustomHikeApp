package ui.Scenes;/*
 *Liz Mahoney
 *11/6/17
 *ReminderScene.java
 */

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
 * @author Liz Mahoney
 * @version 1.0
 */
public class ReminderScene {

    private static final Text headerText = new Text("Add reminders");
    private static final Text footerText = new Text("footer");
    private final static String PADDING_10 = "padding10";

    private static TextField reminderText;

    public static Scene reminderScene(Stage stage, HikeUI hikeUI) {
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

        final Label addReminderLabel = SceneUtils
                .label("Add a new Reminder: ", "form-label");
        addReminderLabel.setWrapText (true);
        reminderText = SceneUtils.inputTextField("form-field");



        VBox hikeViewList = new VBox();

        hikeViewList.setId("view-hikeList");

        ListView hikeList = new ListView();


        final String[] getReminders = getReminders();
        for(int i=0; i< getReminders.length; i++){
            ObservableList<String> items = FXCollections.observableArrayList(getReminders[i]);
            hikeList.getItems().addAll(items);
        }
        hikeViewList.getChildren().addAll(hikeList, back);
        gridPane.add (addReminderLabel, 0 ,0 );
        gridPane.add (reminderText, 2,0);
        gridPane.add(hikeList, 0, 2);
        gridPane.add (back,0,15);
        gridPane.add (submit, 3, 0);

        bodyContent.getChildren().addAll(gridPane);

        return bodyContent;
    }

    private static String[] getReminders() {

        final String[] getReminder = ReminderController.getInstance()
                .getAllReminders ();

        return getReminder;
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
