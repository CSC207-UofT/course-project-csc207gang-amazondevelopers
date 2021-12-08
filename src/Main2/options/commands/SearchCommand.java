package options.commands;

import gui.ButtonCommandInterface;
import gui.GUIFactory;
import gui.GUIFactoryInterface;

import javax.swing.*;
import java.io.IOException;

public class SearchCommand implements ButtonCommandInterface {
    JFrame frame;
    public SearchCommand(JFrame frame) {
        this.frame = frame;
    }

    @Override
    public void apply() throws IOException, ClassNotFoundException {
        frame.dispose();
        GUIFactory guiFactory = new GUIFactory();
        GUIFactoryInterface guiFrame = guiFactory.getFrame("SEARCH");
        guiFrame.createGUI();
    }
}
