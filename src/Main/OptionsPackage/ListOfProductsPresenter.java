package OptionsPackage;

import InputAndOutput.SystemInOut;
import ProductFunctions.GetProductGateway;
import ProductFunctions.Product;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

// sends out list of products
public class ListOfProductsPresenter {

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

