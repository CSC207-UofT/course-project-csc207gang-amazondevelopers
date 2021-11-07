package login;

import InputAndOutput.SystemInOut;

import java.io.IOException;

public class SignUpGateway {

    String getNewUsername(SystemInOut inOut) throws IOException {
        inOut.sendOutput("What would you like to put as your username? " +
                "(please do not leave this field empty)");
        String newUsername = inOut.getInput();
        while (newUsername.equals("")){
            inOut.sendOutput("Invalid Username, please reenter your username.");
            this.getNewUsername(inOut);
        }return newUsername;

    }


}
