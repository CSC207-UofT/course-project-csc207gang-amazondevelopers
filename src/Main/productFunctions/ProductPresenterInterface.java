package productFunctions;

/**
 * This is an interface that handles all the prompts/ways that information is presented to the user.
 */

public interface ProductPresenterInterface {
    void getProductNamePresenter();
    void getProductPricePresenter();
    void ProductPriceRangePresenter();
    void getProductCategoryPresenter();
    void getProductQuantityPresenter();
    void getProductSizePresenter();
    void creationSuccessPresenter();
    void specifyTypePriceProductPresenter();
    void specifyTypeProductPresenter();
    void confirmProductCreationPresenter();
}
