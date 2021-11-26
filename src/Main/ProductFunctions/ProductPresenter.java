package ProductFunctions;

import InputAndOutput.SystemInOut;

public class ProductPresenter {

    public void nameProductPresent(){
        SystemInOut input = new SystemInOut();
        input.sendOutput("What is the name of the product?");
    }

    public void noNameProduct(){
        SystemInOut input = new SystemInOut();
        input.sendOutput("What is the name of the product?");

    }
}
