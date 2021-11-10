package OptionsPackage;

import InputAndOutput.SystemInOut;
import ProductFunctions.Product;
import UserFunctions.User;
import UserFunctions.CartManager;

import java.io.IOException;
import java.util.List;

public class SearchController {
    public List<Product> allowSearch(SystemInOut input, User user) throws IOException, ClassNotFoundException, Exception {
        SearchGateway searchController = new SearchGateway();

        input.sendOutput("What is a tag word for your product of interest?");
        String tagOfInterest = input.getInput();
        if (tagOfInterest.equals("*")){
            UserOptionsController uo = new UserOptionsController(user);
            uo.userInput(input);
            throw new Exception();
        }
        else {
            return searchController.searchProducts(tagOfInterest);
        }
    }

    public void allowBuy(SystemInOut input, User user) throws Exception {

        TagInterestItemsPresenter presenter = new TagInterestItemsPresenter();
        List<Product> productsOfInterest = this.allowSearch(input,user);
        presenter.presentTagList(productsOfInterest, input); // check if product list is empty

        input.sendOutput("Would you like to purchase one of the items?" +
                "enter the number of your choice\n 1.Yes\n2.No");
        String decisionToBuy = input.getInput();
        if (decisionToBuy.equals("*")){
            this.allowBuy(input, user);
            return;
        }
        if (decisionToBuy.equals("1")){
            // then the user wants to buy
            input.sendOutput("Please select the index of the item that you want to buy. The index is the " +
                    "integer value for the position of the item on the list, with the first item being at " +
                    "the 0th index.");
            String itemIndex = input.getInput();
            if (itemIndex.equals("*")){
                this.allowBuy(input, user);
                return;
            }
            else {
                int indexInt = Integer.parseInt(itemIndex);
                if (indexInt < productsOfInterest.size()) {
                    Product itemOfInterest = productsOfInterest.get(indexInt);
                    // add this product to the cart
                    CartManager cart = new CartManager();
                    cart.addToCart(itemOfInterest, user);

                } else {
                    input.sendOutput("incorrect index, try again");
                    this.allowBuy(input, user); // let user input new index instead of searching again
                }
            }


        }
        else {
            // SearchGateway search = new SearchGateway();
            // search.allowSearch(input);
            // should ask if user wants to exit out of search here or search again
            allowBuy(input, user);
        }

    }
    }

