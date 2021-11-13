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
    // TODO Phase 2: Fix method too long code smell!

    public void allowBuy(User user, List<String> listIds) throws IOException, ClassNotFoundException {
        SystemInOut input = new SystemInOut();
        ListOfProductsPresenter presenter = new ListOfProductsPresenter();

        // loop to keep checking if the user wants to buy something from the list
        presenter.presentList(listIds);
            input.sendOutput("Would you like to purchase one of the items?" +
                "enter the number of your choice\n 1.Yes\n 2.No take me back to Search\n " +
                    "Type 'R' to choose another option from the menu.");
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
                        Product productToAddToCart = (Product) productG.getProduct(itemAtIndex);
                        // add this product to the cart
                        CartManager cart = new CartManager();
                        cart.addToCart(productToAddToCart, user);
                        // the user has bought something, so user can now decide if they want to buy something
                        // else from the search results or not (returned to the outer while loop)
                        //TODO allow user to buy sth or not by emptying their cart
                        boughtOrExit = true;
                    } else if (itemIndex.equals("exit")) {
                        // return to the outer while loop so user can decide if they want to do something else other than buy
                        boughtOrExit = true;
                        this.allowBuy(user,listIds);
                    } else {
                        input.sendOutput("incorrect index, try again");
                        // user needs to type in a new index/'exit' in next iteration of this loop
                        this.allowBuy(user,listIds);
                    }
                }

            } else if (decisionToBuy.equals("2")) {
                // end the loop, thereby ending the call to BuyController
                SearchController SC = new SearchController(user);
                SC.allowSearch();

            }


            else if (decisionToBuy.equals("R")) {
                // let the user search for something new if they dont want to buy something
                UserOptionsController userOptionsController = new UserOptionsController(user);
                userOptionsController.getOption();
                this.allowBuy(user,listIds);
            } else {
                // end the loop, thereby ending the call to BuyController
                input.sendOutput("invalid input");
                this.allowBuy(user, listIds);
            }
        }

    }

