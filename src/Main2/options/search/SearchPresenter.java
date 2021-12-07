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
        return "<html>Please input a tag word for your <br>product of interest.</html>";
    }

    public String inputIndex(){return "<html>Please input the index (first number you see before the \")\"" +
            " <br>of the product that you want buy</html>";}

    public String buyButton(){return "Buy Something!";}

    public String cannotBuy(){return "Can't Buy this product!";}

    public String canBuy(){return "Product was added to your cart";}
}
//