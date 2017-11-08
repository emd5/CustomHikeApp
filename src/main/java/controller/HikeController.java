/*Liz Mahoney & Jacob Langham
 *10/29/17
 * HikeController.java
 * This class is the hike controller which interacts with the model
 */

package controller;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import model.ChecklistItem;
import model.Hike;

/**
 * This class is the hike controller which interacts with the model.
 *
 * @author Liz Mahoney
 * @author Jacob Langham
 * @version 1.0
 */
public class HikeController {

    private static List<Hike> hikeList;

    private static HikeController hikeController;

    private HikeController() {
        hikeList = new ArrayList<>();
    }

    /**
     * This function adds a hike to the list of hikes
     *
     * @param name     represents the hike name
     * @param location represents the hike location
     * @param date     represents the date of the hike
     */
    public void addHike(final String name, final String location, final LocalDate date) {

        final Hike hike = new Hike(name, location, date);
        hikeList.add(hike);
    }

    /**
     * this function adds a hike
     *
     * @param hike the hike object
     */
    public void addHike(final Hike hike) {
        hikeList.add(hike);
    }

    private Hike getHike(final String name) {
        for (final Hike hike : hikeList) {
            if (hike.getName().equals(name)) {
                return hike;
            }
        }
        return null;
    }

    /**
     * This method gets the average heartrate by hike name
     *
     * @param name the name of the hike
     * @return the average heart rate
     */
    public int getAverageHeartRateByHikeName(final String name) {
        final Hike hike = getHike(name);
        return hike.getHeartbeat();
    }

    /**
     * Get the number of steps for a hike
     *
     * @param name the hike name
     * @return the number of steps
     */
    public int getNumberOfSteps(final String name) {
        final Hike hike = getHike(name);
        return hike.getNumberOfSteps();
    }

    /**
     * @return
     */
    public String[] getHikeNames() {
        final String[] hikeNames = new String[hikeList.size()];

        for (int i = 0; i < hikeList.size(); i++) {
            final String name = hikeList.get(i).getName();
            hikeNames[i] = name;
        }
        return hikeNames;
    }

    /**
     * This function gets a list of the names of items in a checklist
     *
     * @param name the name of the hike
     * @return a list of checklist item names
     */
    public List<String> getChecklist(final String name) {
        final Hike hike = getHike(name);
        final List<ChecklistItem> checklist = hike.getTodoChecklist();
        final List<String> newChecklist = new ArrayList<>();

        for (final ChecklistItem item : checklist) {
            newChecklist.add(item.getItem());
        }
        return newChecklist;
    }

    /**
     * Get a list of hikes
     *
     * @return a list of hikes
     */
    List<Hike> getHikeList() {
        return new ArrayList<>(hikeList);
    }

    /**
     * this provides singleton access to the hike controller
     *
     * @return the hike controller
     */
    public static HikeController getInstance() {
        if (hikeController == null) {
            hikeController = new HikeController();
        }

        return hikeController;
    }

    /**
     * adds a heart rate for a hike
     *
     * @param name      the name of the hike
     * @param heartRate the heart rate
     */
    public void addHeartRateForHike(final String name, final int heartRate) {
        getHike(name).setHeartBeat(heartRate);
    }

    /**
     * adds number of steps for a hike
     *
     * @param name  the name of the hike
     * @param steps the number of steps
     */
    public void addStepsForHike(final String name, final int steps) {
        getHike(name).setNumberOfSteps(steps);
    }

    /**
     * adds an item to a hikes checklist
     *
     * @param name the name of the hike
     * @param item the name of the item
     */
    public void addItemToCheckList(final String name, final String item) {
        getHike(name).addChecklistItem(item);
    }

    public void setCheckListItemToInactive(String name, String item) {
        getHike(name).setChecklistItemToInactive(item);
    }
}
