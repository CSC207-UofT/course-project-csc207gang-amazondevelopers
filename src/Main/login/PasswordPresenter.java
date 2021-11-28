package login;

import InputAndOutput.SystemInOut;
import UserFunctions.User;

import java.io.IOException;


public class PasswordPresenter {

    public String password1;
    public String password2;

    public void promptPasswordSignUp(User user) throws IOException {
        SystemInOut inOut = new SystemInOut();
        PasswordController passController = new PasswordController();
        inOut.sendOutput("Now, input your password, would you like it to be hidden while you type?" +
                " Answer Yes or No");
        String answer = inOut.getInput();
        if(answer.equals("Yes")){
            password1 = PasswordField.readPassword("Type your password (At least 5 Characters): ");
            password2 = PasswordField.readPassword("Verify Password is correct: ");
        }
        else {
            inOut.sendOutput("Type your password (At least 5 Characters): ");
            password1 = inOut.getInput();
            inOut.sendOutput("Verify Password is correct: ");
            password2 = inOut.getInput();
        }
        if(passController.verifyPasswordsMatch(password1, password2)){
            passController.setUserPassword(user, password1);
        }
        else if (password1.length() < 5){
            inOut.sendOutput("Password is too short please try again");
            this.promptPasswordSignUp(user);
        }
        else{
            inOut.sendOutput("Passwords do not match please try again");
            this.promptPasswordSignUp(user);
        }
    }

    public void promptPasswordSignIn(User user) throws IOException {
        SystemInOut inOut = new SystemInOut();
        PasswordController passController = new PasswordController();
        inOut.sendOutput("Now, input your password, would you like it to be hidden while you type?" +
                " Answer Yes or No");
        String answer = inOut.getInput();
        if(answer.equals("Yes")){
            password1 = PasswordField.readPassword("Type your password: ");
        }
        else {
            inOut.sendOutput("Type your password: ");
            password1 = inOut.getInput();
        }
        if(passController.verifyPassword(user, password1)){
            inOut.sendOutput("Successfully logged in");
        }
        else{
            inOut.sendOutput("Password is incorrect please try again");
            this.promptPasswordSignIn(user);
        }
    }
}
