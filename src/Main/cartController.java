import InputAndOutput.InOut;

import java.io.IOException;
/**
 * A controller class that adds items to a users cart.
 */
public class cartController {
    private userManager userManager = new userManager();

    public void addToCartSearch(InOut inOut, User user) {
        inOut.sendOutput("What product would you like to buy? (Input index):");
        try {
            String stringIndex = inOut.getInput();
            try{
                // turn string into an int, exception is thrown when the string entered cannot be turned to an int
                int productIndex = Integer.parseInt(stringIndex);
                boolean validIndex = false;
                while(!validIndex){
                    // try and add the product at the index to the users cart
                    if (userManager.addToShoppingCartSearches(productIndex, user)){
                        validIndex = true;
                        inOut.sendOutput("Successfully added to cart.");
                    }
                    else{
                        inOut.sendOutput("Error, please enter a valid index.");
                        stringIndex = inOut.getInput();
                        productIndex = Integer.parseInt(stringIndex);
                    }
                }

            }
            catch(NumberFormatException e){
                // exception thrown when user inputs a string that is not a number
                inOut.sendOutput("An error occurred, please enter a number.");
                // process for buying an item should restart
            }

        } catch (IOException e) {
            inOut.sendOutput("An error occurred, try again.");
        }
    }

    public void addToCartBrowse(InOut inOut, User user){
        inOut.sendOutput("What product would you like to buy? (Input index):");
        try {
            String stringIndex = inOut.getInput();
            try{
                // turn string into an int, exception is thrown when the string entered cannot be turned to an int
                int productIndex = Integer.parseInt(stringIndex);
                boolean validIndex = false;
                while(!validIndex){
                    // try and add the product at the index to the users cart
                    if (userManager.addToShoppingCartFeed(productIndex, user)){
                        validIndex = true;
                        inOut.sendOutput("Successfully added to cart.");
                    }
                    else{
                        inOut.sendOutput("Error, please enter a valid index.");
                        stringIndex = inOut.getInput();
                        productIndex = Integer.parseInt(stringIndex);
                    }
                }

            }
            catch(NumberFormatException e){
                // exception thrown when user inputs a string that is not a number
                inOut.sendOutput("An error occurred, please enter a number.");
                // process for buying an item should restart
            }

        } catch (IOException e) {
            inOut.sendOutput("An error occurred, try again.");
        }
    }
}
