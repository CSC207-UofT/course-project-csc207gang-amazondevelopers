package options.search;

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

    public String searchInstructions(){
        return "Please input a tag word for your product of interest";
    }

    public String inputIndex(){return "Please input the index of the item that you want buy";}

    public String putIndex(){return "Index Of Item";}

    public String buyButton(){return "Buy Something!";}
}
