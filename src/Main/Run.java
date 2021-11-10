import InputAndOutput.SystemInOut;
import login.WelcomePageController;

import java.io.IOException;

public class Run {

    public static void main(String[] args) throws IOException {
        SystemInOut inOut = new SystemInOut();
        WelcomePageController initialLogin = new WelcomePageController();
        initialLogin.userLoginDecision(inOut);

        }
    }
