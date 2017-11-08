package model.Startup;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import controller.HikeController;
import model.Hike;

import java.io.*;
import java.time.LocalDate;

public class StartupData {

    private final ObjectMapper objectMapper;

    public StartupData(final ObjectMapper objectMapper) {
        this.objectMapper = objectMapper;
    }

    public void loadSavedData(final String saveFile) {
        try {
            final JsonNode savedData = readJsonNodeFromFile(new File(saveFile));
            for (final JsonNode savedHike : savedData) {
                final String name = savedHike.get("name").asText();
                final String location = savedHike.get("location").asText();
                final int duration = extractIntValueFromJson(savedHike, "duration");
                final LocalDate date = extractDateValueFromJson(savedHike, "date");
                final int heartbeat = extractIntValueFromJson(savedHike, "heartbeat");
                final int numberOfSteps = extractIntValueFromJson(savedHike, "numberOfSteps");
                final Hike hike = createHike(name, location, duration, date, heartbeat, numberOfSteps);
                HikeController.getInstance().addHike(hike);
            }
        } catch (final IOException e) {
            System.out.println("something went wrong in startup");
            e.printStackTrace();
        }
    }

    private Hike createHike(final String name, final String location, final int duration, final LocalDate date,
                            final int heartbeat, final int numberOfSteps) {
        final Hike hike = new Hike(name, location,date);
        hike.setDuration(duration);
       // hike.setFitness(heartbeat, numberOfSteps);
        HikeController.getInstance().addHike(hike);
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
