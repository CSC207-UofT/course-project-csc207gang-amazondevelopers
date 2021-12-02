package productFunctions;
import inputOutputFunctions.SystemInOut;
import product.ProductPresenterInterface;

/**
 * This class implements ways that all the prompts/ways that information is presented to the user in the english language.
 */

public class EnglishProductPresenter implements ProductPresenterInterface {

    SystemInOut sendOutput = new SystemInOut();

    public void getProductNamePresenter(){
        sendOutput.sendOutput("What is the name of the product?");
    }

    public void getProductPricePresenter(){
        sendOutput.sendOutput("What is the price of the product?");
    }

    public void ProductPriceRangePresenter(){
        sendOutput.sendOutput("Price must be greater than or equal to 0.");
    }

    public void getProductCategoryPresenter(){
        sendOutput.sendOutput("What is the category of the product?");
    }

    public void getProductQuantityPresenter(){
        sendOutput.sendOutput("What is the quantity of this product? Please enter an integer.");
    }

    public void getProductSizePresenter(){
        sendOutput.sendOutput("What is the size of this product? Press enter nothing (no characters) if this product does not have a size");
    }

    public void creationSuccessPresenter(){
        sendOutput.sendOutput("Product and Post was created.");
    }

    public void specifyTypePriceProductPresenter() {
        sendOutput.sendOutput("Price must be a number.");
    }

    public void specifyTypeProductPresenter() {
        sendOutput.sendOutput("Please enter an integer.");
    }

    public void confirmProductCreationPresenter() {
        sendOutput.sendOutput("Are you happy with this product? Type * for no, " +
                "or anything else for yes.\n If you say yes, you will be asked to create a post about this product");
    }



}
