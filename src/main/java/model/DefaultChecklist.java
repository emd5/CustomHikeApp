package model;

import java.util.ArrayList;
import java.util.List;

class DefaultChecklist {
    private static List<ChecklistItem> items;
    private static DefaultChecklist defaultChecklist;

    private void setup(){
        final String[] defaultItems = new String[]
                {"backpack", "food", "water",
                        "compass", "flash light", "binoculars"};

        for(final String item : defaultItems){
            final ChecklistItem checklistItem = new ChecklistItem (item);
            items.add (checklistItem);
        }
    }

    private DefaultChecklist(){
        items = new ArrayList<> ();
        setup();
    }

    List<ChecklistItem> getItems() {
        return items;
    }

    static DefaultChecklist getInstance(){
        if(defaultChecklist == null){
            defaultChecklist = new DefaultChecklist ();
        }

        return defaultChecklist;
    }
}
