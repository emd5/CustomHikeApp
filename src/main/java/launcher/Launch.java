/*
 *
 */
package launcher;

import controller.ProgramStatusController;
import javafx.application.Application;
import ui.HikeUI;

/**
 *
 */
public class Launch {

    /**
     * This is the entry point of the program
     *
     * @param args command-line arguments
     * @author Liz Mahoney
     * @author Jacob Langham
     * @version 1.0
     */
    public static void main(String[] args) {

        final ProgramStatusController programStatusController = new ProgramStatusController();
        programStatusController.start();
        Application.launch(HikeUI.class, args);
    }
}
