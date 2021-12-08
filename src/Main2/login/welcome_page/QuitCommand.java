package login.welcome_page;

import gui.ButtonCommandInterface;


public class QuitCommand implements ButtonCommandInterface {
    /**
     * When this button is activated, it quits the system.
     */
    public void apply() {
        System.exit(0);
    }
}
