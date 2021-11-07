package UserFunctions;

import InputAndOutput.SystemInOut;
import PostFunctions.createPostController;
import ProductFunctions.Product;
import ProductFunctions.tagInterestItemsPresenter;

import java.io.IOException;
import java.util.List;

public class UserOptionsGateway {
    User user;

    public UserOptionsGateway(User user){
        this.user = user;
    }

    public void userInput(SystemInOut input) throws IOException {

        input.sendOutput("What would you like to do? Input a number for " +
                "your ideal option:\n 1.Search\n2.Post\n 3.Browse");
        String userDecision = input.getInput();


        try{
            if(userDecision == "1") {
                // redirects to ProductFunctions.searchController and returns relevant search info
                ProductFunctions.searchController searchController = new ProductFunctions.searchController();
                input.sendOutput("What is a tag word for your product of interest?");
                String tagOfInterest = input.getInput();
                List<Product> productsOfInterest = searchController.searchProducts(tagOfInterest);
                tagInterestItemsPresenter presenter = new tagInterestItemsPresenter();

                presenter.presentTagList(productsOfInterest, input);
                input.sendOutput("Would you like to purchase one of the items?" +
                        "enter the number of your choice\n 1.Yes\n2.No");
                String decisionToBuy = input.getInput();
                BuyingDecisions userBuyingDecisions = new BuyingDecisions();
                userBuyingDecisions.performDecision(decisionToBuy);

            }else if(userDecision == "2"){
                // redirects to PostFunctions.createPostController class
                createPostController postController = new createPostController();
                postController.postCreator(input, this.user);
            }else if(userDecision == "3"){
                // redirects to browseController and return feed
                browseController browseController = new browseController();
                browseController.searchFeed(input, this.user);
            }
            else {
                this.userInput(input);

            }

            throw new IOException("That is not an accepted input, please try again!");
            // throws exception in case the input is not in the available options of inputs
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
}
