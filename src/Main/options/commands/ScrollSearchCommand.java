package options.commands;

import gui.ButtonCommandInterface;
import gui.GUIFactory;
import gui.GUIFactoryInterface;
import options.search.SearchGUIMaker;
import user.User;

import javax.swing.*;

public class ScrollSearchCommand implements ButtonCommandInterface {
    JFrame frame;
    User user;
    SearchGUIMaker searchGUIMaker;

    /**
     * class initializer
     *
     * @param user user logged in
     * @param frame current frame
     * @param searchGUIMaker constructor for search gui
     */

    public ScrollSearchCommand(JFrame frame, User user, SearchGUIMaker searchGUIMaker) {
        this.frame = frame;
        this.user = user;
        this.searchGUIMaker = searchGUIMaker;
    }

    /**
     * Creates the scroll search panel in search
     */
    @Override
    public void apply(){
        GUIFactory guiFactory = new GUIFactory(this.user, searchGUIMaker.searchBar.getText());
        GUIFactoryInterface guiFrame = guiFactory.getFrame("SCROLLSEARCH");
        guiFrame.createGUI();
        frame.dispose();
    }
}
