package loginFunctions;

import inputOutputFunctions.SystemInOut;
import userFunctions.User;

import java.io.IOException;


public class PasswordPresenter {

    public String password1;
    public String password2;
    public String password3;

    public void promptPassword(User user) throws IOException {
        SystemInOut inOut = new SystemInOut();
        PasswordController passController = new PasswordController();
        inOut.sendOutput("Now, input your password (minimum 5 characters)");

        password1 = inOut.getInput();

        if (password1.length() < 5){
            inOut.sendOutput("Password is too short please try again");
            this.promptPassword(user);
        }

        inOut.sendOutput("Verify Password is correct: ");
        password2 = inOut.getInput();

        if(passController.verifyPasswordsMatch(password1, password2)){
            passController.setUserPassword(user, password1);
        }
        else{
            inOut.sendOutput("Passwords do not match please try again");
            this.promptPassword(user);
        }
    }
    public void promptPasswordSignIn(User user) throws IOException {
        SystemInOut inOut = new SystemInOut();
        PasswordController passController = new PasswordController();
        inOut.sendOutput("Input your password");

        password3 = inOut.getInput();

        if(!passController.verifyPassword(user, password3)){
            inOut.sendOutput("Password is incorrect please try again");
            this.promptPasswordSignIn(user);
        }
    }
}
