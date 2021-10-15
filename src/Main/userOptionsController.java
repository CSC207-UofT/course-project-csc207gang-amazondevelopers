import java.util.ArrayList;
import java.util.Locale;
import java.util.Scanner;

public class userOptionsController {

    Scanner input = new Scanner(System.in);

    ArrayList<String> options = new ArrayList<>();
    options.add("post");
    options.add("browse");
    options.add("search");


    public void userInput() throws Exception {

        System.out.println("What would you like to do? Input one of Search, Post, Browse");
        String userDecision = input.nextLine();


        if (!(options.contains(userDecision.toLowerCase(Locale.ROOT)))){
        throw new Exception("That is not an accepted input, please try again!");
        // in case the input is not in the list of accepted inputs, ends early
        }
        else if(userDecision.equals("post")){
            createPostController createPostController = new createPostController();
            // redirects to createPostController class
        }
        else if(userDecision.equals("browse")){
            browseController browseController = new browseController();
            // redirects to browseController and return feed
        }
        else {
            searchController searchController = new searchController();
            // redirects to search and returns relevant search info
        }
    }
}

// need code for browseController, searchController, and createPostController in order to output
// the correct information