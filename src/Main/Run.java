import InputAndOutput.SystemInOut;
import login.WelcomePageController;

import java.io.IOException;

public class Run {

    public static void main(String[] args) throws IOException {
        WelcomePageController welcomePageController = new WelcomePageController();
        SystemInOut inOut = new SystemInOut();
        welcomePageController.userLoginDecision(inOut);

        }
    }
