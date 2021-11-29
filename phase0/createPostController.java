import inputOutputFunctions.InOut;
import java.io.IOException;
import java.util.ArrayList;

public class createPostController{

    /**
     * Takes in a User and an object that implements inOut and creates a post for the User.
     *
     *
     * @param inOut an object that implements InOut interface
     * @param user A User object
     */

    public void postCreator(InOut inOut, User user){
        postManager postmanager = new postManager();
        //ask user to input username
        inOut.sendOutput("Input Product Name:");
        try{
            String product_name = inOut.getInput();

            inOut.sendOutput("Input Product Price:");
            String priceString = inOut.getInput();
            float price = Float.parseFloat(priceString);
            //error if cannot be converted
            inOut.sendOutput("Input Product Category:");
            String category = inOut.getInput();

            inOut.sendOutput("Input Product ID:");
            String id = inOut.getInput();

            inOut.sendOutput("Input Product Quantity");
            int quantity = Integer.parseInt(inOut.getInput());

            inOut.sendOutput("Input true or false If product Has a size");
            String tfstring = inOut.getInput();
            boolean sizetf = Boolean.valueOf(tfstring);

            String sizeOther = "";

            if (sizetf){
                inOut.sendOutput("Input the Product size");
                sizeOther = inOut.getInput();
            }

            inOut.sendOutput("Input the Post Description");
            String postdescription = inOut.getInput();

            inOut.sendOutput("Input the number of Tags you want the Post to have");
            int tagnumber = Integer.parseInt(inOut.getInput());

            ArrayList<String> tags = new ArrayList<>();

            for (int counter = 0; counter < tagnumber; counter++){
                inOut.sendOutput("Input a Tag for the post");
                tags.add(inOut.getInput());
            }
            if (sizetf){
                postmanager.createPost(tags,user,postdescription,product_name,id,price,category,sizeOther,quantity);
            }
            else{
                postmanager.createPost(tags,user,postdescription,product_name,id,price,category,quantity);
            }
            inOut.sendOutput("Post has been created");
        } catch (IOException e) {
            inOut.sendOutput("An error occurred, try again.");
        }

    }
}

