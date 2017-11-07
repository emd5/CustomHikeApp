package model;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;

import model.JacksonSerializers.LocalDateDeserializer;
import model.JacksonSerializers.LocalDateSerializer;

public class Hike {

    private final String name;

    private int duration;

    private final String location;

    private final Fitness fitness;

    private final TodoChecklist todoChecklist;

    @JsonDeserialize(using = LocalDateDeserializer.class)
    @JsonSerialize(using = LocalDateSerializer.class)
    private LocalDate date;

    public Hike(final String name, final String location, final LocalDate date) {
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

    public void setDuration(final int duration) {
        this.duration = duration;
    }

    public void setHeartBeat(final int heartBeat) {
        this.fitness.setHeartbeat(heartBeat);
    }

    public void setNumberOfSteps(final int numberOfSteps) {
        this.fitness.setNumberOfSteps(numberOfSteps);
    }

    public void addChecklistItem(final String item){
        this.todoChecklist.addItem(item);
    }

    public void setChecklistItemToInactive(final String item) {
        this.todoChecklist.setItemToInactive(item);
    }

    //public String[] activeItems
}
