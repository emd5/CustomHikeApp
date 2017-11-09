/*Liz Mahoney & Jacob Langham
 *11/6/17
 *ReminderScene.java
 */

package ui.Scenes;

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

import java.util.List;

/**
 * @author Liz Mahoney & Jacob Langham
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

        VBox reminderFrame = new VBox();

        reminderFrame.setId("view-hikeList");

        ListView reminderList = new ListView();

        List list = ReminderController.getInstance ().getReminderList ();

        ObservableList<List> items = FXCollections.observableArrayList(list);

        reminderList.getItems().addAll(items);
        reminderFrame.getChildren().addAll(reminderList, back);

        gridPane.add (addReminderLabel, 0 ,0 );
        gridPane.add (reminderText, 2,0);
        gridPane.add(reminderFrame, 0, 2);
        gridPane.add (back,1,15);
        gridPane.add (submit, 3, 0);

        bodyContent.getChildren().addAll(gridPane);

        return bodyContent;
    }

//    private static List getReminders() {
//
//        final List getReminders = ReminderController.getInstance ().getReminderList ();
//
//        return getReminders;
//    }

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
