import java.util.Scanner;

public class userOptionsController {

    Scanner input = new Scanner(System.in);

    public Object userInput() throws Exception {

        System.out.println("What would you like to do? Input one of Search, Post, Browse");
        String userDecision = input.nextLine().toLowerCase();

        try{
            switch (userDecision) {
                case "post":
                    // redirects to createPostController class
                    return new createPostController();
                case "browse":
                    // redirects to browseController and return feed
                    return new browseController();
                case "search":
                    // redirects to searchController and returns relevant search info
                    return new searchController();
            }
            throw new Exception("That is not an accepted input, please try again!");
            // throws exception in case the input is not in the available options of inputs
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}

// need code for browseController, searchController, and createPostController in order to output
// the correct information