package model;


import java.time.LocalDate;
import java.util.List;

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
        this.todoChecklist = new TodoChecklist ();
    }

    public List<ChecklistItem> getTodoChecklist() {
        return todoChecklist.getChecklistItems ();
    }

    public int getHeartbeat() {
        return fitness.getHeartbeat ();
    }

    public int getNumberOfSteps(){
        return fitness.getNumberOfSteps ();
    }

    public String getName() {
        return name;
    }

    //public String[] activeItems

}
