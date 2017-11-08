package model.Startup;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;

import model.Hike;

/**
 * this class saves data to a file
 */
public class StartupData {

    private final ObjectMapper objectMapper;

    /**
     * The constructor for StartupData
     *
     * @param objectMapper an Objectmapper to map data to JsonNodes
     * @author Liz Mahoney
     * @author Jacob Langham
     * @version 1.0
     */
    public StartupData(final ObjectMapper objectMapper) {
        this.objectMapper = objectMapper;
    }

    /**
     * this function loads data from a file
     *
     * @param saveFile name of the file path
     */
    public List<Hike> loadSavedData(final String saveFile) {
        List<Hike> hikeList = new ArrayList<>();
        try {
            final JsonNode savedData = readJsonNodeFromFile(new File(saveFile));
            for (final JsonNode savedHike : savedData) {
                final String name = savedHike.get("name").asText();
                final String location = savedHike.get("location").asText();
                final int duration = extractIntValueFromJson(savedHike, "duration");
                final LocalDate date = extractDateValueFromJson(savedHike, "date");
                final int heartbeat = extractIntValueFromJson(savedHike, "heartbeat");
                final int numberOfSteps = extractIntValueFromJson(savedHike, "numberOfSteps");
                Hike hike = createHike(name, location, duration, date, heartbeat, numberOfSteps);
                hikeList.add(hike);
            }
        } catch (final IOException e) {
            System.out.println("something went wrong in startup");
            e.printStackTrace();
        }
        return hikeList;
    }

    private Hike createHike(final String name, final String location, final int duration, final LocalDate date,
                            final int heartbeat, final int numberOfSteps) {
        final Hike hike = new Hike(name, location, date);
        hike.setHeartBeat(heartbeat);
        hike.setNumberOfSteps(numberOfSteps);
        hike.setDuration(duration);
        return hike;
    }

    private LocalDate extractDateValueFromJson(final JsonNode node, final String field) {
        final JsonNode value = node.get(field);
        if (value.isNull()) {
            return null;
        }
        return LocalDate.parse(value.asText());
    }

    private Integer extractIntValueFromJson(final JsonNode node, final String field) {
        final JsonNode value = node.get(field);
        if (value.isNull()) {
            return 0;
        }
        return Integer.parseInt(value.asText());
    }

    private JsonNode readJsonNodeFromFile(final File file) throws IOException {
        final InputStream inputStream = new FileInputStream(file);
        final String result = readStringFromInputStream(inputStream);
        return objectMapper.readTree(result);
    }

    private String readStringFromInputStream(final InputStream inputStream) throws IOException {
        final StringBuilder readInput = new StringBuilder();
        try (final BufferedReader br = new BufferedReader(new InputStreamReader(inputStream))) {
            String line;
            while ((line = br.readLine()) != null) {
                readInput.append(line);
            }
        }
        return readInput.toString();
    }
}
