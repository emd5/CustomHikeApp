package ui;

import static ui.HikeUI.WINDOW_HEIGHT;
import static ui.HikeUI.WINDOW_WIDTH;
import static ui.SceneUtils.backButton;
import static ui.SceneUtils.bodyFrame;
import static ui.SceneUtils.footerFrame;
import static ui.SceneUtils.headingFrame;
import static ui.SceneUtils.mainFrame;

import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.text.Text;
import javafx.stage.Stage;

public class CheckListScene {

    private static final Text headerText = new Text("Add Checklist");

    private static final Text footerText = new Text("footer");

    public static Scene addChecklistScene(final Stage stage, final HikeUI hikeUI) {
        final VBox mainFrame = mainFrame();
        final HBox header = headingFrame(headerText);

        final AnchorPane anchorPane = backButton(stage, hikeUI);
        final HBox body = bodyFrame(anchorPane);

        final HBox footer = footerFrame(footerText);

        mainFrame.getChildren().addAll(header, body, footer);
        mainFrame.getStylesheets().addAll("css/hike.css");

        return new Scene(mainFrame, WINDOW_WIDTH, WINDOW_HEIGHT);
    }
}
