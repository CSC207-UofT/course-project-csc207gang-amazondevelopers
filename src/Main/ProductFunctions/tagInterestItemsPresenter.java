package ProductFunctions;

import InputAndOutput.SystemInOut;

import java.util.List;

public class tagInterestItemsPresenter {
    public void presentTagList(List<Product> productsOfInterest, SystemInOut inOut){
        inOut.sendOutput(productsOfInterest);


    }

}
