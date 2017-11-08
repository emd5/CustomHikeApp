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

    public static Scene averageHeartStepScene(final Stage stage, final HikeUI hikeUI) {
        Button back = SceneUtils.backButton (stage, hikeUI);
        Button submitHikeName = submitButton (stage,hikeUI);

        return SceneUtils.makeBasicScene(headerText,
                bodyContent (back, submitHikeName), footerText, stage, hikeUI);
    }

    private static VBox bodyContent(Button back, Button submitHikeName){
        VBox contentBox = new VBox ();
        contentBox.setId (PADDING_10);

        GridPane gridPane = new GridPane ();
        gridPane.setId("form-grid-spacing");
        //gridPane.setGridLinesVisible (true);

        inputHikeName = new TextField ();
        inputHikeName.setId ("form-field");
        final Label hikeNameLabel = new Label
                ("Enter Hike Name for Avg heart rate: ");
        final Label hikeNameInputLabel = new Label ("");
        hikeNameInputLabel.setText (inputHikeName.getText ());


        final Label heartLabel = new Label("Average Heart Rate: ");
        final Label getAvgHeartbyHikeName = new Label ();
        getAvgHeartbyHikeName.setId ("form-field");

        final Label stepLabel = new Label("Average Steps: ");
        final Label getAvgStepsByHikeName = new Label ();
        final Label getAvgHeartRate = new Label ();
        getAvgHeartRate.setId ("form-field");

        gridPane.add (hikeNameLabel, 0,0);
        gridPane.add (inputHikeName, 1,0);
        gridPane.add (submitHikeName,1,1 );

        VBox vBox = new VBox ();
        vBox.setId ("avg-data");

        vBox.getChildren ().addAll(heartLabel,getAvgHeartbyHikeName
                ,stepLabel,getAvgStepsByHikeName);

        gridPane.add(back, 1,8);
        
        contentBox.getChildren ().addAll (vBox,gridPane);
        return contentBox;
    }

    private static Button submitButton(final Stage stage, final HikeUI hikeUI ) {
        final Button submit = new Button("Submit");
        submit.setOnAction(new EventHandler<ActionEvent> () {
            @Override
            public void handle(ActionEvent event) {

                HikeController.getInstance ().getAverageHeartRateByHikeName (inputHikeName.getText ());
                stage.setScene(hikeUI.homeScene());
            }
        });
        return submit;
    }

}
