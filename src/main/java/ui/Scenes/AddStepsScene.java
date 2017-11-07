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

    private static TextField stepsText;

    private static TextField hikeText;

    public static Scene addStepsScene(Stage stage, HikeUI hikeUI) {

        Button back = SceneUtils.backButton (stage,hikeUI);
        final Button submit = submitButton (stage, hikeUI);
        final VBox contentBox = totalStepsForm (back, submit);

        return SceneUtils.makeBasicScene(headerText, contentBox, footerText, stage, hikeUI);
    }

    private static VBox totalStepsForm(Button back, Button submit){

        final VBox contentBox = new VBox ();


        final HBox rows = new HBox();
        contentBox.setId(PADDING_10);

        final Label hikeLabel = new Label("Total Steps: ");
        hikeLabel.setId("steps-label");

        final Label hikeField = new Label ();
        hikeText = new TextField();
        hikeField.setText (hikeText.getText ());
        hikeField.setId("form-field");

        final Label stepsLabel = new Label("Total Steps: ");
        stepsLabel.setId("steps-label");

        final Label stepsField = new Label ();
        stepsText = new TextField();
        stepsField.setText (stepsText.getText ());
        stepsField.setId("form-field");

        rows.getChildren().addAll(stepsLabel, hikeText, stepsText);
        contentBox.getChildren ().addAll (rows, back, submit);

        return contentBox;
    }

    private static Button submitButton(final Stage stage, final HikeUI hikeUI) {
        final Button submit = new Button("Submit");
        submit.setOnAction(new EventHandler<ActionEvent> () {
            @Override
            public void handle(ActionEvent event) {
                System.out.println (hikeText.getText ());
                System.out.println (stepsText.getText ());
                HikeController.getInstance().addStepsForHike(hikeText.getText (), Integer.parseInt (stepsText.getText ()));
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
