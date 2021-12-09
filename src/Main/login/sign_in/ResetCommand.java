package login.sign_in;

import gui.ButtonCommandInterface;
import gui.GeneralGUIMakerInterface;

/**
 * Class that allows the action of Resetting (mainly buttons) in the program
 */

public class ResetCommand implements ButtonCommandInterface {
    GeneralGUIMakerInterface generalGUIMakerInterface;

    /**
     * Constructor for this class
     * @param generalGUIMakerInterface takes in an instance of generalGUIMakerInterface
     */
    public ResetCommand(GeneralGUIMakerInterface generalGUIMakerInterface) {
        this.generalGUIMakerInterface = generalGUIMakerInterface;
    }

    /**
     * Method that resets specific fields (calls method of the GeneralGUIMakerInterface
     */
    public void apply(){
        generalGUIMakerInterface.resetFields();
    }
}
