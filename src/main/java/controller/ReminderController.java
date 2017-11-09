/*Liz Mahoney & Jacob Langham
 *11/6/17
 *ReminderScene.java
 */

package controller;

import java.util.ArrayList;
import java.util.List;

import model.Reminder;

public class ReminderController {

    private static List<Reminder> reminders;

    private static int counter = 0;

    private static ReminderController reminderController;

    private ReminderController() {
        reminders = new ArrayList<>();
        setup();
    }

    private void setup() {
        final String[] messageList = new String[] { "Stop Eating", "Go Workout", "Wear your Fitbit" };
        for (final String message : messageList) {
            addReminder(message);
        }
    }

    public void addReminder(final String message) {
        final Reminder reminder = new Reminder(message);
        reminders.add(reminder);
    }

    public Reminder getReminder() {
        if (counter >= reminders.size()) {
            counter = 0;
        }

        return reminders.get(counter++);
    }

    /**
     * Get a list of reminder messages
     *
     * @return a list of reminder messages
     */
    public List<String> getReminderList() {
        final List<String> reminderMessages = new ArrayList<>();
        for (final Reminder reminder : reminders) {
            reminderMessages.add(reminder.getMessage());
        }
        return reminderMessages;

    }

    /**
     * this provides singleton access to the reminder controller
     *
     * @return the reminder controller
     */
    public static ReminderController getInstance() {
        if (reminderController == null) {
            reminderController = new ReminderController();
        }

        return reminderController;
    }

}
