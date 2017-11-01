/*Liz Mahoney & Jacob Langham
 *10/29/17
 * HikeController.java
 * This class is the hike controller which interacts with the model
 */

package controller;

import model.ChecklistItem;
import model.Hike;

import java.util.List;

/**
 * This class is the hike controller which interacts with the model.
 *
 * @author Liz Mahoney
 * @author Jacob Langham
 *
 *@version 1.0
 */
public class HikeController{

    private static List<Hike> hikeList;

    /**
     *
     * @param name a string that represents the hike name
     * @param duration an int value representing the hike duration
     * @param location a string that represents the hike location
     * @param heartbeat an int value that represents the average heartbeat.
     * @param numberOfSteps an int value that represents the number of steps during that hike
     */
    public void addHike(String name , int duration, String location, int heartbeat, int numberOfSteps){
        Hike hike = new Hike (name, duration, location,heartbeat, numberOfSteps);
        hikeList.add (hike);
    }

    /**
     * This method accepts a string retrieves the the name of
     * the hike
     *
     * @param name the hike name
     * @return the name of the hike if found otherwise null
     */
    private Hike getHike(String name){

        for(Hike hike : hikeList){

            if(hike.getName().equals(name)){

                return hike;
            }
        }
        return null;
    }

    /**
     * This method gets the average heartrate by hike name
     * @param name the name of the hike
     * @return the average heart rate
     */
    public int getAverageHeartRateByHikeName(String name){

        Hike hike = getHike (name);

        return hike.getHeartbeat ();
    }

    /**
     *
     * @param name
     * @return
     */
    public int getNumberOfSteps(String name){

        Hike hike = getHike (name);

        return hike.getNumberOfSteps ();
    }

    /**
     *
     * @return
     */
    public String[] getHikeNames(){

        String[] hikeNames = new String[hikeList.size ()];

        for(int i=0; i<hikeList.size() ; i++){
           String name = hikeList.get (i).getName ();
           hikeNames[i] = name;
        }
        return hikeNames;
    }

    /**
     *
     * @param name
     * @return
     */
    public String[] getChecklist(String name){


        Hike hike = getHike (name);
        String[] checklistItems = new String[hike.getTodoChecklist ().size ()];

        for(ChecklistItem item : hike.getTodoChecklist ()){

        }

        return null;

    }




}
