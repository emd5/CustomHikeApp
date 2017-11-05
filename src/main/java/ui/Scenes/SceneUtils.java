package ui.Scenes;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import ui.HikeUI;

public class SceneUtils {

    public static VBox mainFrame() {
        final VBox mainFrame = new VBox();
        mainFrame.setId("mainFrame");

        return mainFrame;
    }

    public static HBox headingFrame(final Text headingContent) {
        final HBox headingFrame = new HBox();
        headingFrame.setId("headingFrame");
        headingFrame.getChildren().add(headingContent);

        return headingFrame;
    }

    public static HBox bodyFrame(final AnchorPane bodyContent) {
        final HBox bodyFrame = new HBox();
        bodyFrame.setId("bodyFrame");
        bodyFrame.getChildren().add(bodyContent);

        return bodyFrame;
    }

    public static HBox footerFrame(final Text footerContent) {
        final HBox footerFrame = new HBox();

        footerFrame.setId("footerFrame");
        footerFrame.getChildren().addAll(footerContent);
        return footerFrame;
    }

    static AnchorPane backButton(final Stage stage, final HikeUI hikeUI) {
        final AnchorPane anchorPane = new AnchorPane();

        final Button goBack = new Button("Go Back");
        goBack.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                stage.setScene(hikeUI.homeScene());

            }
        });

        anchorPane.getChildren().addAll(goBack);
        return anchorPane;
    }

    static Scene makeBasicScene(final Text headerText, final Text footerText, final Stage stage, final HikeUI hikeUI) {
        final VBox mainFrame = SceneUtils.mainFrame();
        final HBox header = SceneUtils.headingFrame(headerText);

        final AnchorPane anchorPane = SceneUtils.backButton(stage, hikeUI);
        final HBox body = SceneUtils.bodyFrame(anchorPane);

        final HBox footer = SceneUtils.footerFrame(footerText);

        mainFrame.getChildren().addAll(header, body, footer);
        mainFrame.getStylesheets().addAll("css/hike.css");

        return new Scene(mainFrame, hikeUI.getWindowWidth(), hikeUI.getWindowHeight());
    }
}
