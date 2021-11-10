package OptionsPackage;

import InputAndOutput.SystemInOut;
import ProductFunctions.Product;

import java.util.List;

// sends out list of products
// TODO change list of products into string representation (call toString)
public class TagInterestItemsPresenter {
    public void presentTagList(List<Product> productsOfInterest, SystemInOut inOut){
        inOut.sendOutput(productsOfInterest);
    }
}
