package loginFunctions;

import inputOutputFunctions.SystemInOut;

import java.io.IOException;

public class SignInPresenter {
    /**
     * Presents to the user and asks what their username is
     * @throws IOException This is if nothing is put in as input
     */
    public void presentSignIn() throws IOException {
        SystemInOut inOut = new SystemInOut();
        inOut.sendOutput("What is your username? (please do not leave this field empty)");
    }

    /**
     * Presents to the user if their username does not exist yet
     */
    public void failedSignIn() {
        SystemInOut inOut = new SystemInOut();
        inOut.sendOutput("Invalid Username, please reenter your username.");
    }
}
