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
                String name = input.getInput().strip();
                if (name.equals("*")) {
                    UserOptionsController uo = new UserOptionsController(user);
                    uo.getOption();
                    throw new IOException();
                } else if (name.equals("")) {
                    input.sendOutput("Product must have a name.");
                } else{
                    undo.setDataPoint(name);
                }
            }

            if (Objects.equals(undo.getCurrentState(), "Price")) {
                input.sendOutput("What is the price of this product?");
                String priceString = input.getInput();
                if (priceString.equals("*")) {
                    undo.undo();
                } else {
                    try {
                        double price = Double.parseDouble(priceString);
                        if (price >= 0) {
                            undo.setDataPoint(price);
                        } else {
                            input.sendOutput("Price must be greater than or equal to 0.");
                        }
                    }catch(NumberFormatException e){
                        input.sendOutput("Price must be a number.");
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
                input.sendOutput("What is the quantity of this product? Please enter an integer.");
                String quantityString = input.getInput();
                if (quantityString.equals("*")) {
                    undo.undo();
                } else {
                    try {
                        int quantity = Integer.parseInt(quantityString);
                        undo.setDataPoint(quantity);
                    } catch(NumberFormatException e){
                        input.sendOutput("Please enter an integer.");
                    }
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
                } else if (commentInput.equals("1")) {
                    undo.setDataPoint(true);
                } else if (commentInput.equals("2")) {
                    undo.setDataPoint(false);
                }
                //If they didnt enter these 3 options
            }
            if (Objects.equals(undo.getCurrentState(), "CanRate")) {
                input.sendOutput("Would you like your post to have Ratings? Input 1 for yes, 2 for no");
                String ratingInput = input.getInput();
                if (ratingInput.equals("*")) {
                    undo.undo();
                }
                else if (ratingInput.equals("1")) {
                    undo.setDataPoint(true);
                } else if (ratingInput.equals("2")) {
                    undo.setDataPoint(false);
                }
                //If they didnt enter these 3 options
            }
        }
        HashMap<String, Object> output = undo.get_Data();


        CreateProductGateway productGate = new CreateProductGateway();
        String id = generateID();
        if (!output.get("Size").equals("No Size")) {

            ProductUseCase productManager = new ProductUseCase(productGate);

            Product newproduct = productManager.saveNewProduct((String) output.get("Name"), id,
                    (double) output.get("Price"), (String) output.get("Category"), (String) output.get("Size"),
                    (int) output.get("Quantity"));


            AddPostGateway addPostGateway = new AddPostGateway();
            PostManager postManager = new PostManager(addPostGateway);
            Post newpost = postManager.createPost(newproduct, (String) output.get("Caption"),
                    (boolean)output.get("CanComment"), (boolean)output.get("CanRate"), user);
            postManager.savePost(newpost, user);

            CreateProductGateway createProductGateway = new CreateProductGateway();
            ProductUseCase prodUseCase = new ProductUseCase(createProductGateway);
            prodUseCase.saveNewProductToSer(newproduct, user);


            productGate.addProductToRepo(newproduct, newproduct.getId(), newproduct.getCategory());
            input.sendOutput("Product was created.");
            return newproduct;
        } else {

            ProductUseCase productManager = new ProductUseCase(productGate);

            Product newproduct = productManager.saveNewProduct((String) output.get("Name"), id,
                    (double) output.get("Price"), (String) output.get("Category"),
                    (int) output.get("Quantity"));


            AddPostGateway addPostGateway = new AddPostGateway();
            PostManager postManager = new PostManager(addPostGateway);
            Post newpost = postManager.createPost(newproduct, (String) output.get("Caption"),
                    (boolean)output.get("CanComment"), (boolean)output.get("CanRate"), user);
            postManager.savePost(newpost, user);

            CreateProductGateway createProductGateway = new CreateProductGateway();
            ProductUseCase prodUseCase = new ProductUseCase(createProductGateway);
            prodUseCase.saveNewProductToSer(newproduct, user);


            productGate.addProductToRepo(newproduct, newproduct.getId(), newproduct.getCategory());
            input.sendOutput("Product was created.");
            return newproduct;

//            ///////////////////////// previous else - Delete
//
//            AddPostGateway postGate = new AddPostGateway();
//            ProductUseCase productManager = new ProductUseCase(productGate);
//            Product newproduct = productManager.saveNewProduct((String) output.get("Name"),
//                    id, (double) output.get("Price"), (String) output.get("Category"),
//                    (int) output.get("Quantity"));
//            PostManager postManager = new PostManager(postGate);
//            Post newpost = postManager.createPost(newproduct, (String) output.get("Caption"),
//                    (boolean)output.get("CanComment"), (boolean)output.get("CanRate"), user);
//
//            postGate.addPost(newpost, user);
//            productGate.addProductToRepo(newproduct, newproduct.getId(), newproduct.getCategory());
//            input.sendOutput("Product was created.");
//            return newproduct;
        }

    }

    // should this be private
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
