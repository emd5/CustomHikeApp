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

/**
 * this class has several functions for creating scenes
 *
 * @author Liz Mahoney
 * @author Jacob Langham
 * @version 1.0
 */
public class SceneUtils {

    /**
     * This creates a Label
     *
     * @param labelText the labels text
     * @param labelId   the labels id
     * @return the label
     */
    static Label label(final String labelText, final String labelId) {
        final Label label = new Label(labelText);
        label.setId(labelId);
        return label;
    }

    /**
     * This creates a textfield
     *
     * @param id the textfields id
     * @return the textfield
     */
    static TextField inputTextField(final String id) {
        final TextField textField = new TextField();
        textField.setId(id);
        return textField;
    }

    /**
     * this creates a VBox
     *
     * @return the vbox
     */
    public static VBox mainFrame() {
        final VBox mainFrame = new VBox();
        mainFrame.setId("mainFrame");

        return mainFrame;
    }

    /**
     * this creates a heading HBox
     *
     * @param headingContent the heading text
     * @return the hbox
     */
    public static HBox headingFrame(final Text headingContent) {
        final HBox headingFrame = new HBox();
        headingFrame.setId("headingFrame");
        headingFrame.getChildren().add(headingContent);

        return headingFrame;
    }

    /**
     * this creates a bodyframe HBox
     *
     * @param bodyContent the bodyframe content
     * @return the hbox
     */
    public static HBox bodyFrame(final VBox bodyContent) {

        final HBox bodyFrame = new HBox();
        bodyFrame.setId("bodyFrame");
        bodyFrame.getChildren().add(bodyContent);

        return bodyFrame;
    }

    /**
     * this creates a footer hbox
     *
     * @param footerContent the footer content
     * @return the hbox
     */
    public static HBox footerFrame(final Text footerContent) {
        final HBox footerFrame = new HBox();
        footerFrame.setId("footerFrame");

        footerFrame.getChildren().addAll(footerContent);
        return footerFrame;
    }

    /**
     * this creates a back button
     *
     * @param stage  the stage the button belongs to
     * @param hikeUI the hike ui the button belongs to
     * @return the button
     */
    static Button backButton(final Stage stage, final HikeUI hikeUI) {
        final Button goBack = new Button("Go Back");
        goBack.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                stage.setScene(hikeUI.homeScene());

            }
        });

        return goBack;
    }

    /**
     * this makes a basic scene
     *
     * @param headerText  the text for the header
     * @param bodyContent the content for the body
     * @param footerText  the text for the footer
     * @param stage       the stage the scene belongs to
     * @param hikeUI      the hikeui the scene belongs to
     * @return the scene
     */
    static Scene makeBasicScene(final Text headerText, final VBox bodyContent, final Text footerText, final Stage stage,
                                final HikeUI hikeUI) {
        final VBox mainFrame = SceneUtils.mainFrame();
        final HBox header = SceneUtils.headingFrame(headerText);

        final Button backButton = SceneUtils.backButton(stage, hikeUI);
        final HBox body = SceneUtils.bodyFrame(bodyContent);
        final HBox footer = SceneUtils.footerFrame(footerText);

        mainFrame.getChildren().addAll(header, body, footer);
        mainFrame.getStylesheets().addAll("css/hike.css");

        return new Scene(mainFrame, hikeUI.getWindowWidth(), hikeUI.getWindowHeight());
    }
}
