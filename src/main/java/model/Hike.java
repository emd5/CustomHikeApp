package model;


import java.time.LocalDate;
import java.util.List;

public class Hike {


    private final String name;
    private final int duration;
    private final String location;
    private LocalDate date;
    private final Fitness fitness;
    private final TodoChecklist todoChecklist;

    public Hike(final String name, final int duration, final String location, final int heartbeat, final int numberOfSteps){
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
