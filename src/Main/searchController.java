import InputAndOutput.InOut;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * take user input from command line interface and
 * Takes in user input tag words and and returns a list of all products that match that description to the user,
 * taking this information from a the masterManager which accese the tageProduct dictionary in master.
 * That dictionary has keys as the tag words for each product, and a list of product associated with that tag
 * word.
 */

public class searchController {


    public void searchProducts(InOut inOut){
        boolean validTag = false;
        String tagWord;
        masterManager masterManager = new masterManager();

        inOut.sendOutput("Search by tag: ");
        try{
            // code to enforce a limit to the length of the username, 20 characters max
            while (!validTag){
                tagWord = inOut.getInput();
                // check if the tage word is valid

                // fix this
                List<> searchList = masterManager.getSearchList(tagWord);

                if ()

                    /* ignore this, this is just for reference
                if (username.length() <= 20 && userManager.createUser(username)){
                    validUsername = true;
                    inOut.sendOutput("User profile successfully created.");
                    // print out username for the user to look over
                    inOut.sendOutput("Username: " + username);
                }
                else if (username.length() > 20){
                    inOut.sendOutput("Username is too long. Try again.");
                }
                else{
                    inOut.sendOutput("Username has already been taken. Try again.");
                }
            }
            */


            /* This code will be uncommented later, will not be included in skeleton
            inOut.sendOutput("Input password:");
            String password = inOut.getInput();

            inOut.sendOutput("Input profile description:");
            // should also try and enforce a limit to the # of characters in the description
            String description = inOut.getInput();

            // need code to get user profile picture
            */

                /*
        } catch (IOException e) {
            inOut.sendOutput("An error occurred, try again.");
            // maybe restart user creation process over again if exception is thrown
        }
        // ideas: give user an option to redo user creation
        */










        if (masterManager.getSearchList(tagWord).equals(false)){
            return false;}
        else{
            return masterManager.getSearchList(tagWord);


        }



    public Object getSearchItems(String tagWord){

        if (masterManager.getSearchList(tagWord).equals(false)){
            return false;}
        else{
            return masterManager.getSearchList(tagWord);


        }
    }
}
