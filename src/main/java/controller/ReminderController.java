package controller;

import model.Reminder;

import java.util.ArrayList;
import java.util.List;
import java.util.ListIterator;

public class ReminderController {

    private static List<Reminder> reminders;
    private static ListIterator<Reminder> iterator;

    public ReminderController(){

        reminders = new ArrayList<> ();
        iterator = reminders.listIterator ();

    }

    public void addReminder(String message){

        Reminder reminder = new Reminder (message);

        reminders.add (reminder);

    }

    public Reminder getReminder(){

        return  iterator.next ();
    }
}
