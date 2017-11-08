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

public class AddHeartRateScene {

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
        contentBox.setId (PADDING_10);

        final GridPane gridPane = new GridPane ();
        gridPane.setId("form-grid-spacing");

        final Label hikeLabel = new Label ("Hike Name: ");
        hikeLabel.setId("form-label");

        hikeText = new TextField();
        hikeText.setId("form-field");
        final Label hikeField = new Label ();
        hikeField.setText (hikeText.getText ());

        final Label heartLabel = new Label("Heart Rate: ");
        heartLabel.setId("form-label");

        heartText = new TextField();
        heartText.setId("form-field");
        final Label heartField = new Label ();
        heartField.setText (heartText.getText ());


        gridPane.add (hikeLabel, 0,0);
        gridPane.add (hikeText, 1,0);
        gridPane.add (heartLabel,0,1);
        gridPane.add (heartText, 1,1);
        gridPane.add (back, 1,20);
        gridPane.add(submit, 1,2);


        contentBox.getChildren ().addAll (gridPane);

        return contentBox;
    }

    private static Button submitButton(final Stage stage, final HikeUI hikeUI ) {
        final Button submit = new Button("Submit");
        submit.setOnAction(new EventHandler<ActionEvent> () {
            @Override
            public void handle(ActionEvent event) {

                HikeController.getInstance().addHeartRateForHike
                        (hikeText.getText (), Integer.parseInt (heartText.getText ()));
                stage.setScene(hikeUI.homeScene());
            }
        });
        return submit;
    }

}
