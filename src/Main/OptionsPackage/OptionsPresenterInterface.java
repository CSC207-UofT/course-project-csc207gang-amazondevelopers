package OptionsPackage;

import InputAndOutput.SystemInOut;
import ProductFunctions.GetProductGateway;
import ProductFunctions.Product;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public interface OptionsPresenterInterface {

    public void presentList(List<String> IDProductOfInterest) throws IOException, ClassNotFoundException;

    public void optionToBuyPresent();

    public void addToCartPresent();


    public void outOfStockPresent();

    public void buyOrBackPresent();

    public void cartIsEmptyPresent();

    public void incorrectIndexPresent();

    public void invalidInput();

    public void userOptionsMain();
}
