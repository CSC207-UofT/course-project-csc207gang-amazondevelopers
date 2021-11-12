package OptionsPackage;

import InputAndOutput.SystemInOut;
import ProductFunctions.GetProductGateway;
import ProductFunctions.Product;
import UserFunctions.CartManager;
import UserFunctions.User;

import java.io.IOException;
import java.util.List;

public class BuyController {

    // TODO what happen after they decide to buy?

    public void allowBuy(User user, List<String> listIds) throws IOException, ClassNotFoundException {
        SystemInOut input = new SystemInOut();
        TagInterestItemsPresenter presenter = new TagInterestItemsPresenter();

        // loop to keep checking if the user wants to buy something from the list
        boolean keepRunning = true;
        while(keepRunning) {
            presenter.presentTagList(listIds);
            input.sendOutput("Would you like to purchase one of the items?" +
                "enter the number of your choice\n 1.Yes\n 2.No.(Search or browse again) \n Type 'R' to choose another option from the menu.");
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
                    if (indexInt < listIds.size()) {
                        GetProductGateway productG = new GetProductGateway();
                        String itemAtIndex = listIds.get(indexInt);
                        Product productToAddToCart = productG.getProduct(itemAtIndex);
                        // add this product to the cart
                        CartManager cart = new CartManager();
                        cart.addToCart(productToAddToCart, user);
                        // the user has bought something, so user can now decide if they want to buy something
                        // else from the search results or not (returned to the outer while loop)
                        boughtOrExit = true;
                    } else if (itemIndex.equals("exit")) {
                        // return to the outer while loop so user can decide if they want to do something else other than buy
                        boughtOrExit = true;
                    } else {
                        input.sendOutput("incorrect index, try again");
                        // user needs to type in a new index/'exit' in next iteration of this loop
                    }
                }

            } else if (decisionToBuy.equals("2")) {
                // end the loop, thereby ending the call to BuyController
                keepRunning = false;
            } else if (decisionToBuy.equals("R")) {
                // let the user search for something new if they dont want to buy something
                UserOptionsController userOptionsController = new UserOptionsController(user);
                userOptionsController.getOption();
                keepRunning = false;
            } else {
                // end the loop, thereby ending the call to BuyController
                keepRunning = false;
            }
        }

    }
}
