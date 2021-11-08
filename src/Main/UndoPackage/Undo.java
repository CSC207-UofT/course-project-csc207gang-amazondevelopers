package UndoPackage;

import java.util.ArrayList;
import java.util.HashMap;

/*
Abstract class for different types of data storage when creating users,products etc, so we can easily allow the user
to undo
 */
public class Undo {
    ArrayList<String> states; // A list of all of the states of when we ask a user to input data to create a Entity;
    HashMap<String,Object> data;// This is filled in when we ask for data from the user
    int current_state; // The id of the state that needs to be initialized next
    /*
    Initializer, parameters, for each item in this.states, there is a element in this.data of the form <states[x],"">.
     */
    public Undo(){
        this.current_state = 0;
        this.data = new HashMap<String,Object>();
        this.states = new ArrayList<String>();
        }
      /*
    method to undo a input given by the user, returns true when an input can be undone, returns false when there
    is no inputs to undo;
     */
    public void undo(){
        if (current_state != 0){
            this.data.put(this.states.get(this.current_state - 1),"");
            this.current_state = this.current_state - 1;
        }
    }
    public void setDataPoint(Object dataPoint){
        this.data.put(this.states.get(this.current_state),dataPoint);
        this.current_state = this.current_state + 1;
    }

    public HashMap<String,Object> get_Data(){
        return this.data;
    }

    public boolean isComplete(){
        if (this.current_state == this.states.size() - 1){
            return true;
        }
        else{
            return false;
        }
    }

    public String get_Current_State() { return this.states.get(this.current_state);}

    public void add_state(String state){
        this.states.add(state);
    }
    public void add_data(String dataname){
        this.data.put(dataname,"");
    }
}


