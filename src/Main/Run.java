import InputAndOutput.SystemInOut;
import login.WPController;
import login.WelcomePageUseCase;

import java.io.IOException;

public class Run {

    public static void main(String[] args) throws IOException {
        SystemInOut inOut = new SystemInOut();
        WPController welcomePageContoller = new WPController();
        String userDecision = welcomePageContoller.getWPInput(inOut);
        WelcomePageUseCase WPUsedCase = new WelcomePageUseCase();
        WPUsedCase.userLoginDecision(userDecision);

        }
    }
