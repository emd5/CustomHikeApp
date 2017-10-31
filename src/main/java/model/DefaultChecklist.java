package model;

import java.util.ArrayList;
import java.util.List;

public class DefaultChecklist {

    private static List<ChecklistItem> items;
    private static DefaultChecklist defaultChecklist;


    private void setup(){

        String[] defaultItems = new String[]
                {"backpack", "food", "water",
                        "compass", "flash light", "binoculars"};

        for(String item : defaultItems){
            ChecklistItem checklistItem =
                    new ChecklistItem (item, true);
            items.add (checklistItem);
        }
    }

    private DefaultChecklist(){
        items = new ArrayList<> ();
        setup();
    }

    public List<ChecklistItem> getItems() {
        return items;
    }

    public static DefaultChecklist getInstance(){

        if(defaultChecklist == null){

            defaultChecklist = new DefaultChecklist ();

        }

        return defaultChecklist;
    }


}
