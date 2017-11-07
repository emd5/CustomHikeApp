package ui.Scenes;/*
 *Liz Mahoney
 *11/6/17
 *ReminderScene.java
 */

import javafx.scene.Scene;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import ui.HikeUI; /**
 * @author Liz Mahoney
 * @version 1.0
 */
public class ReminderScene {

    private static final Text headerText = new Text("Add/Remove reminders");

    private static final Text footerText = new Text("footer");


    public static Scene reminderScene(Stage stage, HikeUI hikeUI) {

        return SceneUtils.makeBasicScene(headerText, footerText, stage, hikeUI);
    }
}
