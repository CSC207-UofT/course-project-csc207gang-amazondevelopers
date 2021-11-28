package login;

import InputAndOutput.SystemInOut;
import UserFunctions.User;

import java.io.IOException;


public class PasswordPresenter {

    public String password1;
    public String password2;

    public void promptPassword(User user) throws IOException {
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
            this.promptPassword(user);
        }
        else{
            inOut.sendOutput("Passwords do not match please try again");
            this.promptPassword(user);
        }
    }
}
