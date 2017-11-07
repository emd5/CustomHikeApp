package ui.Scenes;

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

public class ViewHikeScene {

    private static final Text headerText = new Text("View all Hikes");

    private static final Text footerText = new Text("footer");

    public static Scene viewHikeScene(final Stage stage, final HikeUI hikeUI) {

        Button back = SceneUtils.backButton (stage,hikeUI);

        return SceneUtils.makeBasicScene(headerText, bodyContent(back), footerText, stage, hikeUI);
    }

    private static VBox bodyContent(Button back){

        String[] hikeNames = HikeController.getInstance ().getHikeNames ();

        VBox hikeViewList = new VBox();
        hikeViewList.setId ("view-hikeList");

        ListView hikeList = new ListView();

        ObservableList<String> items =
                FXCollections.observableArrayList(hikeNames);

        hikeList.getItems().addAll(items);
        hikeViewList.getChildren().addAll (hikeList, back);

        return hikeViewList;
    }
}
