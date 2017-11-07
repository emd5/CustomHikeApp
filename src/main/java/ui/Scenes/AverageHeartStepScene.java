package ui.Scenes;

import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import ui.HikeUI;

public class AverageHeartStepScene {

    private static final Text headerText = new Text("Average Heart and Steps");

    private static final Text footerText = new Text("footer");

    private static final String PADDING_10 = "padding10";

    public static Scene averageHeartStepScene(final Stage stage, final HikeUI hikeUI) {
        Button back = SceneUtils.backButton (stage, hikeUI);
        return SceneUtils.makeBasicScene(headerText, bodyContent (back), footerText, stage, hikeUI);
    }

    private static VBox bodyContent(Button back){
        VBox vBox = new VBox ();
        vBox.setAlignment (Pos.CENTER_RIGHT);
        HBox rows = new HBox ();



        final Label heartLabel = new Label("Average Heart Rate: ");
        final Label stepLabel = new Label("Average Steps: ");

        vBox.getChildren().addAll(heartLabel,stepLabel, back);
        rows.getChildren ().add(vBox);

        return vBox;
    }

}
