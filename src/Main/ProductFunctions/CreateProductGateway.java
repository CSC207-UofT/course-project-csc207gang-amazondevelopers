package ProductFunctions;

import InputAndOutput.SystemInOut;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;

import UndoPackage.Undo;
import UserFunctions.User;
import OptionsPackage.UserOptionsGateway;

public class CreateProductGateway {

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
            if (undo.getCurrentState() == "Name") {
                input.sendOutput("What is the name of the product?");
                String name = input.getInput();
                if (name.equals("*")){
                   UserOptionsGateway uo = new UserOptionsGateway(user);
                   uo.userInput(input);
                   throw new IOException();
                }
                else{
                    undo.setDataPoint(name);
                }
            }
            if (undo.getCurrentState() == "ID") {
                input.sendOutput("What is the ID of the product?");
                String ID = input.getInput();
                if (ID.equals("*")){
                    undo.undo();
                }
                else{
                    undo.setDataPoint(ID);
                }
            }
            if (undo.getCurrentState() == "Price") {
                input.sendOutput("What is the price of this product?");
                String priceString = input.getInput();
                if (priceString.equals("*")){
                    undo.undo();
                }
                else{
                    Double price = Double.parseDouble(priceString);
                    undo.setDataPoint(price);
                }

            }
            if (undo.getCurrentState() == "Category") {
                input.sendOutput("What is the Category of this product?");
                String category = input.getInput();
                if (category.equals("*")){
                    undo.undo();
                }
                else{
                    undo.setDataPoint(category);
                }
            }

            if (undo.getCurrentState() == "Quantity") {
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
            if (undo.getCurrentState() == "Size") {
                input.sendOutput("What is the size of this product? Press enter No Size if this product does not have a size");
                String sizeInput = input.getInput();
            }
        }
        HashMap output = undo.get_Data();
        if (! output.get("Size").equals("No Size")){
            Product newProduct = new Product((String)output.get("Name"), (String)output.get("ID"), (double)output.get("Price"),(String) output.get("Category"), (String)output.get("Size"),(int) output.get("Quantity"));
            return newProduct;
        }else{
            Product newProduct = new Product((String)output.get("Name"), (String)output.get("ID"), (double)output.get("Price"),(String) output.get("Category"),(int) output.get("Quantity"));
            return newProduct;
        }

    }
}
