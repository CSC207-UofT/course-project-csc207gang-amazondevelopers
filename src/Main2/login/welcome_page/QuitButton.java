package login.welcome_page;

import gui.ButtonActionInterface;


public class QuitButton implements ButtonActionInterface {
    /**
     * When this button is activated, it quits the system.
     */
    public void apply() {
        System.exit(0);
    }
}
