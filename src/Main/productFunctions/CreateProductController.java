package productFunctions;
import inputOutputFunctions.InOut;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Random;
import inputOutputFunctions.SystemInOut;
import postFunctions.CreatePostController;
import userFunctions.User;

// TODO FIX CODE SMELL!! Too long method
/**
 * Class to create a specific product and its related options.post.
 */
public class CreateProductController {
/**
    public productFunctions.Product createNewProductFromInput(InOut input, User user) throws Exception {

        ArrayList<productFunctions.Product.Memento> memento_list = new ArrayList<>();
        productFunctions.Product new_product = new Product(user.getUsername());
        new_product.set(0);//Sets the state to the state that asks for the products name
        memento_list.add(new_product.saveToMemento());
        boolean is_product_complete = false;
        ProductPresenterInterface englishProductPresenter = new EnglishProductPresenter();
        while (!is_product_complete) {
            if (new_product.getState() == 0) {
                englishProductPresenter.getProductNamePresenter();
                String name = input.getInput();
                if (name.equals("*")) {
                    throw new Exception(); //Exits the method entirely, returns to the UserOptionsGateway
                } else if (name.equals("")) {
                    englishProductPresenter.getProductNamePresenter();
                } else{
                    memento_list.add(new_product.saveToMemento());//Saves the current state of the product
                    new_product.setName(name);
                    new_product.set(1);//Sets internal state to now ask what price they want to input
                }
            }

            if (new_product.getState() == 1) {
                englishProductPresenter.getProductPricePresenter();
                String priceString = input.getInput();
                if (priceString.equals("*")) {
                    new_product.restoreFromMemento(memento_list.get(memento_list.size() -1)); // Restores the product to the last state
                    memento_list.remove(memento_list.size() -1); // Removes the memento state from the list
                } else {
                    try {
                        double price = Double.parseDouble(priceString);
                        if (price >= 0) {
                            memento_list.add(new_product.saveToMemento());
                            new_product.setPrice(price);
                            new_product.set(2);
                        } else {
                            englishProductPresenter.ProductPriceRangePresenter();
                        }
                    }catch(NumberFormatException e){
                        englishProductPresenter.specifyTypePriceProductPresenter();
                    }
                }

            }
            if (new_product.getState() == 2) {
                englishProductPresenter.getProductCategoryPresenter();
                String category = input.getInput();
                if (category.equals("*")) {
                    new_product.restoreFromMemento(memento_list.get(memento_list.size() -1));
                    memento_list.remove(memento_list.size() -1);
                } else {
                    memento_list.add(new_product.saveToMemento());
                    new_product.setCategory(category);
                    new_product.set(3);
                }
            }

            if (new_product.getState() == 3) {
                englishProductPresenter.getProductQuantityPresenter();
                String quantityString = input.getInput();
                if (quantityString.equals("*")) {
                    new_product.restoreFromMemento(memento_list.get(memento_list.size() -1));
                    memento_list.remove(memento_list.size() -1);
                } else {
                    try {
                        int quantity = Integer.parseInt(quantityString);
                        memento_list.add(new_product.saveToMemento());
                        new_product.setQuantity(quantity);
                        new_product.set(4);
                    } catch(NumberFormatException e){
                        englishProductPresenter.specifyTypeProductPresenter();
                    }
                }
            }
            if (new_product.getState() == 4) {
                englishProductPresenter.getProductSizePresenter();
                String sizeInput = input.getInput();
                if (sizeInput.equals("*")) {
                    new_product.restoreFromMemento(memento_list.get(memento_list.size() -1));
                    memento_list.remove(memento_list.size() -1);
                } else {
                    memento_list.add(new_product.saveToMemento());
                    new_product.setSizes(sizeInput);
                    englishProductPresenter.confirmProductCreationPresenter();
                    String yes_no = input.getInput();
                    if (yes_no.equals("*")){
                        new_product.restoreFromMemento((memento_list.get(memento_list.size() -1)));
                        memento_list.remove(memento_list.size() -1);
                    }
                    else{
                        is_product_complete = true;
                    }
                }
            }
        }

        productFunctions.SaveProductGateway productGate = new productFunctions.SaveProductGateway();
        String id = generateID();
        new_product.setId(id);
        productFunctions.ProductUseCase productManager = new productFunctions.ProductUseCase(productGate);
        CreatePostController cpc = new CreatePostController();
        SystemInOut out = new SystemInOut();
        cpc.createPost(out,new_product,user,true);
        productFunctions.SaveProductGateway createProductGateway = new SaveProductGateway();
        productFunctions.ProductUseCase prodUseCase = new ProductUseCase(createProductGateway);
        prodUseCase.saveNewProductToSer(new_product);
        englishProductPresenter.creationSuccessPresenter();
        return new_product;
    }

    private String generateID() throws IOException, ClassNotFoundException {
        productFunctions.GetProductGateway getProductGateway = new GetProductGateway();
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
}*/
}
