package model;

import java.util.ArrayList;
import java.util.List;

class TodoChecklist {

    private final List<ChecklistItem> customCheckList = new ArrayList<>();

    private final static DefaultChecklist defaultCheckList = DefaultChecklist.getInstance();

    void addItem(final String item) {
        final ChecklistItem checklistItem = new ChecklistItem(item);
        customCheckList.add(checklistItem);
    }

    List<ChecklistItem> getChecklistItems() {
        final List<ChecklistItem> items = new ArrayList<>();
        items.addAll(defaultCheckList.getItems());
        items.addAll(customCheckList);

        return items;
    }

    void setItemToInactive(final String item) {
        boolean done = false;
        if(!findItemInList(defaultCheckList.getItems(), item)){
            if(!findItemInList(customCheckList, item)){
                //error handling
            }
        }
    }

    private boolean findItemInList(final List<ChecklistItem> checklist, final String item){
        for (final ChecklistItem checklistItem : checklist) {
            if(checklistItem.getItem().equals(item)){
                checklistItem.setActive(false);
                return true;
            }
        }
        return false;
    }
}
