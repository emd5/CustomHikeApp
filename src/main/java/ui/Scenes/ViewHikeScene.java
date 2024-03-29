package ui.Scenes;

import java.util.List;

import controller.HikeController;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ListView;
import javafx.scene.layout.VBox;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import ui.HikeUI;

/**
 * this class creates a view hike scene
 *
 * @author Liz Mahoney
 * @author Jacob Langham
 * @version 1.0
 */
public class ViewHikeScene {

    private static final Text headerText = new Text("View all Hikes");

    private static final Text footerText = new Text("");

    /**
     * creates a view hike scene
     *
     * @param stage  the stage to use
     * @param hikeUI the hikeui to use
     * @return the scene
     */
    public static Scene viewHikeScene(final Stage stage, final HikeUI hikeUI) {
        final Button back = SceneUtils.backButton(stage, hikeUI);
        return SceneUtils.makeBasicScene(headerText, bodyContent(back), footerText, stage, hikeUI);
    }

    private static VBox bodyContent(final Button back) {
        final List<String> hikes = HikeController.getInstance().getHikeToString();

        final VBox hikeViewList = new VBox();
        hikeViewList.setId("view-hikeList");
        final ListView hikeList = new ListView();
        final ObservableList<String> items = FXCollections.observableArrayList(hikes);

        hikeList.getItems().addAll(items);
        hikeViewList.getChildren().addAll(hikeList, back);

        return hikeViewList;
    }
}
