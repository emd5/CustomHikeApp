package model;

import java.util.ArrayList;
import java.util.List;

public class TodoChecklist {

    private List<ChecklistItem> customCheckList = new ArrayList<> ();
    private static DefaultChecklist defaultCheckList = DefaultChecklist.getInstance ();

    public void addItem(String item){

        ChecklistItem checklistItem = new ChecklistItem (item, true);
        customCheckList.add (checklistItem);
    }

    public void removeItem(String item){

        ChecklistItem checklistItem = new ChecklistItem (item, true);

        customCheckList.remove (checklistItem);
    }

    public List<ChecklistItem> getChecklistItems(){

        List<ChecklistItem> items = new ArrayList<> ();
        items.addAll (defaultCheckList.getItems());
        items.addAll (customCheckList);

        return items;
    }



}
