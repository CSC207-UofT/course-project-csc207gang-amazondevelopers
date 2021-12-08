package options.commands;

import gui.ButtonCommandInterface;
import gui.GUIFactory;
import gui.GUIFactoryInterface;
import options.search.SearchGUIMaker;
import user.User;

import javax.swing.*;
import java.io.IOException;

public class ScrollSearchCommand implements ButtonCommandInterface {
    JFrame frame;
    User user;
    SearchGUIMaker searchGUIMaker;

    public ScrollSearchCommand(JFrame frame, User user, SearchGUIMaker searchGUIMaker) {
        this.frame = frame;
        this.user = user;
        this.searchGUIMaker = searchGUIMaker;
    }

    @Override
    public void apply() throws IOException, ClassNotFoundException {
        try {
            GUIFactory guiFactory = new GUIFactory(this.user, searchGUIMaker.searchBar.getText());
            GUIFactoryInterface guiFrame = guiFactory.getFrame("SCROLLSEARCH");
            guiFrame.createGUI();
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }
        frame.dispose();
    }
}
