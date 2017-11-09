package ui.Scenes;

import java.util.ArrayList;
import java.util.List;

import controller.HikeController;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.image.ImageView;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import ui.HikeUI;

/**
 * this class creates a check list scene
 *
 * @author Liz Mahoney
 * @author Jacob Langham
 * @version 1.0
 */
public class AddCheckListScene {

    private static final Text headerText = new Text("Add Checklist");

    private static final Text footerText = new Text("footer");

    private static final ImageView backgroundImage = new ImageView("bgimages/forest.jpg");

    private static TextField hikeNameField;

    private static TextField checklistItemNameField;

    private static List<String> checklist = new ArrayList<>();

    /**
     * creates a checklist scene
     *
     * @param stage  the stage to use
     * @param hikeUI the hikeui to use
     * @return the scene
     */
    public static Scene addChecklistScene(final Stage stage, final HikeUI hikeUI) {
        final Button back = SceneUtils.backButton(stage, hikeUI);
        final Button hikeSubmit = hikeSubmitButton(stage, hikeUI);
        final Button checklistSubmit = checklistSubmitButton(stage, hikeUI);
        final VBox bodyContent = bodyContent(back, hikeSubmit, checklistSubmit);

        return SceneUtils.makeBasicScene(headerText, bodyContent, footerText, stage, hikeUI);
    }

    private static VBox bodyContent(final Button back, final Button hikeSubmit, final Button checklistSubmit) {
        final VBox contentBox = new VBox();

        final GridPane gridPane = new GridPane();
        gridPane.setVgap(5);
        gridPane.setHgap(5);
        gridPane.setPrefHeight(100);

        final HBox hikeBoxForm = new HBox();
        final Label hikeNameLabel = new Label("Hike Name: ");
        hikeNameLabel.setId("form-label");

        hikeNameField = new TextField();
        hikeNameField.setId("form-field");

        hikeBoxForm.getChildren().addAll(hikeNameLabel, hikeNameField);
        gridPane.add(hikeBoxForm, 0, 1);
        gridPane.add(hikeSubmit, 3, 1);

        final HBox itemChecklistBoxForm = new HBox();
        final Label addItemLabel = new Label("Add Item: ");
        addItemLabel.setId("form-label");

        checklistItemNameField = new TextField();
        checklistItemNameField.setId("form-field");

        itemChecklistBoxForm.getChildren().addAll(addItemLabel, checklistItemNameField);
        gridPane.add(itemChecklistBoxForm, 0, 15);
        gridPane.add(checklistSubmit, 3, 20);

        final VBox checklistVframe = new VBox();

        checklistVframe.setId("checklist-frame");
        checklistVframe.setAlignment(Pos.CENTER);

        final CheckBox[] boxes = new CheckBox[checklist.size()];

        for (int i = 0; i < checklist.size(); i++) {
            final CheckBox box = new CheckBox(checklist.get(i));
            box.setPrefWidth(200);
            boxes[i] = box;
            boxes[i].setLineSpacing(3);
        }

        checklistVframe.getChildren().addAll(boxes);

        for (int i = 0; i < boxes.length; i++) {
            final CheckBox box = boxes[i];
            box.selectedProperty().addListener(new ChangeListener<Boolean>() {
                @Override
                public void changed(ObservableValue<? extends Boolean> observable, final Boolean oldValue,
                                    final Boolean checked) {
                    if (checked) {
                        box.setText(box.getText() + " done!");
                        HikeController.getInstance().setCheckListItemToInactive(hikeNameField.getText(), box.getText());
                    }
                }
            });
        }

        gridPane.add(checklistVframe, 0, 3);
        gridPane.add(back, 3, 35);

        contentBox.getChildren().addAll(gridPane);
        return contentBox;
    }

    private static Button hikeSubmitButton(final Stage stage, final HikeUI hikeUI) {
        final Button submit = new Button("Submit");
        submit.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(final ActionEvent event) {
                checklist = HikeController.getInstance().getChecklist(hikeNameField.getText());
                stage.setScene(AddCheckListScene.addChecklistScene(stage, hikeUI));
            }
        });
        return submit;
    }

    private static Button checklistSubmitButton(final Stage stage, final HikeUI hikeUI) {

        final Button submit = new Button("Submit");
        submit.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(final ActionEvent event) {
                HikeController.getInstance()
                              .addItemToCheckList(hikeNameField.getText(), checklistItemNameField.getText());

                stage.setScene(hikeUI.homeScene());
            }
        });
        return submit;
    }

}
