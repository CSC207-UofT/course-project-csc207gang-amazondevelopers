package postFunctions;
import inputOutputFunctions.SystemInOut;

public class EnglishPostPresenter implements PostPresenterInterface {
    SystemInOut output = new SystemInOut();
    public void presentCaption(){
        output.sendOutput("What is the caption of your post?");
    }
    public void presentUnableToUndo(){
        output.sendOutput("Sorry, you cannot undo from here");
    }
    public void presentComments(){
        output.sendOutput("Would you like your post to have Comments? Input 1 for yes, 2 for no");
    }
    public void presentRatings(){
        output.sendOutput("Would you like your post to have Ratings? Input 1 for yes, 2 for no");
    }
    public void presentPostConformation(){
        output.sendOutput("Are you happy with this post? Type * for no, or anything else for yes.");
    }
}
