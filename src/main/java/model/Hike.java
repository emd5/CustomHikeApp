package model;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;

import model.JacksonSerializers.LocalDateDeserializer;
import model.JacksonSerializers.LocalDateSerializer;

/**
 * This class is a hike
 *
 * @author Liz Mahoney
 * @author Jacob Langham
 * @version 1.0
 */
public class Hike {

    private final String name;

    private int duration;

    private final String location;

    private final Fitness fitness;

    private final TodoChecklist todoChecklist;

    @JsonDeserialize(using = LocalDateDeserializer.class)
    @JsonSerialize(using = LocalDateSerializer.class)
    private final LocalDate date;

    /**
     * This is the hike constructor which sets the default duration to 0
     *
     * @param name     the name of the hike
     * @param location the location of the hike
     * @param date     the date of the hike
     */
    public Hike(final String name, final String location, final LocalDate date) {
        this.name = name;
        this.duration = 0;
        this.location = location;
        this.date = date;
        this.fitness = new Fitness();
        this.todoChecklist = new TodoChecklist();
    }

    /**
     * this gets the to do checklist for a hike
     *
     * @return the list of checklist items
     */
    public List<ChecklistItem> getTodoChecklist() {

        return new ArrayList<>(todoChecklist.getChecklistItems());
    }

    /**
     * this gets the heartbeat for a hike
     *
     * @return the heartbeat
     */
    public int getHeartbeat() {
        return fitness.getHeartbeat();
    }

    /**
     * this gets the number of steps for a hike
     *
     * @return the number of steps
     */
    public int getNumberOfSteps() {

        return fitness.getNumberOfSteps();
    }

    /**
     * this gets the name for a hike
     *
     * @return the name
     */
    public String getName() {
        return name;
    }

    /**
     * this sets the duration of the hike
     *
     * @param duration the duration
     */
    public void setDuration(final int duration) {

        this.duration = duration;
    }

    /**
     * this sets the heartbeat rate of a hike
     *
     * @param heartBeat the heartbeat
     */
    public void setHeartBeat(final int heartBeat) {

        this.fitness.setHeartbeat(heartBeat);
    }

    /**
     * this sets the number of steps for a hike
     *
     * @param numberOfSteps the number of steps
     */
    public void setNumberOfSteps(final int numberOfSteps) {

        this.fitness.setNumberOfSteps(numberOfSteps);
    }

    /**
     * this adds a checklist item to a hike
     *
     * @param item the item name
     */
    public void addChecklistItem(final String item) {
        this.todoChecklist.addItem(item);
    }

    /**
     * this sets a checklist item to inactive
     *
     * @param item the name of the item
     */
    public void setChecklistItemToInactive(final String item) {

        this.todoChecklist.setItemToInactive(item);
    }

    /**
     * the duration the hike took
     *
     * @return the duration
     */
    public int getDuration() {
        return duration;
    }

    /**
     * the location the hike is at
     *
     * @return the location
     */
    public String getLocation() {
        return location;
    }

    /**
     * gets a fitness object that contains fitness details for the hike
     *
     * @return the fitness object
     */
    public Fitness getFitness() {
        return fitness;
    }

    /**
     * the date the hike happened
     *
     * @return the date
     */
    public LocalDate getDate() {
        return date;
    }

    /**
     * a string representing the hike
     *
     * @return the hikes tostring
     */
    @Override
    public String toString() {
        return "name: " + name + "\nduration: " + duration + "\nlocation: " + location + "\nheartbeat: " +
               getHeartbeat() + "\nsteps: " + getNumberOfSteps() + "\ndate: " + date;
    }
}
