package model;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import model.JacksonSerializers.LocalDateDeserializer;
import model.JacksonSerializers.LocalDateSerializer;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class Hike {

    private final String name;

    private int duration;

    private final String location;

    private final Fitness fitness;

    private final TodoChecklist todoChecklist;

    @JsonDeserialize(using = LocalDateDeserializer.class)
    @JsonSerialize(using = LocalDateSerializer.class)
    private LocalDate date;

    public Hike(final String name, final String location, LocalDate date) {
        this.name = name;
        this.duration = 0;
        this.location = location;
        this.date = date;
        this.fitness = new Fitness();
        this.todoChecklist = new TodoChecklist();
    }

    public List<ChecklistItem> getTodoChecklist() {
        return new ArrayList<>(todoChecklist.getChecklistItems());
    }

    public int getHeartbeat() {
        return fitness.getHeartbeat();
    }

    public int getNumberOfSteps() {
        return fitness.getNumberOfSteps();
    }

    public String getName() {
        return name;
    }

    public String getLocation() {
        return location;
    }

    public int getDuration() {
        return duration;
    }

    public LocalDate getDate() {
        return this.date;
    }

    public void setFitness(int heartbeat, int numberOfSteps) {
        this.fitness.setHeartbeat(heartbeat);
        this.fitness.setNumberOfSteps(numberOfSteps);
    }

    public void setDuration(int duration) {
        this.duration = duration;
    }

    //public String[] activeItems
}
