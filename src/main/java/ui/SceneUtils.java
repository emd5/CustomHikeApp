package ui;

import static ui.HikeUI.WINDOW_HEIGHT;
import static ui.HikeUI.WINDOW_WIDTH;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.text.Text;
import javafx.stage.Stage;

public class SceneUtils {

    public static VBox mainFrame() {

        VBox mainFrame = new VBox();
        mainFrame.setId("mainFrame");

        return mainFrame;
    }

    public static HBox headingFrame(Text headingContent) {

        HBox headingFrame = new HBox();
        headingFrame.setId("headingFrame");
        headingFrame.getChildren().add(headingContent);

        return headingFrame;
    }

    public static HBox bodyFrame(AnchorPane bodyContent) {

        HBox bodyFrame = new HBox();
        bodyFrame.setId("bodyFrame");
        bodyFrame.getChildren().add(bodyContent);

        return bodyFrame;
    }

    public static HBox footerFrame(Text footerContent) {

        HBox footerFrame = new HBox();

        footerFrame.setId("footerFrame");
        footerFrame.getChildren().addAll(footerContent);
        return footerFrame;
    }

    public static AnchorPane backButton(Stage stage, HikeUI hikeUI) {

        AnchorPane anchorPane = new AnchorPane();

        Button goBack = new Button("Go Back");
        goBack.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                stage.setScene(hikeUI.homeScene());

            }
        });

        anchorPane.getChildren().addAll(goBack);
        return anchorPane;
    }

    public static Scene makeBasicScene(Text headerText, Text footerText, Stage stage, HikeUI hikeUI) {
        final VBox mainFrame = SceneUtils.mainFrame();
        final HBox header = SceneUtils.headingFrame(headerText);

        final AnchorPane anchorPane = SceneUtils.backButton(stage, hikeUI);
        final HBox body = SceneUtils.bodyFrame(anchorPane);

        final HBox footer = SceneUtils.footerFrame(footerText);

        mainFrame.getChildren().addAll(header, body, footer);
        mainFrame.getStylesheets().addAll("css/hike.css");

        return new Scene(mainFrame, WINDOW_WIDTH, WINDOW_HEIGHT);
    }
}
