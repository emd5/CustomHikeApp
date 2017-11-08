package ui.Scenes;

import controller.HikeController;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.image.ImageView;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Region;
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

    private static final ImageView backgroundImage = new ImageView("bgimages/forest.jpg");

    private static TextField hikeNameField;

    private static TextField checklistItemNameField;

    private static List<String> checklist = new ArrayList<>();

    public static Scene addChecklistScene(final Stage stage, final HikeUI hikeUI) {
        final Button back = SceneUtils.backButton(stage, hikeUI);
        final Button hikeSubmit = hikeSubmitButton(stage, hikeUI);
        //hikeSubmit.setAlignment(Pos.CENTER_RIGHT);
        final Button checklistSubmit = checklistSubmitButton(stage, hikeUI);

        return SceneUtils.makeBasicScene(headerText, bodyContent(back, hikeSubmit, checklistSubmit), footerText,
                stage, hikeUI);
    }

    private static VBox bodyContent(final Button back, final Button hikeSubmit, final Button checklistSubmit) {

        final VBox contentBox = new VBox();
       // vBox.setAlignment(Pos.CENTER);

        GridPane gridPane = new GridPane ();
        gridPane.setVgap (5);
        gridPane.setHgap (5);


        //gridPane.setGridLinesVisible (true);

        final HBox hikeBoxForm = new HBox();
        final Label hikeNameLabel = new Label("Hike Name: ");
        hikeNameLabel.setId("form-label");

        hikeNameField = new TextField();
        hikeNameField.setId("form-field");

        hikeBoxForm.getChildren().addAll(hikeNameLabel, hikeNameField);
        gridPane.add(hikeBoxForm, 0,1);
        gridPane.add (hikeSubmit,  3,1);

        final HBox itemChecklistBoxForm = new HBox();
        final Label addItemLabel = new Label("Add Item: ");
        addItemLabel.setId("form-label");

        checklistItemNameField = new TextField();
        checklistItemNameField.setId("form-field");

        itemChecklistBoxForm.getChildren().addAll(addItemLabel, checklistItemNameField);
        gridPane.add(itemChecklistBoxForm, 0,30);
        gridPane.add (checklistSubmit, 3,30);

        checklist.add("one");
        checklist.add("two");
        checklist.add("three");
        checklist.add("four");
        checklist.add("five");
        checklist.add("six");


        ScrollPane scrollBar = new ScrollPane ();
        VBox checklistVframe = new VBox(new Region ());

        scrollBar.setContent (checklistVframe);
        scrollBar.setVbarPolicy (ScrollPane.ScrollBarPolicy.ALWAYS);

       // checklistVframe.setMaxHeight (200);
        checklistVframe.setId ("checklist-frame");
        checklistVframe.setAlignment (Pos.CENTER);

        CheckBox[] boxes = new CheckBox[checklist.size()];

        //add our checkboxes
        for (int i = 0; i < checklist.size(); i++) {
            CheckBox box = new CheckBox(checklist.get(i));
            box.setPrefWidth(200);
            boxes[i] = box;
            boxes[i].setLineSpacing (3);

        }

        checklistVframe.getChildren().addAll(boxes);

        //gridPane.add (checklistVframe,);

        //event handling for checkboxes
        for (int i = 0; i < boxes.length; i++) {
            final CheckBox box = boxes[i];
            box.selectedProperty().addListener(new ChangeListener<Boolean>() {
                @Override
                public void changed(ObservableValue<? extends Boolean> observable, Boolean oldValue, Boolean checked) {
                    if (checked) {
                        //do something with the checkbox we're clicking on
                        box.setText("You clicked me: " + checked);
                        //  HikeController.getInstance ().setCheckListItemToInactive (box.getText ());
                    }
                }
            });
        }


        gridPane.add (checklistVframe,0,6,Integer.MAX_VALUE,20);
        gridPane.add (back, 3,50);

        contentBox.getChildren ().addAll (gridPane);
        return contentBox;
    }

    private static Button hikeSubmitButton(final Stage stage, final HikeUI hikeUI) {

        final Button submit = new Button("Submit");
        submit.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {

                checklist = HikeController.getInstance().getChecklist(hikeNameField.getText());

                stage.setScene(hikeUI.homeScene());
            }
        });
        return submit;
    }

    private static Button checklistSubmitButton(final Stage stage, final HikeUI hikeUI) {

        final Button submit = new Button("Submit");
        submit.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {

                HikeController.getInstance()
                              .addItemToCheckList(hikeNameField.getText(), checklistItemNameField.getText());

                stage.setScene(hikeUI.homeScene());
                //should reloadui scene instead
            }
        });
        return submit;
    }


}
