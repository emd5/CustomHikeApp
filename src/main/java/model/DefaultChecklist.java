package model;

import java.util.ArrayList;
import java.util.List;

/**
 * This class is the default list of checklist items
 *
 * @author Liz Mahoney
 * @author Jacob Langham
 * @version 1.0
 */
class DefaultChecklist {

    private static List<ChecklistItem> items;

    private static DefaultChecklist defaultChecklist;

    private void setup() {
        final String[] defaultItems = new String[] { "backpack", "food", "water", "compass", "flash light",
                "binoculars" };

        for (final String item : defaultItems) {
            final ChecklistItem checklistItem = new ChecklistItem(item);
            items.add(checklistItem);
        }
    }

    private DefaultChecklist() {
        items = new ArrayList<>();
        setup();
    }

    /**
     * This gets the list of checklist items
     *
     * @return the list of items
     */
    List<ChecklistItem> getItems() {
        return items;
    }

    /**
     * this provides singleton access to the default checklist
     *
     * @return the default list of items
     */
    static DefaultChecklist getInstance() {
        if (defaultChecklist == null) {
            defaultChecklist = new DefaultChecklist();
        }

        return defaultChecklist;
    }
}
