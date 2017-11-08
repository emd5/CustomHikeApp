package controller;

import model.Reminder;

import java.util.ArrayList;
import java.util.List;

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

    public void addReminder(final String message){
        final Reminder reminder = new Reminder (message);
        reminders.add (reminder);
    }

    /**
     * Retrieves one reminder.
     * @return one
     *
     */
    public Reminder getReminder(){
        if(counter > reminders.size ()){
            counter = 0;
        }
        return  reminders.get(counter++);
    }

    /**
     * Retrieves a list of reminders
     *
     * @return a string of reminders
     */
    public String[] getAllReminders(){

        String[] reminderList = new String [reminders.size ()];
        for(int i=0; i< reminders.size (); i++){
            final String reminder = reminders.get (i).getMessage ();
            reminderList[i] = reminder;
        }
        return reminderList;
    }


    public static ReminderController getInstance(){
        if(reminderController == null){
            reminderController = new ReminderController ();
        }

        return reminderController;
    }


}
