package ui.Scenes;

import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.ProgressBar;
import javafx.scene.image.ImageView;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.scene.text.Text;
import ui.HikeUI;

public class WaitingScene {

    private static final Text text = new Text("Lets Hike!");

    private static final ImageView backgroundImage = new ImageView("progress/boots.jpg");

    public static Scene waitingScene(HikeUI hikeUI) {
        final VBox vBox = new VBox();
        backgroundImage.setFitHeight(hikeUI.getWindowHeight());
        backgroundImage.setFitWidth(hikeUI.getWindowWidth());

        final ProgressBar progress = new ProgressBar();
        progress.setMaxWidth(hikeUI.getWindowWidth() / 2);
        progress.getStyleClass().add("progress-bar");

        final StackPane stackPane = new StackPane();
        StackPane.setAlignment(progress, Pos.CENTER);
        StackPane.setAlignment(text, Pos.CENTER);
        stackPane.getChildren().addAll(backgroundImage, progress, text);

        vBox.getChildren().addAll(stackPane);
        vBox.getStylesheets().addAll("css/hike.css");

        return new Scene(vBox, hikeUI.getWindowWidth(), hikeUI.getWindowHeight());
    }
}
