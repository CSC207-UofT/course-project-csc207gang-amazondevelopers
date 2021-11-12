package OptionsPackage;

import InputAndOutput.SystemInOut;
import UserFunctions.User;

import java.io.IOException;

public class UserOptionsController{
    User user;

    public UserOptionsController(User user){
        this.user = user;
    }

    public void getOption() throws IOException {
        SystemInOut input = new SystemInOut();
        input.sendOutput("What would you like to do? Input a number for " +
                "your ideal option:\n 1.Search and buy \n 2.Make a post \n 3.Follow another user \n 4.Browse and buy" +
                "\n 5. Settings \n 6.logout ");
        String userDecision = input.getInput();
        UserOptionsUseCase optionsUC = new UserOptionsUseCase(user);
        optionsUC.userInput(userDecision);
    }
}
