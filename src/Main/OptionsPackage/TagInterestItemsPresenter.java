package OptionsPackage;

import InputAndOutput.SystemInOut;
import ProductFunctions.Product;

import java.util.ArrayList;
import java.util.List;

// sends out list of products
public class TagInterestItemsPresenter {
    public void presentTagList(List<Product> productsOfInterest, SystemInOut inOut){

        ArrayList<String> stringProductList = new ArrayList<>();
        for (Product item : productsOfInterest){
            stringProductList.add(item.toString());
        }
        inOut.sendOutput(stringProductList);


   }

    }

