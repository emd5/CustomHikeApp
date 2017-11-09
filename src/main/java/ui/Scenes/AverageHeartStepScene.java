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

public class AverageHeartStepScene {

    private static final Text headerText = new Text("Average Heart and Steps");

    private static final Text footerText = new Text("footer");

    private static TextField inputHikeName;

    private static final String PADDING_10 = "padding10";

    private static Label heartLabel;

    private static Label stepLabel;

    public static Scene averageHeartStepScene(final Stage stage, final HikeUI hikeUI) {
        final Button back = SceneUtils.backButton(stage, hikeUI);
        final Button submitHikeName = submitButton();

        return SceneUtils.makeBasicScene(headerText, bodyContent(back, submitHikeName), footerText, stage, hikeUI);
    }

    private static VBox bodyContent(final Button back, final Button submitHikeName) {
        final VBox contentBox = new VBox();
        contentBox.setId(PADDING_10);

        final GridPane gridPane = new GridPane();
        gridPane.setId("form-grid-spacing");

        inputHikeName = SceneUtils.inputTextField("form-field");

        final Label hikeNameLabel = new Label("Enter Hike Name for Avg heart rate: ");

        heartLabel = new Label("Average Heart Rate: ");
        final Label getAvgHeartbyHikeName = new Label();
        getAvgHeartbyHikeName.setId("form-field");

        stepLabel = new Label("Average Steps: ");
        final Label getAvgStepsByHikeName = new Label();//this just adds more space to the bottom as far as I can tell?

        gridPane.add(hikeNameLabel, 0, 0);
        gridPane.add(inputHikeName, 1, 0);
        gridPane.add(submitHikeName, 1, 1);

        final VBox vBox = new VBox();
        vBox.setId("avg-data");

        vBox.getChildren().addAll(heartLabel, getAvgHeartbyHikeName, stepLabel, getAvgStepsByHikeName);

        gridPane.add(back, 1, 8);

        contentBox.getChildren().addAll(vBox, gridPane);
        return contentBox;
    }

    private static Button submitButton() {
        final Button submit = new Button("Submit");
        submit.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {

                final int steps = HikeController.getInstance().getNumberOfSteps(inputHikeName.getText());
                updateSteps(steps);
                final int heartRate = HikeController.getInstance()
                                                    .getAverageHeartRateByHikeName(inputHikeName.getText());
                updateHeartRate(heartRate);
            }
        });
        return submit;
    }

    private static void updateSteps(final int steps) {
        stepLabel.setText("Average Steps: " + String.valueOf(steps));
    }

    private static void updateHeartRate(final int heartRate) {
        heartLabel.setText("Average Heart Rate: " + String.valueOf(heartRate));
    }

}
