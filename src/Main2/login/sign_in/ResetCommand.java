package login.sign_in;

import gui.ButtonCommandInterface;
import gui.GeneralGUIInterface;

public class ResetCommand implements ButtonCommandInterface {
    GeneralGUIInterface generalGUIInterface;

    public ResetCommand(GeneralGUIInterface generalGUIInterface) {
        this.generalGUIInterface = generalGUIInterface;
    }

    public void apply(){
        generalGUIInterface.resetFields();
    }
}
