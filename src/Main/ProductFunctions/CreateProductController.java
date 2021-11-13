package ProductFunctions;

import InputAndOutput.SystemInOut;

import java.io.IOException;
import java.util.HashMap;
import java.util.Objects;
import java.util.Random;

import OptionsPackage.UserOptionsController;
import Undo.Undo;
import PostFunctions.Post;
import PostFunctions.PostManager;
import PostFunctions.AddPostGateway;

import UserFunctions.User;

// TODO FIX CODE SMELL!! Too long method
/**
 * Class to create a specific product and its related post.
 */
public class CreateProductController {

    public Product createNewProductFromInput(SystemInOut input, User user) throws Exception {
        // SystemInOut input = new SystemInOut();
        Undo undo = new Undo();
        undo.addData("Name");
        //undo.addData("ID");
        undo.addData("Price");
        undo.addData("Category");
        undo.addData("Quantity");
        undo.addData("Size");
        undo.addData("Caption");
        undo.addData("CanComment");
        undo.addData("CanRate");
        undo.addState("Name");
        //undo.addState("ID");
        undo.addState("Price");
        undo.addState("Category");
        undo.addState("Quantity");
        undo.addState("Size");
        undo.addState("Caption");
        undo.addState("CanComment");
        undo.addState("CanRate");
        while (!undo.isComplete()) {
            if (Objects.equals(undo.getCurrentState(), "Name")) {
                input.sendOutput("What is the name of the product?");
                String name = input.getInput();
                if (name.equals("*")) {
                    UserOptionsController uo = new UserOptionsController(user);
                    uo.getOption();
                    throw new IOException();
                } else {
                    undo.setDataPoint(name);
                }
            }

            if (Objects.equals(undo.getCurrentState(), "Price")) {
                input.sendOutput("What is the price of this product?");
                String priceString = input.getInput();
                if (priceString.equals("*")) {
                    undo.undo();
                } else {
                    double price = Double.parseDouble(priceString);
                    if (price >= 0) {
                        undo.setDataPoint(price);
                    } else {
                        input.sendOutput("Price must be greater than or equal to 0.");
                    }
                }

            }
            if (Objects.equals(undo.getCurrentState(), "Category")) {
                input.sendOutput("What is the Category of this product?");
                String category = input.getInput();
                if (category.equals("*")) {
                    undo.undo();
                } else {
                    undo.setDataPoint(category);
                }
            }

            if (Objects.equals(undo.getCurrentState(), "Quantity")) {
                input.sendOutput("What is the quantity of this product? Please enter an integer");
                String quantityString = input.getInput();
                if (quantityString.equals("*")) {
                    undo.undo();
                } else {
                    int quantity = Integer.parseInt(quantityString);
                    undo.setDataPoint(quantity);
                }
            }
            if (Objects.equals(undo.getCurrentState(), "Size")) {
                input.sendOutput("What is the size of this product? Press enter No Size if this product does not have a size");
                String sizeInput = input.getInput();
                if (sizeInput.equals("*")) {
                    undo.undo();
                } else {
                    undo.setDataPoint(sizeInput);
                }
            }
            if (Objects.equals(undo.getCurrentState(), "Caption")) {
                input.sendOutput("What is the caption of your post?");
                String captionInput = input.getInput();
                if (captionInput.equals("*")) {
                    undo.undo();
                } else {
                    undo.setDataPoint(captionInput);
                }
            }
            if (Objects.equals(undo.getCurrentState(), "CanComment")) {
                input.sendOutput("Would you like your post to have Comments? Input 1 for yes, 2 for no");
                String commentInput = input.getInput();
                if (commentInput.equals("*")) {
                    undo.undo();
                }
                else{
                    undo.setDataPoint(commentInput);
                }
//                } else if (commentInput.equals("1")) {
//                    undo.setDataPoint(true);
//                } else if (commentInput.equals("2")) {
//                    undo.setDataPoint(false);
//                }
                //If they didnt enter these 3 options
            }
            if (Objects.equals(undo.getCurrentState(), "CanRate")) {
                input.sendOutput("Would you like your post to have Ratings? Input 1 for yes, 2 for no");
                String ratingInput = input.getInput();
                if (ratingInput.equals("*")) {
                    undo.undo();
                }
                else{
                    undo.setDataPoint(ratingInput);
                }
//                if (ratingInput.equals("1")) {
//                    undo.setDataPoint(true);
//                } else if (ratingInput.equals("2")) {
//                    undo.setDataPoint(false);
//                }
                //If they didnt enter these 3 options
            }
        }
        HashMap<String, Object> output = undo.get_Data();
        CreateProductGateway productGate = new CreateProductGateway();

        String id = generateID();
        boolean comment;
        boolean rate;
        comment = output.get("CanComment") == "1";
        rate = output.get("CanRate") == "1";

        if (!output.get("Size").equals("No Size")) {

            ProductManager productManager = new ProductManager(productGate);

            Product newproduct = productManager.createProduct((String) output.get("Name"), id,
                    (double) output.get("Price"), (String) output.get("Category"), (String) output.get("Size"),
                    (int) output.get("Quantity"));
            PostManager postManager = new PostManager();

            Post newpost = postManager.createPost(newproduct, (String) output.get("Caption"),
                    comment, rate);

            AddPostGateway postGate = new AddPostGateway();
            postGate.addPost(newpost, user);
            productGate.addProductToRepo(newproduct, newproduct.getId(), newproduct.getCategory());
            input.sendOutput("Product was created.");
            return newproduct;
        } else {
            ProductManager productManager = new ProductManager(productGate);
            Product newproduct = productManager.createProduct((String) output.get("Name"),
                    id, (double) output.get("Price"), (String) output.get("Category"),
                    (int) output.get("Quantity"));
            PostManager postManager = new PostManager();

            Post newpost = postManager.createPost(newproduct, (String) output.get("Caption"),
                    comment, rate);

            AddPostGateway postGate = new AddPostGateway();
            postGate.addPost(newpost, user);
            productGate.addProductToRepo(newproduct, newproduct.getId(), newproduct.getCategory());
            input.sendOutput("Product was created.");
            return newproduct;
        }

    }

    public String generateID() throws IOException, ClassNotFoundException {
        GetProductGateway getProductGateway = new GetProductGateway();
        HashMap<String, Object> hashMap = getProductGateway.getHashMap();
        int hashMapSize = hashMap.size();
        if (hashMapSize == 0) {
            Random random = new Random();
            return String.valueOf(random.nextInt());
        } else {
            boolean idUsed = true;
            Random random = new Random();
            String id = String.valueOf(random.nextInt());
            while (idUsed) {
                if (!hashMap.containsKey(id)) {
                    idUsed = false;
                } else {
                    id = String.valueOf(random.nextInt());
                }
            }
            return id;
        }
    }
}
