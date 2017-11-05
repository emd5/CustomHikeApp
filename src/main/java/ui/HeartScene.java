package ui;

import static ui.HikeUI.WINDOW_HEIGHT;
import static ui.HikeUI.WINDOW_WIDTH;

import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.text.Text;
import javafx.stage.Stage;

public class HeartScene {

    private final static Text headerText = new Text("Add heart rate");

    private final static Text footerText = new Text("footer");

    public static Scene addHeartScene(final Stage stage, final HikeUI hikeUI) {

        final VBox mainFrame = SceneUtils.mainFrame();
        final HBox header = SceneUtils.headingFrame(headerText);

        AnchorPane anchorPane = SceneUtils.backButton(stage, hikeUI);
        final HBox body = SceneUtils.bodyFrame(anchorPane);

        final HBox footer = SceneUtils.footerFrame(footerText);

        mainFrame.getChildren().addAll(header, body, footer);
        mainFrame.getStylesheets().addAll("css/hike.css");

        return new Scene(mainFrame, WINDOW_WIDTH, WINDOW_HEIGHT);
    }

}
