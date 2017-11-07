package ui.Scenes;/*
 *Liz Mahoney
 *11/6/17
 *ViewChecklistScene.java
 */

import javafx.scene.Scene;
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


        return SceneUtils.makeBasicScene(headerText, footerText, stage, hikeUI);
    }
}
