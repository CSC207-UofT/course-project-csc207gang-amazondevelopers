package login;

import UserFunctions.User;

import java.io.IOException;

public class SignUpUseCase {
    SignUpGatewayInterface signUpGateway;

    /**
     *
     * @param signUpGateway
     */
    public SignUpUseCase(SignUpGatewayInterface signUpGateway) {
        this.signUpGateway = signUpGateway;
    }

    public void allowSignUp() throws IOException, ClassNotFoundException {
        SignUpController signUpCont = new SignUpController();
        String newUsername = signUpCont.getNewUsername();
        User newUser = new User(newUsername);
        signUpGateway.allowSignUp(newUsername, newUser);
    }
}


