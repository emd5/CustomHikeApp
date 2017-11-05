package ui.Scenes;

import javafx.scene.Scene;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import ui.HikeUI;
import ui.SceneUtils;

public class ViewHikeScene {

    private static final Text headerText = new Text("View all Hikes");

    private static final Text footerText = new Text("footer");

    public static Scene viewHikeScene(final Stage stage, final HikeUI hikeUI) {
        return SceneUtils.makeBasicScene(headerText, footerText, stage, hikeUI);
    }
}
