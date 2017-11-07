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
    private static final Text headerText = new Text ("Add Steps to your Hike");

    private static final Text footerText = new Text ("");

    private static final String PADDING_10 = "padding10";

    private static TextField stepsText;

    private static TextField hikeText;

    public static Scene addStepsScene(Stage stage, HikeUI hikeUI) {

        Button back = SceneUtils.backButton (stage, hikeUI);
        final Button submit = submitButton (stage, hikeUI);
        final VBox contentBox = totalStepsForm (back, submit);

        return SceneUtils.makeBasicScene (headerText, contentBox, footerText, stage, hikeUI);
    }

    private static VBox totalStepsForm(Button back, Button submit) {

        final VBox contentBox = new VBox ();


        final HBox rows = new HBox ();
        contentBox.setId (PADDING_10);

        final Label hikeLabel = new Label ("Total Steps: ");
        hikeLabel.setId ("steps-label");

        final Label hikeField = new Label ();
        hikeText = new TextField ();
        hikeField.setText (hikeText.getText ());
        hikeField.setId ("form-field");

        final Label stepsLabel = new Label ("Total Steps: ");
        stepsLabel.setId ("steps-label");

        final Label stepsField = new Label ();
        stepsText = new TextField ();
        stepsField.setText (stepsText.getText ());
        stepsField.setId ("form-field");

        rows.getChildren ().addAll (stepsLabel, hikeText, stepsText);
        contentBox.getChildren ().addAll (rows, back, submit);

        return contentBox;
    }

    private static Button submitButton(final Stage stage, final HikeUI hikeUI) {
        final Button submit = new Button ("Submit");
        submit.setOnAction (new EventHandler<ActionEvent> () {
            @Override
            public void handle(ActionEvent event) {
                System.out.println (hikeText.getText ());
                System.out.println (stepsText.getText ());
                HikeController.getInstance ().addStepsForHike (hikeText.getText (),
                        Integer.parseInt (stepsText.getText ()));
                stage.setScene (hikeUI.homeScene ());
            }
        });
        return submit;
    }


}