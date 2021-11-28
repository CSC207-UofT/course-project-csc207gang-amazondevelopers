package login;
import InputAndOutput.InOut;
import UserFunctions.User;
import java.io.IOException;

/**
 *
 */
public class SignUpUseCase {
    SignUpGatewayInterface signUpGateway;

    /**
     *
     * @param signUpGateway the gateway allowing sign up. Dependency injection.
     */
    public SignUpUseCase(SignUpGatewayInterface signUpGateway) {
        this.signUpGateway = signUpGateway;
    }

    /**
     * Allow the user to sing up to the program, given their username
     * @throws IOException error occured during reading a file, when there is an input / output error
     * @throws ClassNotFoundException the class is not found.
     */
    public void allowSignUp(String newUsername) throws IOException, ClassNotFoundException {
        User newUser = new User(newUsername);
        signUpGateway.allowSignUp(newUsername, newUser);
    }
}


