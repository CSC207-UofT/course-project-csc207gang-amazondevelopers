package OptionsPackage;

import InputAndOutput.SystemInOut;
import ProductFunctions.GetProductGateway;
import ProductFunctions.Product;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

// sends out list of products
public class ListOfProductsPresenter {

    public void presentTagList(List<String> IDProductOfInterest) throws IOException, ClassNotFoundException {
        SystemInOut inOut = new SystemInOut();
        ArrayList<String> stringProductList = new ArrayList<>();
        // TODO: change this to get the toString for Post instead of for the product.
        for (String itemID : IDProductOfInterest ){
            GetProductGateway product = new GetProductGateway();
            Product ourProduct = (Product) product.getProduct(itemID);
            String productString = ourProduct.toString();
            stringProductList.add(productString);
        }
        inOut.sendOutput(stringProductList);
   }



}

