package OptionsPackage;

import InputAndOutput.SystemInOut;
import ProductFunctions.GetProductGateway;
import ProductFunctions.Product;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

// sends out list of products
public class TagInterestItemsPresenter {
    public void presentTagList(List<String> productsOfInterest, SystemInOut inOut) throws IOException, ClassNotFoundException {


        ArrayList<String> stringProductList = new ArrayList<>();
        for (String itemID : productsOfInterest){
            GetProductGateway product = new GetProductGateway();
            Product ourProduct = product.getProduct(itemID);
            String productString = ourProduct.toString();
            stringProductList.add(productString);
        }
        inOut.sendOutput(stringProductList);


   }

    }

