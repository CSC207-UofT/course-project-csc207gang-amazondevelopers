package product;

import inputOutputFunctions.SystemInOut;
import userFunctions.User;
import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

public class ProductGUI {

    User user;

    public ProductGUI(User user) {
        this.user = user;
        JFrame frame = new JFrame();
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(420, 420); frame.setLayout(null); frame.setVisible(true);
    }

    public void createProduct() throws Exception {

        ArrayList<Product.Memento> memento_list = new ArrayList<>();
        product.Product new_product = new Product(user.getUsername());
        new_product.set(0);//Sets the state to the state that asks for the products name
        memento_list.add(new_product.saveToMemento());
        boolean is_product_complete = false;
        ProductPresenterInterface englishProductPresenter = new EnglishProductPresenter();
        while (!is_product_complete) {
            if (new_product.getState() == 0) {
                JLabel generic = new JLabel(englishProductPresenter.getProductNamePresenter());
                generic.setBounds(125, 10, 200, 35);
                generic.setFont(new Font(null, Font.PLAIN, 15));
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

        CreateProductController createProductController = new CreateProductController();
        SystemInOut inout = new SystemInOut();
        createProductController.createNewProductFromInput(inout, this.user);
    }
}
