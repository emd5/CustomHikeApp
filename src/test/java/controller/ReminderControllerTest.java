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

        controller = ReminderController.getInstance();
    }

    @AfterEach
    void tearDown() {

    }

    @Test
    void addTest() {
        final String actualReminder = controller.getReminder().getMessage ();
        final Reminder expectedReminder = new Reminder("Stop Eating");
        assertEquals(expectedReminder, actualReminder);
    }
}
