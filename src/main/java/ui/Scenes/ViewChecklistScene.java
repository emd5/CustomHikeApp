package ui.Scenes;/*
 *Liz Mahoney
 *11/6/17
 *ViewChecklistScene.java
 */

import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.VBox;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import ui.HikeUI;

/**
 * @author Liz Mahoney
 * @version 1.0
 */
public class ViewChecklistScene {

    private static final Text headerText = new Text("View CheckList");
    private static final Text footerText = new Text("footer");

    private static final String PADDING_10 = "padding10";


    public static Scene viewChecklistScene(Stage stage, HikeUI hikeUI) {

        Button back = SceneUtils.backButton (stage,hikeUI);
        return SceneUtils.makeBasicScene(headerText, bodyContent(back), footerText, stage, hikeUI);
    }

    private static VBox bodyContent(Button back){

        VBox bodyContent = new VBox ();

        final GridPane addItemPane = new GridPane ();
        final TextField itemField = new TextField ();

        itemField.setPromptText ("Add an item");


        addItemPane.getChildren ().add (itemField);
        bodyContent.getChildren ().addAll(addItemPane, back);
        return bodyContent;
    }

    //method to display addItemPane

    //method for display list of items

    private static VBox displayChecklist(){


        VBox vBox = new VBox ();

        vBox.getChildren().addAll ();
        return vBox;
    }




}
