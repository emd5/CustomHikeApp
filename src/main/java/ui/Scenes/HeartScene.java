package ui.Scenes;

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

    public static Scene addHeartScene(final Stage stage, final HikeUI hikeUI) {

        Button back = SceneUtils.backButton (stage,hikeUI);

        return SceneUtils.makeBasicScene(headerText,  bodyContent (back), footerText, stage, hikeUI);
    }

    private static VBox bodyContent(Button back){

        VBox contentBox= new VBox ();

        final HBox row1 = new HBox();
        row1.setId(PADDING_10);

        final Label nameLabel = new Label("Enter HeartRate");
        nameLabel.setId("form-label");

        final TextField nameField = new TextField();
        nameField.setId("form-field");


        row1.getChildren().addAll(nameLabel, nameField, back);
        contentBox.getChildren ().add (row1);

        return contentBox;
    }

}
