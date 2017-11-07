/*Liz Mahoney & Jacob Langham
 *10/29/17
 * HikeController.java
 * This class is the hike controller which interacts with the model
 */

package controller;

import model.ChecklistItem;
import model.Hike;

import java.util.ArrayList;
import java.util.List;

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
     * @param name     a string that represents the hike name
     * @param location a string that represents the hike location
     */
    public void addHike(final String name, final String location) {

        final Hike hike = new Hike(name, location);
        hikeList.add(hike);
    }

    public void addHike(final Hike hike) {
        hikeList.add(hike);
    }

    /**
     * This method accepts a string retrieves the the name of
     * the hike
     *
     * @param name the hike name
     * @return the name of the hike if found otherwise null
     */
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
     * @param name
     * @return
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
        }
        return hikeNames;
    }

    /**
     * @param name
     * @return
     */
    public String[] getChecklist(final String name) {
        final Hike hike = getHike(name);
        final List<ChecklistItem> checklist = hike.getTodoChecklist();
        final String[] checklistItems = new String[checklist.size()];

        for (int i = 0; i < checklist.size(); i++) {
            checklistItems[i] = checklist.get(i).getItem();
        }

        return checklistItems;
    }

    List<Hike> getHikeList() {
        return new ArrayList<>(hikeList);
    }

    public static HikeController getInstance() {
        if (hikeController == null) {
            hikeController = new HikeController();
        }

        return hikeController;
    }
}
