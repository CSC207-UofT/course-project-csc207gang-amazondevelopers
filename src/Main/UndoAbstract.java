import java.util.ArrayList;
import java.util.HashMap;
import java.util.Objects;

/*
Abstract class for different types of data storage when creating users,products etc, so we can easily allow the user
to undo
 */
public class UndoAbstract {
    ArrayList<String> states; // A list of all of the states of when we ask a user to input data to create a Entity;
    HashMap<String,Object> data;// This is filled in when we ask for data from the user
    int current_state; // The id of the state that needs to be initialized next
    Object represents; // Attribute to use when we create the item
    /*
    Initializer, parameters, for each item in this.states, there is a element in this.data of the form <states[x],"">.
     */
    public UndoAbstract(){
        this.current_state = 0;
        this.data = new HashMap<String,Object>();
        this.states = new ArrayList<String>();
        }
      /*
    method to undo a input given by the user, returns true when an input can be undone, returns false when there
    is no inputs to undo;
     */
    public boolean undo(){
        if (current_state != 0){
            this.data.get(this.states.get(this.current_state - 1)) = "";
            this.current_state = this.current_state - 1;
            return true;
        }
        else{
            return false;
        }
    }
    public void setDataPoint(Object dataPoint){
        this.data[states.get(this.current_state)] = dataPoint;
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
    public void set_Represents(Object rep){
        this.represents = rep;
    }
}


