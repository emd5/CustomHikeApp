package ui.Scenes;/*
 *Liz Mahoney
 *11/6/17
 *AddStepsScene.java
 */

import controller.HikeController;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import ui.HikeUI;

/**
 * @author Liz Mahoney
 * @version 1.0
 */
public class AddStepsScene {
    private static final Text headerText = new Text("Add Steps to your Hike");

    private static final Text footerText = new Text("");

    private static final String PADDING_10 = "padding10";

    public static Scene addStepsScene(Stage stage, HikeUI hikeUI) {

        Button back = SceneUtils.backButton (stage,hikeUI);

        return SceneUtils.makeBasicScene(headerText, totalStepsForm (back), footerText, stage, hikeUI);
    }

    private static VBox totalStepsForm(Button back){

        final VBox contentBox = new VBox ();

        final HBox rows = new HBox();
        contentBox.setId(PADDING_10);

        final Label nameLabel = new Label("Total Steps");
        nameLabel.setId("form-label");

        final TextField nameField = new TextField();
        nameField.setId("form-field");

        rows.getChildren().addAll(nameLabel, nameField,back);
        contentBox.getChildren ().add (rows);

        return contentBox;
    }

    private static Button submitButton(final Stage stage, final HikeUI hikeUI) {
        final Button submit = new Button("Submit");
        submit.setOnAction(new EventHandler<ActionEvent> () {
            @Override
            public void handle(ActionEvent event) {
                HikeController addSteps= HikeController.getInstance();
                //addSteps.addSteps ();
                stage.setScene(hikeUI.homeScene());
            }
        });
        return submit;
    }


//    private static HBox buttonRow(final AnchorPane anchorPane, final Button button) {
//        final HBox formButton = new HBox();
//        formButton.setId("formButton");
//
//        formButton.getChildren().addAll(anchorPane, button);
//        return formButton;
//    }
//
//    private static VBox formPane(HBox bottomRow) {
//
//        final HBox steps = getFormBox("Total Steps: ");
//        final VBox formPane = new VBox();
//        formPane.setId(PADDING_10);
//
//        formPane.getChildren().addAll( steps, bottomRow);
//        return formPane;
//    }
//
//    private static HBox getFormBox(final String field) {
//        final HBox row1 = new HBox();
//
//        row1.setId(PADDING_10);
//
//        final Label nameLabel = new Label(field);
//        nameLabel.setId("form-label");
//
//        final TextField nameField = new TextField();
//        nameField.setId("form-field");
//
//        row1.getChildren().addAll(nameLabel, nameField);
//        return row1;
//    }



}
