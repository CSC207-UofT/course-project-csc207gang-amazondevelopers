package options.follow_users;

public class FollowPresenter implements FollowPresenterInterface{

    public String followButton(){
        return "Follow";
    }

    public String clearButton(){
        return "Clear Search Bar";
    }

    public String backButton(){
        return "Back";
    }

    public String followInstructions(){
        return "Please input a username to follow";
    }

    public String presentCantFollow(){return "Can't follow this user";}

    public String presentCanFollow(){return "Followed User Successfully";}
}
