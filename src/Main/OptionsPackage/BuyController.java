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

/**
 * Allow the user to buy products
 */
public class BuyController {
    // TODO Phase 2: Fix method too long code smell!
    /**
     *
     * @param user this user that is signed in
     * @param listIds a list of ids of products
     * @throws IOException error occured during reading a file, when there is an input / output error
     * @throws ClassNotFoundException thrown if the class is not found.
     */
    public void allowBuy(SystemInOut input, User user, List<String> listIds) throws Exception {
        EnglishOptionsPresenter presenter = new EnglishOptionsPresenter();

        // loop to keep checking if the user wants to buy something from the list
        presenter.presentList(listIds);
        // present the buying options to the user
        presenter.optionToBuyPresent();
        String decisionToBuy = input.getInput();

            if (decisionToBuy.equals("1")) {
                // then the user wants to buy
                boolean boughtOrExit = false;
                while (!boughtOrExit) {
                    presenter.addToCartPresent();
                    String itemIndex = input.getInput();
                    int indexInt = Integer.parseInt(itemIndex);
                    if (indexInt < listIds.size()) {
                        GetProductGateway productG = new GetProductGateway();
                        String itemAtIndex = listIds.get(indexInt);
                        Product productToAddToCart = productG.getProduct(itemAtIndex);
                        // add this product to the cart
                        CartManager cart = new CartManager();
                        if (!cart.addToCart(productToAddToCart, user)){
                            presenter.outOfStockPresent();
                            this.allowBuy(input, user, listIds);
                        }
                        // the user has bought something, so user can now decide if they want to buy something
                        // else from the search results or not (returned to the outer while loop)

                        presenter.buyOrBackPresent();
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
                            presenter.cartIsEmptyPresent();
                            UserOptionsController options = new UserOptionsController(user);
                            EnglishOptionsPresenter engPresenter = new EnglishOptionsPresenter();

                        }else{
                            UserOptionsController options = new UserOptionsController(user);
                            EnglishOptionsPresenter engPresenter = new EnglishOptionsPresenter();
                            options.getOption(input, engPresenter);

                        }
                        boughtOrExit = true;
                    } else if (itemIndex.equals("exit")) {
                        // return to the outer while loop so user can decide if they want to do something else other than buy
                        boughtOrExit = true;
                        this.allowBuy(input, user,listIds);
                    } else {
                        presenter.incorrectIndexPresent();
                        // user needs to type in a new index/'exit' in next iteration of this loop
                        this.allowBuy(input, user,listIds);
                    }
                }
            } else if (decisionToBuy.equals("2")) {
                SearchController SC = new SearchController(user);
                SC.allowSearch(input);

            }
            else if (decisionToBuy.equals("R")) {
                // let the user search for something new if they dont want to buy something
                UserOptionsController userOptionsController = new UserOptionsController(user);
                EnglishOptionsPresenter engPresenter = new EnglishOptionsPresenter();
                userOptionsController.getOption(input, engPresenter);
                this.allowBuy(input, user,listIds);
            } else {
                // end the loop, thereby ending the call to BuyController
                presenter.invalidInput();
                this.allowBuy(input, user, listIds);
            }
        }

    }

