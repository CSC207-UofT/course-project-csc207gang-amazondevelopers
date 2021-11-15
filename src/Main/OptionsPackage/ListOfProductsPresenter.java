package OptionsPackage;
import InputAndOutput.SystemInOut;
import ProductFunctions.GetProductGateway;
import ProductFunctions.Product;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

// sends out list of products
public class ListOfProductsPresenter {

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
}

