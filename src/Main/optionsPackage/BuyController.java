package optionsPackage;
import browseFunctions.GetUserDictGateway;
import browseFunctions.GetUserDictGatewayInterface;
import browseFunctions.SaveUserDictGateway;
import browseFunctions.SaveUserDictGatewayInterface;
import inputOutputFunctions.InOut;
import product.GetProductGateway;
import product.Product;
import userFunctions.CartManager;
import userFunctions.SaveProductGatewayInterface;
import userFunctions.User;
import userFunctions.SaveProductGateway;
import loginFunctions.SaveUserGateway;
import loginFunctions.SaveUserGatewayInterface;
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
    public void allowBuy(InOut input, User user, List<String> listIds) throws Exception {
        EnglishOptionsPresenter presenter = new EnglishOptionsPresenter();

        // loop to keep checking if the user wants to buy something from the list
        presenter.presentList(listIds);
        // present the buying options to the user
        presenter.optionToBuyPresent();
        String decisionToBuy = input.getInput();

            if (decisionToBuy.equals("1")) {
                // then the user wants to buy
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

                        presenter.buyOrBackPresent();
                        String optionToBuy = input.getInput();

                        if (optionToBuy.equals("1")){
                            // save the product decreased quantity
                            SaveProductGatewayInterface saveProdG = new SaveProductGateway();
                            SaveUserDictGatewayInterface saveUserDictGateway = new SaveUserDictGateway();
                            GetUserDictGatewayInterface getUserDictGateway = new GetUserDictGateway();
                            CartManager cartUseCaseUpdateProdQ = new CartManager(saveProdG, getUserDictGateway,saveUserDictGateway);
                            cartUseCaseUpdateProdQ.updateProductQuantity(user);
                            // save the user with updated cart
                            SaveUserGatewayInterface saveUserGateway = new SaveUserGateway();
                            CartManager cartUseCaseSaveUser = new CartManager(saveUserGateway);
                            cartUseCaseSaveUser.emptyCart(user);
                            presenter.cartIsEmptyPresent();
                        }else{
                            UserOptionsController options = new UserOptionsController(user);
                            EnglishOptionsPresenter engPresenter = new EnglishOptionsPresenter();
                            options.getOption(input, engPresenter);

                        }
                    } else if (itemIndex.equals("exit")) {
                        this.allowBuy(input, user,listIds);
                    } else {
                        presenter.incorrectIndexPresent();
                        this.allowBuy(input, user,listIds);
                    }
            } else if (decisionToBuy.equals("*")) {
                SearchController SC = new SearchController(user);
                SC.allowSearch(input);
            }
            else if (decisionToBuy.equals("R")) {
                throw new Exception(); //
            } else {
                presenter.invalidInput();
                this.allowBuy(input, user, listIds);
            }
        }





    }



