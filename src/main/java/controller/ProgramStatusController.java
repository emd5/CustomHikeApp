package controller;

import java.util.List;

import com.fasterxml.jackson.databind.ObjectMapper;

import model.Exit.ExitData;
import model.Hike;
import model.Startup.StartupData;

/**
 * This class is the controller that loads a programs saved data from a file and saves a programs data
 * to a file
 *
 * @author Liz Mahoney
 * @author Jacob Langham
 * @version 1.0
 */
public class ProgramStatusController {

    private static final String SAVE_FILE = "src/main/resources/hikeList.txt";

    private static final ObjectMapper objectMapper = new ObjectMapper();

    /**
     * this saves data to a file
     */
    public void exit() {
        final List<Hike> hikeList = HikeController.getInstance().getHikeList();
        final ExitData exitData = new ExitData(objectMapper);
        exitData.exit(hikeList, SAVE_FILE);
    }

    /**
     * this loads data from a file
     */
    public void start() {
        final StartupData startupData = new StartupData(objectMapper);
        List<Hike> hikeList = startupData.loadSavedData(SAVE_FILE);
        for (Hike hike : hikeList) {
            HikeController.getInstance().addHike(hike);
        }
    }
}
