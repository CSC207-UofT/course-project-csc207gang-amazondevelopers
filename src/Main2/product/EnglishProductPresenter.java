package product;
import inputOutputFunctions.SystemInOut;

/**
 * This class implements ways that all the prompts/ways that information is presented to the user in the english language.
 */

public class EnglishProductPresenter implements ProductPresenterInterface {

    public String getProductNamePresenter(){
        return "What is the name of the product?";
    }

    public String getProductPricePresenter(){
        return "What is the price of the product?";
    }

    public String ProductPriceRangePresenter(){
        return "Price must be greater than or equal to 0.";
    }

    public String getProductCategoryPresenter(){
        return "What is the category of the product?";
    }

    public String getProductQuantityPresenter(){
        return "What is the quantity of this product? Please enter an integer.";
    }

    public String getProductSizePresenter(){
        return "What is the size of this product? Press enter nothing (no characters) if this product does not have a size";
    }

    public String creationSuccessPresenter(){
        return "Product and Post was created.";
    }

    public String specifyTypePriceProductPresenter() {
        return "Price must be a number.";
    }

    public String specifyTypeProductPresenter() {
        return "Please enter an integer.";
    }

    public String confirmProductCreationPresenter() {
        return "Are you happy with this product? Type * for no, " +
                "or anything else for yes.\n If you say yes, you will be asked to create a post about this product";
    }



}
