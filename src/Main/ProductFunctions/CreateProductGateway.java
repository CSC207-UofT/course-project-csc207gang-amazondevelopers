package ProductFunctions;

import InputAndOutput.SystemInOut;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;

import UndoPackage.Undo;
import UserFunctions.User;
import OptionsPackage.UserOptionsGateway;

public class CreateProductGateway {

    public Product createNewProductFromInput(SystemInOut input, User user) throws IOException {
        Undo undo = new Undo();
        undo.add_data("Name");
        undo.add_data("ID");
        undo.add_data("Price");
        undo.add_data("Category");
        undo.add_data("Quantity");
        undo.add_data("Size");
        undo.add_state("Name");
        undo.add_state("ID");
        undo.add_state("Price");
        undo.add_state("Category");
        undo.add_state("Quantity");
        undo.add_state("Size");
        while(!undo.isComplete()) {
            if (undo.get_Current_State() == "Name") {
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
            if (undo.get_Current_State() == "ID") {
                input.sendOutput("What is the ID of the product?");
                String ID = input.getInput();
                if (ID.equals("*")){
                    undo.undo();
                }
                else{
                    undo.setDataPoint(ID);
                }
            }
            if (undo.get_Current_State() == "Price") {
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
            if (undo.get_Current_State() == "Category") {
                input.sendOutput("What is the Category of this product?");
                String category = input.getInput();
                if (category.equals("*")){
                    undo.undo();
                }
                else{
                    undo.setDataPoint(category);
                }
            }

            if (undo.get_Current_State() == "Quantity") {
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
            if (undo.get_Current_State() == "Size") {
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
