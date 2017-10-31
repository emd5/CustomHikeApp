package controller;

import model.Reminder;

import java.util.ArrayList;
import java.util.List;

public class ReminderController {

    private static List<Reminder> reminders;
    private static int counter = 0;

    static {
        reminders = new ArrayList<> ();
        setup ();
    }

    public static void setup(){

        String[] messageList = new String[]
                {"Stop Eating", "Go workout",
                 "Be sure to stretch", "Wear your fitbit" };

        for(String message : messageList){

          addReminder (message);
        }


    }


    public static void addReminder(String message){

        Reminder reminder = new Reminder (message);

        reminders.add (reminder);

    }

    public static Reminder getReminder(){

        if(counter > reminders.size ()){
            counter = 0;
        }

        return  reminders.get (counter++);
    }
}
