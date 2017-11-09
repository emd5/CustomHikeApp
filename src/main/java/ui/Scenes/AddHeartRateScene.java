package ui.Scenes;

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
 * this class creates a add heartrate scene
 *
 * @author Liz Mahoney
 * @author Jacob Langham
 * @version 1.0
 */
public class AddHeartRateScene {

    private final static Text headerText = new Text("Add heart rate");

    private static final Text footerText = new Text("");

    private static TextField hikeText;

    private static TextField heartText;

    /**
     * creates a add heart scene
     *
     * @param stage  the stage to use
     * @param hikeUI the hikeui to use
     * @return the scene
     */
    public static Scene addHeartScene(final Stage stage, final HikeUI hikeUI) {
        final Button back = SceneUtils.backButton(stage, hikeUI);
        final Button submit = submitButton(stage, hikeUI);
        final VBox bodyContent = bodyContent(back, submit);

        return SceneUtils.makeBasicScene(headerText, bodyContent, footerText, stage, hikeUI);
    }

    private static VBox bodyContent(final Button back, final Button submit) {
        final VBox contentBox = new VBox();

        final GridPane gridPane = new GridPane();
        gridPane.setId("form-grid-spacing");

        final Label hikeLabel = SceneUtils.label("Hike Name: ", "form-label");

        hikeText = SceneUtils.inputTextField("form-field");

        final Label heartLabel = SceneUtils.label("Heart Rate: ", "form-label");

        heartText = SceneUtils.inputTextField("form-field");

        gridPane.add(hikeLabel, 0, 0);
        gridPane.add(hikeText, 1, 0);
        gridPane.add(heartLabel, 0, 1);
        gridPane.add(heartText, 1, 1);
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

                HikeController.getInstance()
                              .addHeartRateForHike(hikeText.getText(), Integer.parseInt(heartText.getText()));
                stage.setScene(hikeUI.homeScene());
            }
        });
        return submit;
    }

}
