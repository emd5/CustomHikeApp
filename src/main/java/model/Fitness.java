package model;

class Fitness {

    private int heartbeat;

    private int numberOfSteps;

    Fitness() {
        this.heartbeat = 0;
        this.numberOfSteps = 0;
    }

    int getHeartbeat() {
        return heartbeat;
    }

    int getNumberOfSteps() {
        return numberOfSteps;
    }

    void setHeartbeat(final int heartbeat) {
        this.heartbeat = heartbeat;
    }

    void setNumberOfSteps(final int numberOfSteps) {
        this.numberOfSteps = numberOfSteps;
    }
}
