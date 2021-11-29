package followFunctions;

import inputOutputFunctions.SystemInOut;

public class EnglishFollowPresenter implements FollowPresenterInterface{
    SystemInOut input;

    public EnglishFollowPresenter(SystemInOut input){
        this.input = input;
    }

    @Override
    public void presenterToFollow() {
        input.sendOutput("What is the username of the person that you would you like to follow? or " +
                "press * to go back to all options menu");
    }

    @Override
    public void presenterFollowed() {
        input.sendOutput("The user was followed successfully.");
    }
}
