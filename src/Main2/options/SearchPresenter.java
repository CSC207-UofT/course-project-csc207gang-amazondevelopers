package options;

public class SearchPresenter implements SearchPresenterInterface{
    public String searchButton(){
        return "Search:";
    }

    public String clearButton(){
        return "Clear Search Bar";
    }

    public String backButton(){
        return "Back";
    }
}
