package controller;

import java.util.ArrayList;
import java.util.List;

import model.Reminder;

/**
 * This class is the controller that interacts with the model for all reminder interactions
 *
 * @author Liz Mahoney
 * @author Jacob Langham
 * @version 1.0
 */
public class ReminderController {

    private static List<Reminder> reminders;
    private static int counter = 0;
    private static ReminderController reminderController;

    private ReminderController(){
        reminders = new ArrayList<> ();
        setup ();
    }

    private void setup(){
        final String[] messageList = new String[]
                {"Stop Eating", "Go workout",
                 "Be sure to stretch", "Wear your fitbit" };

        for(String message : messageList){
          addReminder (message);
        }
    }

    /**
     * this function adds a reminder to the list
     *
     * @param message the message for the reminder
     */
    public void addReminder(final String message){
        final Reminder reminder = new Reminder (message);
        reminders.add (reminder);
    }

    /**
     * this function gets a reminder
     *
     * @return the reminder message
     */
    public String getReminder(){
        if(counter > reminders.size ()){
            counter = 0;
        }

        return  reminders.get(counter++).getMessage();
    }

    /**
     * this provides singleton access to a reminder controller
     *
     * @return the reminder controller
     */
    public static ReminderController getInstance(){
        if(reminderController == null){
            reminderController = new ReminderController ();
        }

        return reminderController;
    }
}
