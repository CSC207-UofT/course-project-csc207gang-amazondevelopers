package options.commands;

import gui.ButtonCommandInterface;
import gui.GUIFactory;
import gui.GUIFactoryInterface;

import java.io.IOException;

public class PostCommand implements ButtonCommandInterface {
    @Override
    public void apply() throws IOException, ClassNotFoundException {
        GUIFactory guiFactory = new GUIFactory();
        GUIFactoryInterface guiFrame = guiFactory.getFrame("POST");
        guiFrame.createGUI();
    }
}
