package OptionsPackage;

import InputAndOutput.SystemInOut;
import ProductFunctions.Product;

import java.util.List;

public class tagInterestItemsPresenter {
    public void presentTagList(List<Product> productsOfInterest, SystemInOut inOut){
        inOut.sendOutput(productsOfInterest);


    }

}
