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

    public String inputIndex(){return "Please input the index (first number you see \n before the \")\"" +
            " of the product that you want buy";}

    public String putIndex(){return "Index Of Item";}

    public String buyButton(){return "Buy Something!";}

    public String presentCantFollow(){return "Can't follow this user";}

    public String presentCanFollow(){return "Followed User Successfully";}
}
