package ui.Scenes;

import javafx.scene.Scene;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import ui.HikeUI;

public class HeartScene {

    private final static Text headerText = new Text("Add heart rate");

    private final static Text footerText = new Text("footer");

    public static Scene addHeartScene(final Stage stage, final HikeUI hikeUI) {
        return SceneUtils.makeBasicScene(headerText, footerText, stage, hikeUI);
    }

}
