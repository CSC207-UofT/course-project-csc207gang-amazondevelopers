package loginFunctions;
import inputOutputFunctions.InOut;


public class WelcomePagePresenter {
    /**
     * @param input this helps send options to user on what they want to input
     */
    public void decision(InOut input) {
        input.sendOutput("What would you like to do? Select the number of choice: \n 1.Signin\n 2.Signup\n 3.Quit\n Input * at anytime to undo your input");
    }
}
