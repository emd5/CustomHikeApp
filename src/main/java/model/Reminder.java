package model;

/**
 * this class is the reminder
 *
 * @author Liz Mahoney
 * @author Jacob Langham
 * @version 1.0
 */
public class Reminder {
    private final String message;

    /**
     * This is the reminder constructor
     *
     * @param message the message of the reminder
     */
    public Reminder(final String message){
        this.message = message;
    }

    /**
     * gets the message of the reminder
     *
     * @return the message
     */
    public String getMessage(){
        return message;
    }
}
