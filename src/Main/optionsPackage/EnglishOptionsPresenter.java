package optionsPackage;
import inputOutputFunctions.SystemInOut;
import productFunctions.GetProductGateway;
import productFunctions.Product;
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
            else{
                inOut.sendOutput("There are no products in this program yet!");
            }
        }
        inOut.sendOutput(stringProductList);
   }

    /**
     * Present to the user If the user wants to add products to their cart
     */

   public void optionToBuyPresent(){
        SystemInOut input = new SystemInOut();
       input.sendOutput("Would you like to add one of the items to your cart?" +
               "enter the number of your choice\n 1.Yes\n *. Take me back to main menu");
   }

    /**
     * Present to the user the index of the prodcuts that they want to add to their cart
     */

   public void addToCartPresent(){
       SystemInOut input = new SystemInOut();
       input.sendOutput("Please select the index of the item that you want to add to " +
               "your cart. The index is the " +
               "integer value for the position of the item on the list, with the first item being at " +
               "the 0th index. Type exit if you would like to go back to your search result.");
   }

    /**
     * tell the user that their product is out of stock
     */
   public void outOfStockPresent(){
       SystemInOut input = new SystemInOut();
       input.sendOutput("This product is out of stock. Please select another product.");

   }

    /**
     * The user buys entire cart or continues to search presenter
     */

   public void buyOrBackPresent(){
       SystemInOut input = new SystemInOut();
       input.sendOutput("would you like to\n1. buy your entire cart\n2.Go back to options");

   }

    /**
     * of the cart of the user is empty
     */
   public void cartIsEmptyPresent(){
       SystemInOut input = new SystemInOut();
       input.sendOutput("your cart is now empty, and you have purchased" +
               " the products in it.");
   }

    /**
     * If the inputted index is incorrect
     */
   public void incorrectIndexPresent(){
        SystemInOut input = new SystemInOut();
       input.sendOutput("incorrect index, try again");
   }

    /**
     * invalid input by the user
     */
   public void invalidInput(){
       SystemInOut input = new SystemInOut();
       input.sendOutput("invalid input");

   }

    /**
     * the option to search, follow, browse, or logout for the user
     */
   public void userOptionsMain(){
       SystemInOut input = new SystemInOut();
       input.sendOutput("What would you like to do? Input a number for " +
               "your ideal option:\n 1.Search and buy \n 2.Make a post \n 3.Follow another user \n 4.Browse and buy" +
               "\n 5.Settings \n 6.logout ");
   }

    @Override
    public void noMatchingProductsPresent() {
        SystemInOut input = new SystemInOut();
        input.sendOutput("There are no products matching that tag word. Try again.");
    }
    public void genericException(){
       SystemInOut input = new SystemInOut();
       input.sendOutput("Returning to Main Menu");
    }

}

