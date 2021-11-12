package ProductFunctions;

import InputAndOutput.InOut;
import InputAndOutput.SystemInOut;

import java.io.IOException;
import java.util.HashMap;
import java.util.Objects;
import Undo.Undo;

import UserFunctions.User;
import OptionsPackage.UserOptionsController;

public class CreateProductController {

    public Product createNewProductFromInput(SystemInOut input, User user) throws Exception {
        Undo undo = new Undo();
        undo.addData("Name");
        undo.addData("ID");
        undo.addData("Price");
        undo.addData("Category");
        undo.addData("Quantity");
        undo.addData("Size");
        undo.addState("Name");
        undo.addState("ID");
        undo.addState("Price");
        undo.addState("Category");
        undo.addState("Quantity");
        undo.addState("Size");
        while(!undo.isComplete()) {
            if (Objects.equals(undo.getCurrentState(), "Name")) {
                input.sendOutput("What is the name of the product?");
                String name = input.getInput();
                if (name.equals("*")){
                    UserOptionsController uo = new UserOptionsController(user);
                    uo.userInput(input);
                    throw new IOException();
                }
                else{
                    undo.setDataPoint(name);
                }
            }
            if (Objects.equals(undo.getCurrentState(), "ID")) {
                input.sendOutput("What is the ID of the product?");
                String ID = input.getInput();
                if (ID.equals("*")){
                    undo.undo();
                }
                else{
                    undo.setDataPoint(ID);
                }
            }
            if (Objects.equals(undo.getCurrentState(), "Price")) {
                input.sendOutput("What is the price of this product?");
                String priceString = input.getInput();
                if (priceString.equals("*")){
                    undo.undo();
                }
                else{
                    Double price = Double.parseDouble(priceString);
                    if (price >= 0) {
                        undo.setDataPoint(price);
                    }
                    else{
                        input.sendOutput("Price must be greater than or equal to 0.");
                    }
                }

            }
            if (Objects.equals(undo.getCurrentState(), "Category")) {
                input.sendOutput("What is the Category of this product?");
                String category = input.getInput();
                if (category.equals("*")){
                    undo.undo();
                }
                else{
                    undo.setDataPoint(category);
                }
            }

            if (Objects.equals(undo.getCurrentState(), "Quantity")) {
                input.sendOutput("What is the quantity of this product? Please enter an integer");
                String quantityString = input.getInput();
                if (quantityString.equals("*")){
                    undo.undo();
                }
                else {
                    int quantity = Integer.parseInt(quantityString);
                    undo.setDataPoint(quantity);
                }
            }
            if (Objects.equals(undo.getCurrentState(), "Size")) {
                input.sendOutput("What is the size of this product? Press enter No Size if this product does not have a size");
                String sizeInput = input.getInput();
            }
        }
        HashMap<String, Object> output = undo.get_Data();
        CreateProductGateway productGate = new CreateProductGateway();

        if (! output.get("Size").equals("No Size")){

            ProductManager productManager = new ProductManager(productGate);
            return productManager.createProduct((String)output.get("Name"), (String)output.get("ID"), (double)output.get("Price"),(String) output.get("Category"), (String)output.get("Size"),(int) output.get("Quantity"));
        }else{
            ProductManager productManager = new ProductManager(productGate);
            return productManager.createProduct((String)output.get("Name"), (String)output.get("ID"), (double)output.get("Price"),(String) output.get("Category"),(int) output.get("Quantity"));
        }
    }
}
