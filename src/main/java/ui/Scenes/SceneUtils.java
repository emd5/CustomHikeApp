package ui.Scenes;

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

public class SceneUtils {

    public static Label label(final String labelText, final String labelId) {
        final Label label = new Label(labelText);
        label.setId(labelId);
        return label;
    }

    public static TextField inputTextFieldWithLabel(String id) {
        TextField textField = new TextField();
        textField.setId(id);
        final Label label = new Label();
        label.setText(textField.getText());
        return textField;
    }

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

    public static HBox bodyFrame(final VBox bodyContent) {

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

    static Button backButton(final Stage stage, final HikeUI hikeUI) {
        //final AnchorPane anchorPane = new AnchorPane();

        final Button goBack = new Button("Go Back");
        goBack.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                stage.setScene(hikeUI.homeScene());

            }
        });

        // anchorPane.getChildren().addAll(goBack);
        return goBack;
    }

    static Scene makeBasicScene(final Text headerText, final VBox bodyContent, final Text footerText, final Stage stage,
                                final HikeUI hikeUI) {
        final VBox mainFrame = SceneUtils.mainFrame();
        final HBox header = SceneUtils.headingFrame(headerText);

        final Button backButton = SceneUtils.backButton(stage, hikeUI);
        //final AnchorPane anchorBodyContent = SceneUtils.bodyFrame (bodyContent);
        final HBox body = SceneUtils.bodyFrame(bodyContent);
        final HBox footer = SceneUtils.footerFrame(footerText);

        mainFrame.getChildren().addAll(header, body, footer);
        mainFrame.getStylesheets().addAll("css/hike.css");

        return new Scene(mainFrame, hikeUI.getWindowWidth(), hikeUI.getWindowHeight());
    }
}
