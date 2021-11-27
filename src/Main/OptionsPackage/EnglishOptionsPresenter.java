package OptionsPackage;
import InputAndOutput.SystemInOut;
import ProductFunctions.GetProductGateway;
import ProductFunctions.Product;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 */
// sends out list of products
public class EnglishOptionsPresenter implements OptionsPresenterInterface {

    /**
     * Takes in a list of if representing products and presents a list of product toString associated with
     * with that id.
     * @param IDProductOfInterest list of id representing products
     * @throws IOException  error occured during reading a file, when there is an input / output error
     * @throws ClassNotFoundException thrown if the class is not found
     */
    public void presentList(List<String> IDProductOfInterest) throws IOException, ClassNotFoundException {
        SystemInOut inOut = new SystemInOut();
        ArrayList<String> stringProductList = new ArrayList<>();
        for (String itemID : IDProductOfInterest){
            GetProductGateway product = new GetProductGateway();
            if (product.checkId(itemID)){
                Product ourProduct = product.getProduct(itemID);
                String productString = ourProduct.toString();
                stringProductList.add(productString);
            }
        }
        inOut.sendOutput(stringProductList);
   }

   public void optionToBuyPresent(){
        SystemInOut input = new SystemInOut();
       input.sendOutput("Would you like to add one of the items to your cart?" +
               "enter the number of your choice\n 1.Yes\n 2.No take me back to Search\n " +
               "Type 'R' to choose another option from the menu.");
   }

   public void addToCartPresent(){
       SystemInOut input = new SystemInOut();
       input.sendOutput("Please select the index of the item that you want to add to " +
               "your cart. The index is the " +
               "integer value for the position of the item on the list, with the first item being at " +
               "the 0th index. Type exit if you would like to go back to your search result.");
   }


   public void outOfStockPresent(){
       SystemInOut input = new SystemInOut();
       input.sendOutput("This product is out of stock. Please select another product.");

   }

   public void buyOrBackPresent(){
       SystemInOut input = new SystemInOut();
       input.sendOutput("would you like to\n1. buy your entire cart\n2.Go back to options");

   }

   public void cartIsEmptyPresent(){
       SystemInOut input = new SystemInOut();
       input.sendOutput("your cart is now empty, and you have purchased" +
               " the products in it.");
   }

   public void incorrectIndexPresent(){
        SystemInOut input = new SystemInOut();
       input.sendOutput("incorrect index, try again");
   }

   public void invalidInput(){
       SystemInOut input = new SystemInOut();
       input.sendOutput("invalid input");

   }

   public void userOptionsMain(){
       SystemInOut input = new SystemInOut();
       input.sendOutput("What would you like to do? Input a number for " +
               "your ideal option:\n 1.Search and buy \n 2.Make a post \n 3.Follow another user \n 4.Browse and buy" +
               "\n 5.Settings \n 6.logout ");
   }


}

