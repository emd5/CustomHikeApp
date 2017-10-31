package model;


public class Fitness {

    private int heartbeat;
    private int numberOfSteps;


    public Fitness(int heartbeat, int numberOfSteps){
        this.heartbeat = heartbeat;
        this.numberOfSteps = numberOfSteps;

    }

    public int getHeartbeat(){
        return heartbeat;
    }

    public int getNumberOfSteps(){
        return  numberOfSteps;
    }


}
