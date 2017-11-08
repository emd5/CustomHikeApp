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
import javafx.scene.layout.GridPane;
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

    public static Scene addStepsScene(final Stage stage, final HikeUI hikeUI) {

        final Button back = SceneUtils.backButton(stage, hikeUI);
        final Button submit = submitButton(stage, hikeUI);
        final VBox contentBox = totalStepsForm(back, submit);

        return SceneUtils.makeBasicScene(headerText, contentBox, footerText, stage, hikeUI);
    }

    private static VBox totalStepsForm(final Button back, final Button submit) {
        final VBox contentBox = new VBox();
        contentBox.setId(PADDING_10);

        final GridPane gridPane = new GridPane();
        gridPane.setId("form-grid-spacing");

        final Label hikeLabel = SceneUtils.label("Hike Name: ", "form-label");

        hikeText = SceneUtils.inputTextFieldWithLabel("form-field");

        final Label stepsLabel = SceneUtils.label("Total Steps: ", "form-label");

        //        final Label stepsField = new Label();
        //        stepsText = new TextField();
        //        stepsField.setText(stepsText.getText());
        //        stepsField.setId("form-field");
        stepsText = SceneUtils.inputTextFieldWithLabel("form-field");

        gridPane.add(hikeLabel, 0, 0);
        gridPane.add(hikeText, 1, 0);
        gridPane.add(stepsLabel, 0, 1);
        gridPane.add(stepsText, 1, 1);
        gridPane.add(back, 1, 20);
        gridPane.add(submit, 1, 2);

        contentBox.getChildren().addAll(gridPane);

        return contentBox;
    }

    private static Button submitButton(final Stage stage, final HikeUI hikeUI) {
        final Button submit = new Button("Submit");
        submit.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                HikeController.getInstance().addStepsForHike(hikeText.getText(), Integer.parseInt(stepsText.getText()));
                stage.setScene(hikeUI.homeScene());
            }
        });
        return submit;
    }

}
