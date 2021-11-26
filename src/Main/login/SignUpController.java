package login;
import InputAndOutput.InOut;
import InputAndOutput.SystemInOut;
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
    public void getNewUsername() throws IOException, ClassNotFoundException {
        SystemInOut inOut = new SystemInOut();
        // prompt user to sign up
        SignUpPresenter present = new SignUpPresenter();
        present.presentSignUp();
        // save the username of the user
        String newUsername = inOut.getInput();
        if (newUsername.strip().equals("") | newUsername.equals("*")) {
            present.failedSignUp();
            this.getNewUsername();
        }
        SignUpGatewayInterface signUpgateway = new SignUpGateway();
        SignUpUseCase signUpUseCase = new SignUpUseCase(signUpgateway);
        signUpUseCase.allowSignUp(newUsername);
    }


}
