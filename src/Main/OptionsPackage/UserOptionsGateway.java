package OptionsPackage;

import InputAndOutput.SystemInOut;

import ProductFunctions.CreateProduct;
import ProductFunctions.CreateProductGateway;
import UserFunctions.User;
import UserFunctions.UserReadWriter;

import java.io.IOException;
import java.util.HashMap;


// right now, we can only search and buy and add products.
// TODO we will later impelement browse and post

public class UserOptionsGateway {
    User user;

    public UserOptionsGateway(User user){
        this.user = user;
    }

    public void userInput(SystemInOut input) throws Exception {
        boolean keepRunning = true;
        while(keepRunning) {
            input.sendOutput("What would you like to do? Input a number for " +
                    "your ideal option:\n 1.Search and buy \n2.OptionsPackage.Post\n 3.Browse and buy\n 4.Sign Out");
            String userDecision = input.getInput();


            try {
                if (userDecision.equals("1")) {
                    // redirects to OptionsPackage.searchController and returns relevant search info
                    SearchGateway searchGate = new SearchGateway();
                    searchGate.allowBuy(input, user);

                    // searchGate.allowBuy(input, user);
                    // save the cart of the user
                    String username = user.getUsername();
                    UserReadWriter rw = new UserReadWriter();
                    HashMap<String, Object> usersSavedDict = rw.readFromFile("src/Main/user.ser");
                    usersSavedDict.put(username, user);
                    rw.saveToFile("src/Main/user.ser", usersSavedDict);
                } else if (userDecision.equals("2")) {
                    // create the product,
                    // TODO then add it as a post
                    CreateProduct createProduct = new CreateProduct();
                    createProduct.addProductToRepo(input, user);

                } else if (userDecision.equals("3")) {

                } else if (userDecision.equals("4")) {
                    keepRunning = false;
                }


//  implement allowing the user to browse, and create a post
//            }else if(userDecision == "2"){
//                // redirects to PostFunctions.createPostController class
//                createPostController postController = new createPostController();
//                postController.postCreator(input, this.user);
//            }else if(userDecision == "3"){
//                // redirects to OptionsPackage.browseController and return feed
//                OptionsPackage.browseController OptionsPackage.browseController = new OptionsPackage.browseController();
//                OptionsPackage.browseController.searchFeed(input, this.user);
//            }


                // throw new IOException("That is not an accepted input, please try again!");
                // throws exception in case the input is not in the available options of inputs
            } catch (IOException | ClassNotFoundException e) {
                e.printStackTrace();
            }
        }
    }
}
