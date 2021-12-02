package userFunctionsTest;

import browseFunctions.GetUserDictGateway;
import browseFunctions.SaveUserDictGateway;
import inputOutputFunctions.SystemInOut;
import product.CreateProductGateway;
import settingsFunctions.DeleteProductsGateway;
import settingsFunctions.DeleteUserGateway;
import userFunctions.CartManager;
import userFunctions.SaveProductGateway;
import userFunctions.User;
import loginFunctions.GetUserGateway;
import loginFunctions.SaveUserGateway;
import loginFunctions.SignUpGateway;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.io.IOException;
import java.util.ArrayList;

import static org.junit.Assert.assertEquals;

public class CartManagerTest {

    product.CreateProductGateway createProductGateway = new CreateProductGateway();
    SaveProductGateway saveProductGateway = new SaveProductGateway();
    SaveUserGateway saveUserGateway = new SaveUserGateway();
    GetUserGateway getUserGateway = new GetUserGateway();
    GetUserDictGateway getUserDictGateway = new GetUserDictGateway();
    SaveUserDictGateway saveUserDictGateway = new SaveUserDictGateway();

    CartManager cartManagerProduct = new CartManager(saveProductGateway,getUserDictGateway,saveUserDictGateway);
    CartManager cartManagerUser = new CartManager(saveUserGateway);

    DeleteUserGateway deleteUserGateway = new DeleteUserGateway();
    SignUpGateway signUpGateway = new SignUpGateway();

    User testUser = new User("TestCartManager");
    product.Product testProduct = new product.Product("shoe", "TEST", 5.0, "shoes", "2",2);

    product.GetProductGateway getProductGateway = new product.GetProductGateway();
    product.ProductUseCase productUseCaseCreate = new product.ProductUseCase(createProductGateway);
    DeleteProductsGateway deleteProductsGateway = new DeleteProductsGateway();

    @Before
    public void setUp() throws IOException, ClassNotFoundException {
        // if there is a preexisting user TestCartManager delete it
        deleteUserGateway.deleteUser("TestCartManager");
        // create the new user profile before each test
        signUpGateway.allowSignUp( "TestCartManager", testUser);

        // save a product to the repo to test with
        productUseCaseCreate.saveNewProductToSer(testProduct);

    }

    @After
    public void takeDown() throws IOException, ClassNotFoundException {
        // delete the test user profile after each test, delete all the products that were created during the test
        deleteUserGateway.deleteUser("TestCartManager");
        ArrayList<String> ids = new ArrayList<>();
        ids.add("TEST");
        deleteProductsGateway.deleteProducts(ids);
    }


    @Test
    public void addToCartBasicTest() {
        product.Product testProduct = new product.Product("shoe", "1", 5.0, "shoes", "2",1);

        cartManagerUser.addToCart(testProduct, testUser);
        assertEquals(1, testUser.getShoppingCart().size());
        assertEquals(testProduct, testUser.getShoppingCart().get(0));
    }

    @Test
    public void addToCartZeroQuantityTest() {
        product.Product testProduct = new product.Product("shoe", "1", 5.0, "shoes", "2",0);
        cartManagerUser.addToCart(testProduct, testUser);
        assertEquals(0, testUser.getShoppingCart().size());

        cartManagerProduct.addToCart(testProduct, testUser);
        assertEquals(0, testUser.getShoppingCart().size());
    }

//    @Test
//    public void addToCartUsersOwnProductTest() {
//        Product testProduct = new Product("shoe", "1", 5.0, "shoes", "2",0);
//        cartManagerUser.addToCart(testProduct, testUser);
//        assertEquals(0, testUser.getShoppingCart().size());
//
//        cartManagerProduct.addToCart(testProduct, testUser);
//        assertEquals(0, testUser.getShoppingCart().size());
//
//    }

    @Test
    public void updateProductQuantityBasicTest() throws IOException, ClassNotFoundException {
        cartManagerUser.addToCart(testProduct, testUser);
        assertEquals(1, testUser.getShoppingCart().size());

        cartManagerProduct.updateProductQuantity(testUser);
        product.Product updatedProduct = getProductGateway.getProduct("TEST");
        assertEquals(1, updatedProduct.getQuantity());
    }

    @Test
    public void updateProductQuantityZeroTest() throws IOException, ClassNotFoundException {
        product.Product testProduct = new product.Product("shoe", "TEST", 5.0, "shoes", "2",1);
        productUseCaseCreate.saveNewProductToSer(testProduct);

        cartManagerUser.addToCart(testProduct, testUser);
        assertEquals(1, testUser.getShoppingCart().size());

        cartManagerProduct.updateProductQuantity(testUser);
        product.Product updatedProduct = getProductGateway.getProduct("TEST");
        assertEquals(0, updatedProduct.getQuantity());
    }

    @Test
    public void emptyCartBasicTest() throws IOException, ClassNotFoundException {
        cartManagerUser.addToCart(testProduct, testUser);
        assertEquals(1, testUser.getShoppingCart().size());
        cartManagerUser.emptyCart(testUser);
        assertEquals(0, testUser.getShoppingCart().size());

        User updatedUserInFile = getUserGateway.getUser("CartManagerTest");
        assertEquals(0, updatedUserInFile.getShoppingCart().size());
    }

    @Test
    public void emptyCartEmptyTest() throws IOException, ClassNotFoundException {
        SystemInOut inOut = new SystemInOut();
        assertEquals(0, testUser.getShoppingCart().size());
        cartManagerUser.emptyCart(testUser);
        assertEquals(0, testUser.getShoppingCart().size());

        User updatedUserInFile = getUserGateway.getUser("CartManagerTest");
        assertEquals(0, updatedUserInFile.getShoppingCart().size());
    }




}
