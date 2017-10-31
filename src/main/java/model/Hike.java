package model;


import java.time.LocalDate;

public class Hike {


    private String name;
    private int duration;
    private String location;
    private LocalDate date;
    private Fitness fitness;
    private TodoChecklist todoChecklist;

    public Hike(String name, int duration, String location, int heartbeat, int numberOfSteps){
        this.name = name;
        this.duration = duration;
        this.location = location;
        this.fitness = new Fitness (heartbeat,numberOfSteps);
    }

    public int getHeartbeat() {
        return fitness.getHeartbeat ();
    }

    public int getNumberOfSteps(){
        return fitness.getNumberOfSteps ();
    }

}
