package loginFunctions;
import inputOutputFunctions.InOut;
import inputOutputFunctions.SystemInOut;
import java.io.IOException;

/**
 *
 */
public class SignUpController {
    /**
     * Gets the username from the user input.
     * @return String representing the username inputted by the user
     * @throws IOException error occured during reading a file, when there is an input / output error
     */
    public void getNewUsername(InOut inOut) throws IOException, ClassNotFoundException {
        // prompt user to sign up
        SignUpPresenter present = new SignUpPresenter();
        present.presentSignUp();
        // save the username of the user
        String newUsername = inOut.getInput();
        if (newUsername.strip().equals("") | newUsername.equals("*")) {
            present.failedSignUp();
            this.getNewUsername(inOut);
        }
        SignUpGatewayInterface signUpGateway = new SignUpGateway();
        SignUpUseCase signUpUseCase = new SignUpUseCase(signUpGateway);
        signUpUseCase.allowSignUp(newUsername);
    }


}
