package product;

/**
 * This is an interface that handles all the prompts/ways that information is presented to the user.
 */

public interface ProductPresenterInterface {
    String getProductNamePresenter();
    String getProductPricePresenter();
    String ProductPriceRangePresenter();
    String getProductCategoryPresenter();
    String getProductQuantityPresenter();
    String getProductSizePresenter();
    String creationSuccessPresenter();
    String specifyTypePriceProductPresenter();
    String specifyTypeProductPresenter();
    String confirmProductCreationPresenter();
}
