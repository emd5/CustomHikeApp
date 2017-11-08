package controller;

import java.util.List;

import com.fasterxml.jackson.databind.ObjectMapper;

import model.Exit.ExitData;
import model.Hike;
import model.Startup.StartupData;

public class ProgramStatusController {

    private static final String SAVE_FILE = "src/main/resources/hikeList.txt";

    private static final ObjectMapper objectMapper = new ObjectMapper();

    public void exit() {
        final List<Hike> hikeList = HikeController.getInstance().getHikeList();
        ExitData exitData = new ExitData(objectMapper);
        exitData.exit(hikeList, SAVE_FILE);
    }

    public void start() {
        StartupData startupData = new StartupData(objectMapper);
        startupData.loadSavedData(SAVE_FILE);
        HikeController.getInstance().getHikeList();
    }
}
