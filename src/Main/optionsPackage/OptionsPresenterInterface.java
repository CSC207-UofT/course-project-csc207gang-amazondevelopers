package optionsPackage;

import java.io.IOException;
import java.util.List;

public interface OptionsPresenterInterface {

     void presentList(List<String> IDProductOfInterest) throws IOException, ClassNotFoundException;

     void optionToBuyPresent();

     void addToCartPresent();


     void outOfStockPresent();

     void buyOrBackPresent();

     void cartIsEmptyPresent();

     void incorrectIndexPresent();

     void invalidInput();

     void userOptionsMain();
     void noMatchingProductsPresent();
}
