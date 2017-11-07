package ui.Scenes;

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

public class HeartScene {

    private final static Text headerText = new Text("Add heart rate");

    private final static Text footerText = new Text("footer");

    private static final String PADDING_10 = "padding10";

    private static TextField hikeText;
    private static TextField heartText;

    public static Scene addHeartScene(final Stage stage, final HikeUI hikeUI) {

        Button back = SceneUtils.backButton (stage,hikeUI);
        Button submit = submitButton (stage,hikeUI);
        VBox bodyContent = bodyContent (back, submit);

        return SceneUtils.makeBasicScene(headerText,  bodyContent, footerText, stage, hikeUI);
    }

    private static VBox bodyContent(Button back, Button submit){

        VBox contentBox= new VBox ();

        final HBox row1 = new HBox();
        row1.setId(PADDING_10);

        final Label hikeLabel = new Label ("Hike Name: ");
        hikeLabel.setId("form-label");

        final Label hikeField = new Label ();
        hikeText = new TextField();
        hikeField.setText (hikeText.getText ());
        hikeField.setId("form-field");

        final Label formLabel = new Label("Enter HeartRate");
        formLabel.setId("form-label");

        final Label formField = new Label ();
        heartText = new TextField();
        formField.setText (heartText.getText ());
        formField.setId("form-field");

        contentBox.getChildren ().addAll (formLabel,formField,hikeText,heartText, submit);

        row1.getChildren ().add(contentBox);
        return contentBox;
    }

    private static Button submitButton(final Stage stage, final HikeUI hikeUI ) {
        final Button submit = new Button("Submit");
        submit.setOnAction(new EventHandler<ActionEvent> () {
            @Override
            public void handle(ActionEvent event) {

                HikeController.getInstance().addHeartRateForHike (hikeText.getText (), Integer.parseInt (heartText.getText ()));

                 stage.setScene(hikeUI.homeScene());
            }
        });
        return submit;
    }

}
