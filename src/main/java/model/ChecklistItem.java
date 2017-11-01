package model;

public class ChecklistItem {
    private final String item;
    private Boolean active;

    ChecklistItem(final String item, final Boolean active){
        this.item = item;
        this.active =active;
    }

    public String getItem(){
        return item;
    }

    public Boolean getActive() {
        return active;
    }

    public void setActive(boolean active){
        this.active = active;
    }
}
