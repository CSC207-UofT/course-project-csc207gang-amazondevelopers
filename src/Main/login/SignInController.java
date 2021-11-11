package login;

import InputAndOutput.SystemInOut;
import UserFunctions.User;

import java.io.IOException;

public class SignInController {

// handles user input

    String getUsername(SystemInOut inOut) throws IOException {
        inOut.sendOutput("What is your username? (please do not leave this field empty)");
        String username = inOut.getInput();
        while (username.equals("")){
            inOut.sendOutput("Invalid Username, please reenter your username.");
            this.getUsername(inOut);
        }return username;
        }
        }








