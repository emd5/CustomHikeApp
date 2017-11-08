package model;

/**
 * This class represents checklist items
 *
 * @author Liz Mahoney
 * @author Jacob Langham
 * @version 1.0
 */
public class ChecklistItem {

    private final String item;

    private Boolean active;

    /**
     * This is the constructor for a checklist item. the default active value is true
     *
     * @param item this is the name of the item
     */
    ChecklistItem(final String item) {
        this.item = item;
        this.active = true;
    }

    /**
     * this gets the item
     *
     * @return the item
     */
    public String getItem() {
        return item;
    }

    /**
     * this gets whether an item is active or not
     *
     * @return the active state of the item
     */
    public Boolean getActive() {
        return active;
    }

    /**
     * this sets whether an item is active
     *
     * @param active the active state of the item
     */
    void setActive(boolean active) {
        this.active = active;
    }
}
