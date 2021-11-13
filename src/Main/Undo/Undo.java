package Undo;

import java.util.ArrayList;
import java.util.HashMap;

/**
 Entity class to allow storage of objects to allow the ability to undo.
 This class takes in Objects as the user inputs them, so if they decide they would like to undo
 what they have inputed, the variables are easily overriten.
 */
public class Undo {
    ArrayList<String> states; // A list of all of the states of when we ask a user to input data to create a Entity;
    HashMap<String,Object> data;// This is filled in when we ask for data from the user
    int current_state; // The id of the state that needs to be initialized next
    /**
     Initializer for the Undo Class
     */
    public Undo(){
        this.current_state = 0;
        this.data = new HashMap<>();
        this.states = new ArrayList<>();
    }

    /**
     method to undo a input given by the user
     Will only undo if the current state of the program isnt 0. It undos by rewriting the
     data Hashmap of the previous state, the one that was just entered by the user,
     */
    public void undo(){
        if (current_state != 0){
            this.data.put(this.states.get(this.current_state - 1),"");
            this.current_state = this.current_state - 1;
        }
    }

    /**
     *
     * @param dataPoint can be any object that needs to be entered.
     */
    public void setDataPoint(Object dataPoint){
        if(!this.isComplete()) {
            this.data.put(this.states.get(this.current_state), dataPoint);
            this.current_state = this.current_state + 1;
        }
    }

    /**
     * Getter for the data that has been accumulated by this class
     * @return A hashmap with all of the data associated to each state.
     */
    public HashMap<String,Object> get_Data(){
        return this.data;
    }

    /**
     * A method to return if all of the data has been collected
     * @return true if its complete, false if its not
     */
    public boolean isComplete(){
        return this.current_state == this.states.size();
    }

    /**
     * Getter for the current state
     * @return Returns a unique string of the current state that the class that is using this
     * class will ask for the users input based on what string is returned.
     */
    public String getCurrentState() { return this.states.get(this.current_state);}

    /**
     * Setter for a specific state in the program
     * @param state is unique
     */
    public void addState(String state){
        this.states.add(state);
    }

    /**
     * Setter for a specific entry in the hashmap, adds dataname as a key in the hashmap
     * with an empty string as what it refers to.
     * @param dataname exists or will exist in this.states
     */
    public void addData(String dataname){
        this.data.put(dataname,"");
    }
}

