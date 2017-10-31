package controller;

import model.Reminder;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;


class ReminderControllerTest {

    private static ReminderController controller;

    @BeforeEach
    void setUp() {

        controller = new ReminderController ();



    }

    @AfterEach
    void tearDown() {



    }

    @Test
    void addTest(){
        ReminderController controller = new ReminderController ();
        Reminder controllerReminder = controller.getReminder ();

        Reminder reminder = new Reminder ("Stop Eating");

        assertEquals(reminder.getMessage (), controllerReminder.getMessage ());
    }


}