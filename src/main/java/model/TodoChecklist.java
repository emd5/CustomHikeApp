package model;

import java.util.ArrayList;
import java.util.List;

class TodoChecklist {
    private final List<ChecklistItem> customCheckList = new ArrayList<> ();
    private final static DefaultChecklist defaultCheckList = DefaultChecklist.getInstance ();

    public void addItem(final String item){
        final ChecklistItem checklistItem = new ChecklistItem (item);
        customCheckList.add (checklistItem);
    }

    public void removeItem(final String item){
        ChecklistItem checklistItem = new ChecklistItem (item);
        customCheckList.remove (checklistItem);
    }

    List<ChecklistItem> getChecklistItems(){
        final List<ChecklistItem> items = new ArrayList<> ();
        items.addAll (defaultCheckList.getItems());
        items.addAll (customCheckList);

        return items;
    }
}
