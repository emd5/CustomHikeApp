package ui.Scenes;

import static ui.HikeUI.WINDOW_HEIGHT;
import static ui.HikeUI.WINDOW_WIDTH;

import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.ProgressBar;
import javafx.scene.image.ImageView;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.scene.text.Text;

public class WaitingScene {

    private static final Text text = new Text("Lets Hike!");

    private static final ImageView backgroundImage = new ImageView("progress/boots.jpg");

    public static Scene waitingScene() {
        final VBox vBox = new VBox();
        backgroundImage.setFitHeight(WINDOW_HEIGHT);
        backgroundImage.setFitWidth(WINDOW_WIDTH);

        final ProgressBar progress = new ProgressBar();
        progress.setMaxWidth(WINDOW_WIDTH / 2);
        progress.getStyleClass().add("progress-bar");

        final StackPane stackPane = new StackPane();
        stackPane.setAlignment(progress, Pos.CENTER);
        stackPane.setAlignment(text, Pos.CENTER);
        stackPane.getChildren().addAll(backgroundImage, progress, text);

        vBox.getChildren().addAll(stackPane);
        vBox.getStylesheets().addAll("css/hike.css");

        return new Scene(vBox, WINDOW_WIDTH, WINDOW_HEIGHT);
    }
}
