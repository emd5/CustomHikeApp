package ui.Scenes;

import javafx.scene.Scene;
import javafx.scene.image.ImageView;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import ui.HikeUI;

public class CheckListScene {

    private static final Text headerText = new Text("Add Checklist");

    private static final Text footerText = new Text("footer");

    private static final ImageView backgroundImage =
            new ImageView("bgimages/forest.jpg");
    public static Scene addChecklistScene(final Stage stage, final HikeUI hikeUI) {

        return SceneUtils.makeBasicScene(headerText, footerText, stage, hikeUI);
    }
}
