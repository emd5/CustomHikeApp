
package ui;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.stage.Stage;




/**
 * This class builds the Hike interface
 *
 * @author Liz Mahoney
 * @author Jacob Langham
 * @version 1.0
 */
public class HikeUI extends Application {

    public static HBox hBox;
    public static VBox vBox;
    public static GridPane gridPane;
    public static final int WINDOW_WIDTH = 400;
    public static final int WINDOW_HEIGHT = 500;



    @Override
    public void start(Stage stage) {

        // window and Hike log features.
        stage.setTitle ("Hike Log Application");
        stage.setScene (assemble());
        //stage.setResizable (false);
        stage.show ();
    }

    private Scene assemble(){
        layout ();
//        createButtons ();
//        addButtons ();
//        eventHandling ();
        return new Scene(gridPane, WINDOW_WIDTH, WINDOW_HEIGHT);
    }

    private static void layout(){

        gridPane = new GridPane ();

        //set spacing around elements
        gridPane.setHgap(20);
        gridPane.setVgap(10);
        gridPane.setPadding(new Insets (10));

        HBox hBox1 = new HBox ();
        hbox1.getStyleClass().add("hbox");
        hBox1.setBorder (new Border (new BorderStroke (Color.BLACK, BorderStrokeStyle.SOLID, CornerRadii.EMPTY, BorderWidths.DEFAULT) ));
        gridPane.add (hBox1, 300, 400 );


    }

    private static void createButtons(){

    }

    private static void addButtons(){

    }



    private static void eventHandling(){

    }

}


