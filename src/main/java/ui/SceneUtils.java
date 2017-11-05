package ui;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
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
}
