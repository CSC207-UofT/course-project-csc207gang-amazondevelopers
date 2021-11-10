package OptionsPackage;

import InputAndOutput.SystemInOut;
import ProductFunctions.Product;
import UserFunctions.CartManager;
import UserFunctions.User;

import java.io.IOException;
import java.util.List;

public class BuyGateway {

    // TODO use this same class in browse and everywhere else you want to buy

    public void allowBuy(SystemInOut input, User user) throws IOException, ClassNotFoundException {

        TagInterestItemsPresenter presenter = new TagInterestItemsPresenter();
        SearchController browse = new SearchController();

        List<Product> productsOfInterest = browse.allowSearch(input);
        presenter.presentTagList(productsOfInterest, input);

        input.sendOutput("Would you like to purchase one of the items?" +
                "enter the number of your choice\n 1.Yes\n2.No");
        String decisionToBuy = input.getInput();

        if (decisionToBuy.equals("1")){
            // then the user wants to buy
            input.sendOutput("Please select the index of the item that you want to buy. The index is the " +
                    "integer value for the position of the item on the list, with the first item being at " +
                    "the 0th index.");
            String itemIndex = input.getInput();
            int indexInt = Integer.parseInt(itemIndex);
            if (indexInt < productsOfInterest.size()){
                Product itemOfInterest = productsOfInterest.get(indexInt);
                // add this product to the cart
                CartManager cart = new CartManager();
                cart.addToCart(itemOfInterest, user);

            }else{
                input.sendOutput("incorrect index, try again");
                this.allowBuy(input, user);
            }


        }
        else {
            SearchController search = new SearchController();
            search.allowSearch(input);
        }

    }
}
