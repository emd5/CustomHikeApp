package model;

public class Reminder {
    private final String message;

    public Reminder(final String message){
        this.message = message;
    }

    public String getMessage(){
        return message;
    }
}
