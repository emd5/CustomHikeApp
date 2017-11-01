package model;


class Fitness {
    private final int heartbeat;
    private final int numberOfSteps;

    Fitness(final int heartbeat, final int numberOfSteps){
        this.heartbeat = heartbeat;
        this.numberOfSteps = numberOfSteps;
    }

    int getHeartbeat(){
        return heartbeat;
    }

    int getNumberOfSteps(){
        return  numberOfSteps;
    }
}
