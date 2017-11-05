package ui.Scenes;

import controller.HikeController;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import ui.HikeUI;

public class AddHikeScene {

    private static final Text headerText = new Text("View All Hikes");

    private static final Text footerText = new Text("footer");

    private static final String PADDING_10 = "padding10";

    public static Scene addHikeScene(Stage stage, HikeUI hikeUI) {
        final Button submit = submitButton(stage, hikeUI);
        final AnchorPane goBack = SceneUtils.backButton(stage, hikeUI);
        final HBox buttonRow = buttonRow(goBack, submit);

        final VBox formPane = formPane(buttonRow);
        final AnchorPane anchorPane = new AnchorPane();
        anchorPane.getChildren().addAll(formPane);

        final VBox mainFrame = mainFrame(anchorPane);

        return new Scene(mainFrame, hikeUI.getWindowWidth(), hikeUI.getWindowHeight());
    }

    private static Button submitButton(final Stage stage, final HikeUI hikeUI) {
        final Button submit = new Button("Submit");
        submit.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                HikeController addHike = HikeController.getInstance();
                stage.setScene(hikeUI.homeScene());
            }
        });
        return submit;
    }

    private static HBox buttonRow(final AnchorPane anchorPane, final Button button) {
        final HBox formButton = new HBox();
        formButton.setId("formButton");

        formButton.getChildren().addAll(anchorPane, button);
        return formButton;
    }

    private static VBox formPane(HBox bottomRow) {
        final HBox name = getFormBox("Name: ");
        final HBox location = getFormBox("Location: ");
        final HBox date = getFormBox("Date: ");
        final HBox heartRate = getFormBox("Heart Rate: ");
        final HBox steps = getFormBox("Total Steps: ");
        final VBox formPane = new VBox();
        formPane.setId(PADDING_10);

        formPane.getChildren().addAll(name, location, date, heartRate, steps, bottomRow);
        return formPane;
    }

    private static HBox getFormBox(final String field) {
        final HBox row1 = new HBox();
        row1.setId(PADDING_10);

        final Label nameLabel = new Label(field);
        nameLabel.setId("form-label");

        final TextField nameField = new TextField();
        nameField.setId("form-field");

        row1.getChildren().addAll(nameLabel, nameField);
        return row1;
    }

    private static VBox mainFrame(final AnchorPane anchorPane) {
        final HBox footer = SceneUtils.footerFrame(footerText);
        final HBox body = SceneUtils.bodyFrame(anchorPane);
        final HBox header = SceneUtils.headingFrame(headerText);
        final VBox mainFrame = SceneUtils.mainFrame();

        mainFrame.getChildren().addAll(header, body, footer);
        mainFrame.getStylesheets().addAll("css/hike.css");

        return mainFrame;
    }
}
