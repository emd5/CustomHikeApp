package controller;

import model.Reminder;

import java.util.ArrayList;
import java.util.List;

public class ReminderController {

    private static List<Reminder> reminders;
    private int counter = 0;


    public void setup(){

        String[] messageList = new String[]
                {"Stop Eating", "Go workout",
                 "Be sure to stretch", "Wear your fitbit" };

        for(String message : messageList){

          addReminder (message);
        }


    }


    public ReminderController(){

        reminders = new ArrayList<> ();
        setup ();

    }

    public void addReminder(String message){

        Reminder reminder = new Reminder (message);

        reminders.add (reminder);

    }

    public Reminder getReminder(){

        if(counter > reminders.size ()){
            counter = 0;
        }

        return  reminders.get (counter++);
    }
}
