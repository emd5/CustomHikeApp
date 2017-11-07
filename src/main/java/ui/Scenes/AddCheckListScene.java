package ui.Scenes;

import controller.HikeController;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.image.ImageView;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import ui.HikeUI;

import java.util.ArrayList;
import java.util.List;

public class AddCheckListScene {

    private static final Text headerText = new Text("Add Checklist");

    private static final Text footerText = new Text("footer");

    private static final String PADDING_10 = "padding10";

    private static final ImageView backgroundImage =
            new ImageView("bgimages/forest.jpg");
    private static TextField hikeNameField;
    private static TextField checklistItemNameField;
    private static List<String> checklist = new ArrayList<> ();

    public static Scene addChecklistScene(final Stage stage, final HikeUI hikeUI) {
        checklist.add ("one");
        checklist.add ("two");
        checklist.add ("three");

        CheckBox[] boxes = new CheckBox[checklist.size ()];
        VBox vbox = new VBox();
        vbox.setPadding(new Insets (10));
        vbox.setAlignment(Pos.CENTER);
        vbox.setSpacing(10);

        //add our checkboxes
        for (int i = 0; i < checklist.size (); i++) {
            CheckBox box = new CheckBox(checklist.get (i));
            boxes[i] = box;
            box.setPrefWidth(200);
        }
        vbox.getChildren().addAll(boxes);

        for (int i = 0; i < boxes.length; i++) {
            final CheckBox box = boxes[i];

            box.selectedProperty().addListener(new ChangeListener<Boolean> () {
                @Override
                public void changed(ObservableValue<? extends Boolean> observable,
                                    Boolean oldValue, Boolean checked) {
                    if (checked) {
                        //do something with the checkbox we're clicking on
                        box.setText("You clicked me: " + checked);
                        HikeController.getInstance ().setCheckListItemToInactive (box.getText ());
                    }
                }
            });
        }

        Button back = SceneUtils.backButton (stage, hikeUI);
        Button hikeSubmit = hikeSubmitButton (stage, hikeUI);
        Button checklistSubmit = checklistSubmitButton (stage, hikeUI);

        return SceneUtils.makeBasicScene(headerText, bodyContent (back, vbox, hikeSubmit, checklistSubmit),footerText, stage, hikeUI);
    }

    private static VBox bodyContent(Button back, VBox vBox, Button hikeSubmit, Button checklistSubmit){

        VBox contentBox = new VBox ();

        final HBox rows = new HBox();
        rows.setId(PADDING_10);

        final Label hikeNameLabel = new Label("Enter Hike Name:");
        hikeNameLabel.setId("form-label");

        hikeNameField = new TextField();
        hikeNameField.setId("form-field");


        final Label nameLabel = new Label("Add Item:");
        nameLabel.setId("form-label");

        checklistItemNameField = new TextField();
        checklistItemNameField.setId("form-field");


        rows.getChildren().addAll(hikeNameLabel, hikeNameField, nameLabel, checklistItemNameField, back);
        contentBox.getChildren ().addAll (hikeSubmit, checklistSubmit, rows, vBox);

        return contentBox;
    }

    private static Button hikeSubmitButton(final Stage stage, final HikeUI hikeUI ) {
        final Button submit = new Button("Submit");
        submit.setOnAction(new EventHandler<ActionEvent> () {
            @Override
            public void handle(ActionEvent event) {

                checklist = HikeController.getInstance().getChecklist (hikeNameField.getText ());

                stage.setScene(hikeUI.homeScene());
            }
        });
        return submit;
    }

    private static Button checklistSubmitButton(final Stage stage, final HikeUI hikeUI ) {
        final Button submit = new Button("Submit");
        submit.setOnAction(new EventHandler<ActionEvent> () {
            @Override
            public void handle(ActionEvent event) {

                HikeController.getInstance().addItemToCheckList(hikeNameField.getText (), checklistItemNameField.getText ());

                stage.setScene(hikeUI.homeScene());
                //should reloadui scene instead
            }
        });
        return submit;
    }
}
