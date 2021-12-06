package login.welcome_page;

import gui.ButtonActionInterface;

public class QuitButton implements ButtonActionInterface {
    public void apply() {
        System.exit(0);
    }
}
