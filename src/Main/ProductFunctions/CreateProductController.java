package ProductFunctions;
import InputAndOutput.SystemInOut;
import java.io.IOException;
import java.util.HashMap;
import java.util.Objects;
import java.util.Random;
import Undo.Undo;
import PostFunctions.Post;
import PostFunctions.PostManager;
import PostFunctions.AddPostGateway;
import UserFunctions.User;
import Undo.UndoUseCase;

// TODO FIX CODE SMELL!! Too long method
/**
 * Class to create a specific product and its related post.
 */
public class CreateProductController {

    public Product createNewProductFromInput(SystemInOut input, User user) throws Exception {
        // SystemInOut input = new SystemInOut();
        UndoUseCase uc = new UndoUseCase();
        Undo undo = new Undo();
        uc.setProductController(undo);
        while (!undo.isComplete()) {
            if (Objects.equals(uc.getState(undo), "Name")) {
                input.sendOutput("What is the name of the product?");
                String name = input.getInput();
                if (name.equals("*")) {
                    throw new Exception();
                } else if (name.equals("")) {
                    input.sendOutput("Product must have a name.");
                } else{
                    uc.addData(undo,name);
                }
            }

            if (Objects.equals(uc.getState(undo), "Price")) {
                input.sendOutput("What is the price of this product?");
                String priceString = input.getInput();
                if (priceString.equals("*")) {
                    uc.undo(undo);
                } else {
                    try {
                        double price = Double.parseDouble(priceString);
                        if (price >= 0) {
                            uc.addData(undo,price);
                        } else {
                            input.sendOutput("Price must be greater than or equal to 0.");
                        }
                    }catch(NumberFormatException e){
                        input.sendOutput("Price must be a number.");
                    }
                }

            }
            if (Objects.equals(uc.getState(undo), "Category")) {
                input.sendOutput("What is the Category of this product?");
                String category = input.getInput();
                if (category.equals("*")) {
                    uc.undo(undo);
                } else {
                    uc.addData(undo,category);
                }
            }

            if (Objects.equals(uc.getState(undo), "Quantity")) {
                input.sendOutput("What is the quantity of this product? Please enter an integer.");
                String quantityString = input.getInput();
                if (quantityString.equals("*")) {
                    uc.undo(undo);
                } else {
                    try {
                        int quantity = Integer.parseInt(quantityString);
                        uc.addData(undo,quantity);
                    } catch(NumberFormatException e){
                        input.sendOutput("Please enter an integer.");
                    }
                }
            }
            if (Objects.equals(uc.getState(undo), "Size")) {
                input.sendOutput("What is the size of this product? Press enter No Size if this product does not have a size");
                String sizeInput = input.getInput();
                if (sizeInput.equals("*")) {
                    uc.undo(undo);
                } else {
                    uc.addData(undo,sizeInput);
                }
            }
            if (Objects.equals(uc.getState(undo), "Caption")) {
                input.sendOutput("What is the caption of your post?");
                String captionInput = input.getInput();
                if (captionInput.equals("*")) {
                    uc.undo(undo);
                } else {
                    uc.addData(undo,captionInput);
                }
            }
            if (Objects.equals(uc.getState(undo), "CanComment")) {
                input.sendOutput("Would you like your post to have Comments? Input 1 for yes, 2 for no");
                String commentInput = input.getInput();
                if (commentInput.equals("*")) {
                    uc.undo(undo);
                } else if (commentInput.equals("1")) {
                    uc.addData(undo,true);
                } else if (commentInput.equals("2")) {
                    uc.addData(undo,false);
                }
                //If they didnt enter these 3 options
            }
            if (Objects.equals(uc.getState(undo), "CanRate")) {
                input.sendOutput("Would you like your post to have Ratings? Input 1 for yes, 2 for no");
                String ratingInput = input.getInput();
                if (ratingInput.equals("*")) {
                    uc.undo(undo);
                }
                else if (ratingInput.equals("1")) {
                    uc.addData(undo,true);
                } else if (ratingInput.equals("2")) {
                    uc.addData(undo,false);
                }
                //If they didnt enter these 3 options
            }
        }
        HashMap<String, Object> output = uc.getData(undo);


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
            prodUseCase.saveNewProductToSer(newproduct);
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
            prodUseCase.saveNewProductToSer(newproduct);

            input.sendOutput("Product was created.");
            return newproduct;
        }

    }

    private String generateID() throws IOException, ClassNotFoundException {
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
