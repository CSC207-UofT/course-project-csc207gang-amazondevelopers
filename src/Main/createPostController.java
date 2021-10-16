import InputAndOutput.InOut;
import java.io.IOException;
import java.util.ArrayList;

public class createPostController {
    public void postCreator(InOut inOut, User u){
        postManager postmanager = new postManager();
        String size = new String();
        //ask user to input username
        inOut.sendOutput("Input Product Name:");
        try{
            String product_name = inOut.getInput();

            inOut.sendOutput("Input Product Price:");
            String pricestring = inOut.getInput();
            float price = float(pricestring);
            //error if cannot be converted
            inOut.sendOutput("Input Product Category:");
            String category = inOut.getInput();

            inOut.sendOutput("Input true or false If product Has a size");
            String tfstring = inOut.getInput();
            boolean sizetf = Boolean.valueOf(tfstring);

            if (sizetf){
                inOut.sendOutput("Input the Product size");
                String size = inOut.getInput();
            }

            inOut.sendOutput("Input the Post Description");
            String postdescription = inOut.getInput();

            inOut.sendOutput("Input the number of Tags you want the Post to have");
            int tagnumber = int(inOut.getInput());

            ArrayList<String> tags = new ArrayList<>();

            for (int counter = 0; counter < tagnumber; counter++){
                inOut.sendOutput("Input a Tag for the post");
                tags.add(inOut.getInput());
            }
            if (sizetf){
                postmanager.createPost(tags,u,postdescription,product_name,price,category,size);
            }
            else{
                postmanager.createPost(tags,u,postdescription,product_name,price,category);
            }




        } catch (IOException e) {
            inOut.sendOutput("An error occurred, try again.");
        }

    }
}
