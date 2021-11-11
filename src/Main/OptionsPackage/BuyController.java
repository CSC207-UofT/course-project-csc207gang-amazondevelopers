package OptionsPackage;

import InputAndOutput.SystemInOut;
import ProductFunctions.Product;
import UserFunctions.CartManager;
import UserFunctions.User;

import java.io.IOException;
import java.util.List;

public class BuyController {

    // TODO what happen after they decide to buy?

    public void allowBuy(SystemInOut input, User user) throws IOException, ClassNotFoundException {

        TagInterestItemsPresenter presenter = new TagInterestItemsPresenter();
        SearchController search = new SearchController();

        List<Product> productsOfInterest = search.allowSearch(input);
        presenter.presentTagList(productsOfInterest, input);

        input.sendOutput("Would you like to purchase one of the items?" +
                "enter the number of your choice\n 1.Yes\n2.No\nType 'exit' if you would like to exit search.");
        boolean keepChecking = true;
        while(keepChecking) {
            String decisionToBuy = input.getInput();

            if (decisionToBuy.equals("1")) {
                // then the user wants to buy
                boolean boughtOrExit = false;
                while (!boughtOrExit) {
                    input.sendOutput("Please select the index of the item that you want to buy. The index is the " +
                            "integer value for the position of the item on the list, with the first item being at " +
                            "the 0th index. Type exit if you would like to go back to your search result.");
                    String itemIndex = input.getInput();
                    int indexInt = Integer.parseInt(itemIndex);
                    if (indexInt < productsOfInterest.size()) {
                        Product itemOfInterest = productsOfInterest.get(indexInt);
                        // add this product to the cart
                        CartManager cart = new CartManager();
                        cart.addToCart(itemOfInterest, user);
                        boughtOrExit = true;
                    } else if (itemIndex.equals("exit")) {
                        boughtOrExit = true;
                    } else {
                        input.sendOutput("incorrect index, try again");
                    }
                }

            } else if (decisionToBuy.equals("2")) {
                search.allowSearch(input);
                keepChecking = false;
            } else {
                return;
            }
        }

    }
}
