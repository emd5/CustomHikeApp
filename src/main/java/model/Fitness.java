package model;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;

import model.JacksonSerializers.FitnessDeserializer;

/**
 * this class stores fitness details for a hike
 *
 * @author Liz Mahoney
 * @author Jacob Langham
 * @version 1.0
 */
@JsonDeserialize(using = FitnessDeserializer.class)
public class Fitness {

    private int heartbeat;

    private int numberOfSteps;

    /**
     * the constructor for fitness
     */
    public Fitness() {
        this.heartbeat = 0;
        this.numberOfSteps = 0;
    }

    /**
     * this gets the heartbeat rate for a hike
     *
     * @return the heartbeat
     */
    public int getHeartbeat() {
        return heartbeat;
    }

    /**
     * this gets the number of steps a hike took
     *
     * @return the number of steps
     */
    public int getNumberOfSteps() {
        return numberOfSteps;
    }

    /**
     * this sets the heartbeat rate for a hike
     *
     * @param heartbeat the heartbeat rate
     */
    public void setHeartbeat(final int heartbeat) {
        this.heartbeat = heartbeat;
    }

    /**
     * this sets the number of steps in a hike
     *
     * @param numberOfSteps the number of steps
     */
    public void setNumberOfSteps(final int numberOfSteps) {
        this.numberOfSteps = numberOfSteps;
    }
}
