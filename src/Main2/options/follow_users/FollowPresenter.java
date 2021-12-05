package options.follow_users;

public class FollowPresenter implements FollowPresenterInterface{

    public String followButton(){
        return "follow!";
    }

    public String clearButton(){
        return "Clear Search Bar";
    }

    public String backButton(){
        return "Back";
    }

    public String searchInstructions(){
        return "Please input a tag word for your product of interest";
    }

    public String inputIndex(){return "Please input the index (first number you see \n before the \")\"" +
            " of the product that you want buy";}

    public String putIndex(){return "Index Of Item";}

    public String buyButton(){return "Buy Something!";}
}
