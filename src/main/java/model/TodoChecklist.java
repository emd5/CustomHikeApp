package model;

import java.util.ArrayList;
import java.util.List;

/**
 * this class is the to do checklist
 *
 * @author Liz Mahoney
 * @author Jacob Langham
 * @version 1.0
 */
class TodoChecklist {

    private final List<ChecklistItem> customCheckList = new ArrayList<>();

    TodoChecklist() {
        customCheckList.addAll(DefaultChecklist.getInstance().getItems());
    }

    /**
     * this adds an item to the checklist
     *
     * @param item
     */
    void addItem(final String item) {
        final ChecklistItem checklistItem = new ChecklistItem(item);
        customCheckList.add(checklistItem);
    }

    /**
     * this gets the list of checklist items
     *
     * @return the list of checklist items
     */
    List<ChecklistItem> getChecklistItems() {
        final List<ChecklistItem> items = new ArrayList<>();
        items.addAll(customCheckList);

        return items;
    }

    /**
     * sets an item to inactive
     *
     * @param item the item name
     */
    void setItemToInactive(final String item) {
        for (ChecklistItem checklistItem : customCheckList) {
            if (checklistItem.getItem().equals(item)) {
                checklistItem.setActive(false);
            }
        }
    }
}
