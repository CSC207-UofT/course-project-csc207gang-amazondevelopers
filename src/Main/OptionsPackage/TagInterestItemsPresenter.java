package OptionsPackage;

import InputAndOutput.SystemInOut;
import ProductFunctions.Product;

import java.util.List;

public class TagInterestItemsPresenter {
    public void presentTagList(List<Product> productsOfInterest, SystemInOut inOut){
        inOut.sendOutput(productsOfInterest);


    }

}
