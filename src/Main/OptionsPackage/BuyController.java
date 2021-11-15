package OptionsPackage;
import InputAndOutput.InOut;
import InputAndOutput.SystemInOut;
import ProductFunctions.GetProductGateway;
import ProductFunctions.Product;
import UserFunctions.CartManager;
import UserFunctions.SaveProductGatewayInterface;
import UserFunctions.User;
import UserFunctions.SaveProductGateway;
import login.SaveUserGateway;
import login.SaveUserGatewayInterface;
import java.io.IOException;
import java.util.List;

public class BuyController {
    // TODO Phase 2: Fix method too long code smell!
    /**
     *
     * @param user this user that is signed in
     * @param listIds a list of ids of products
     * @throws IOException error occured during reading a file, when there is an input / output error
     * @throws ClassNotFoundException thrown if the class is not found.
     */
    public void allowBuy(InOut input, User user, List<String> listIds) throws Exception {
        ListOfProductsPresenter presenter = new ListOfProductsPresenter();

        // loop to keep checking if the user wants to buy something from the list
        presenter.presentList(listIds);
            input.sendOutput("Would you like to add one of the items to your cart?" +
                "enter the number of your choice\n 1.Yes\n 2.No take me back to Search\n " +
                    "Type 'R' to choose another option from the menu.");
            String decisionToBuy = input.getInput();

            if (decisionToBuy.equals("1")) {
                // then the user wants to buy
                boolean boughtOrExit = false;
                while (!boughtOrExit) {
                    input.sendOutput("Please select the index of the item that you want to add to " +
                            "your cart. The index is the " +
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
                        if (!cart.addToCart(productToAddToCart, user)){
                            input.sendOutput("This product is out of stock. Please select another product.");
                            this.allowBuy(input, user, listIds);
                        }
                        // the user has bought something, so user can now decide if they want to buy something
                        // else from the search results or not (returned to the outer while loop)

                        input.sendOutput("would you like to\n1. buy your entire cart\n2.Go back to options");
                        String optionToBuy = input.getInput();

                        if (optionToBuy.equals("1")){
                            // save the product decreased quantity
                            SaveProductGatewayInterface saveProdG = new SaveProductGateway();
                            CartManager cartUseCaseUpdateProdQ = new CartManager(saveProdG);
                            cartUseCaseUpdateProdQ.updateProductQuantity(user);
                            // save the user with updated cart
                            SaveUserGatewayInterface saveUserGateway = new SaveUserGateway();
                            CartManager cartUseCaseSaveUser = new CartManager(saveUserGateway);
                            cartUseCaseSaveUser.emptyCart(user);
                            input.sendOutput("your cart is now empty, and you have purchased" +
                                    " the products in it.");
                            UserOptionsController options = new UserOptionsController(user);
                            options.getOption(input);

                        }else{
                            UserOptionsController options = new UserOptionsController(user);
                            options.getOption(input);

                        }
                        boughtOrExit = true;
                    } else if (itemIndex.equals("exit")) {
                        // return to the outer while loop so user can decide if they want to do something else other than buy
                        boughtOrExit = true;
                        this.allowBuy(input, user,listIds);
                    } else {
                        input.sendOutput("incorrect index, try again");
                        // user needs to type in a new index/'exit' in next iteration of this loop
                        this.allowBuy(input, user,listIds);
                    }
                }
            } else if (decisionToBuy.equals("2")) {
                // end the loop, thereby ending the call to BuyController
                SearchController SC = new SearchController(user);
                SC.allowSearch(input);

            }
            else if (decisionToBuy.equals("R")) {
                // let the user search for something new if they dont want to buy something
                UserOptionsController userOptionsController = new UserOptionsController(user);
                userOptionsController.getOption(input);
                this.allowBuy(input, user,listIds);
            } else {
                // end the loop, thereby ending the call to BuyController
                input.sendOutput("invalid input");
                this.allowBuy(input, user, listIds);
            }
        }

    }

