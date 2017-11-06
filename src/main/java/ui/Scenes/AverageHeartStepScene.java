package ui.Scenes;

import javafx.scene.Scene;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import ui.HikeUI;

public class AverageHeartStepScene {

    private static final Text headerText = new Text("Average Heart and Steps");

    private static final Text footerText = new Text("footer");

    public static Scene averageHeartStepScene(final Stage stage, final HikeUI hikeUI) {

        return SceneUtils.makeBasicScene(headerText, footerText, stage, hikeUI);
    }
}
