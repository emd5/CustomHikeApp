package model.Exit;

import java.io.File;
import java.io.IOException;
import java.time.LocalDate;
import java.util.List;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ObjectWriter;

import controller.HikeController;
import model.Hike;

public class ExitData {

    private final ObjectMapper objectMapper;

    public ExitData(final ObjectMapper objectMapper) {
        this.objectMapper = objectMapper;
    }

    public void exit(final List<Hike> hikeList, final String saveFile) {
        final Hike hike = new Hike("first hike", "firstHikeLoc");
        hike.setDate(LocalDate.now());
        hike.setDuration(500);
        hike.setFitness(50, 1000);
        HikeController.getInstance().addHike(hike);

        final JsonNode node = objectMapper.convertValue(hikeList, JsonNode.class);
        try {
            saveJsonNodeToFile(node, saveFile);
        } catch (final IOException e) {
            System.out.println("something went wrong in exit ");
            e.printStackTrace();
        }
    }

    private void saveJsonNodeToFile(final JsonNode data, final String saveFile) throws IOException {
        final ObjectWriter writer = objectMapper.writer();
        writer.writeValue(new File(saveFile), data);
    }
}
