package login;

import InputAndOutput.SystemInOut;

import java.io.IOException;

public class SignInGateway {

    String getUsername(SystemInOut inOut) throws IOException {
        inOut.sendOutput("What is your username? (please do not leave this field empty)");
        String username = inOut.getInput();
        while (username.equals("")){
            inOut.sendOutput("Invalid Username, please re-enter your username.");
            this.getUsername(inOut);
        }return username;

    }

}








