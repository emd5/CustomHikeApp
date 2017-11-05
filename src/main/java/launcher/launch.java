package launcher;

import controller.ExitController;
import javafx.application.Application;
import ui.HikeUI;

public class launch {

    /**
     * This is the entry point of the program which allows to test
     * the calculator ui class.
     *
     * @param args command-line arguments
     */
    public static void main(String[] args) {
        Application.launch(HikeUI.class, args);
        ExitController exitController = new ExitController();
        //exitController.exit();
        //exitController.start();
    }
}
