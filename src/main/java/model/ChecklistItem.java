package model;

public class ChecklistItem {

    private String item;
    private Boolean active;

    public ChecklistItem(String item, Boolean active){
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
