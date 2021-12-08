package login.sign_in;

import gui.ButtonCommandInterface;
import gui.GeneralGUIMakerInterface;

public class ResetCommand implements ButtonCommandInterface {
    GeneralGUIMakerInterface generalGUIMakerInterface;

    public ResetCommand(GeneralGUIMakerInterface generalGUIMakerInterface) {
        this.generalGUIMakerInterface = generalGUIMakerInterface;
    }

    public void apply(){
        generalGUIMakerInterface.resetFields();
    }
}
