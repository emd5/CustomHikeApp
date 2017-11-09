package ui.Scenes;

import java.time.LocalDate;

import controller.HikeController;
import javafx.event.ActionEvent;
import javafx.event.Event;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import ui.HikeUI;

public class AddHikeScene {

    private static final Text headerText = new Text("Add A Hike");

    private static final Text footerText = new Text("footer");

    private static final String PADDING_10 = "padding10";

    private static TextField nameField;

    private static TextField locationField;

    private static DatePicker dateField;

    public static Scene addHikeScene(Stage stage, HikeUI hikeUI) {
        final Button submit = submitButton(stage, hikeUI);
        final Button goBack = SceneUtils.backButton(stage, hikeUI);
        final HBox buttonRow = buttonRow(submit);

        final VBox formPane = formPane(buttonRow);
        formPane.getChildren().addAll(goBack);
        final VBox mainFrame = mainFrame(formPane);

        return new Scene(mainFrame, hikeUI.getWindowWidth(), hikeUI.getWindowHeight());
    }

    private static HBox buttonRow(final Button button) {
        final HBox formButton = new HBox();
        formButton.setId("formButton");
        formButton.getChildren().addAll(button);
        return formButton;
    }

    private static VBox formPane(final HBox bottomRow) {
        final HBox name = getFormBox("Name: ");
        final HBox location = getFormBox("Location: ");
        final HBox date = getFormBox("Date: ");
        final VBox formPane = new VBox();
        formPane.setId(PADDING_10);

        formPane.getChildren().addAll(name, location, date, bottomRow);
        return formPane;
    }

    private static HBox getFormBox(final String labelName) {
        final HBox rowField = new HBox();

        rowField.setId(PADDING_10);

        final Label formLabel = SceneUtils.label(labelName, "form-label");

        final Label formField = new Label();
        if (labelName.equals("Name: ")) {
            nameField = new TextField();
            nameField.setId("form-field");
            formField.setText(nameField.getText());
            rowField.getChildren().addAll(formLabel, formField, nameField);
        }
        if (labelName.equals("Location: ")) {
            locationField = new TextField();
            locationField.setId("form-field");
            formField.setText(nameField.getText());
            rowField.getChildren().addAll(formLabel, formField, locationField);

        }

        if (labelName.equals("Date: ")) {
            dateField = new DatePicker(LocalDate.now());
            dateField.setOnAction(new EventHandler() {
                public void handle(Event t) {
                    dateField.setValue(dateField.getValue());

                }
            });
            dateField.setId("form-field");

            rowField.getChildren().addAll(formLabel, formField, dateField);

            return rowField;
        }

        return rowField;
    }

    private static VBox mainFrame(final VBox bodyBox) {
        final HBox footer = SceneUtils.footerFrame(footerText);
        final HBox body = SceneUtils.bodyFrame(bodyBox);
        final HBox header = SceneUtils.headingFrame(headerText);
        final VBox mainFrame = SceneUtils.mainFrame();

        mainFrame.getChildren().addAll(header, body, footer);
        mainFrame.getStylesheets().addAll("css/hike.css");

        return mainFrame;
    }

    private static Button submitButton(final Stage stage, final HikeUI hikeUI) {
        final Button submit = new Button("Submit");
        submit.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(final ActionEvent event) {
                HikeController.getInstance()
                              .addHike(nameField.getText(), locationField.getText(), dateField.getValue());
                stage.setScene(hikeUI.homeScene());
            }
        });
        return submit;
    }
}
