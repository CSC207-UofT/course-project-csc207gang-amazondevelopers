package user_test;

import org.junit.Test;
import product.Product;
import user.User;
import user.UserUseCase;

import java.util.List;

import static org.junit.Assert.assertEquals;

public class UserUseCaseTest {

    @Test
    public void addToCartTest(){
        User user = new User("Yasmin");
        Product shoe = new Product("shoes", "1", 5.0, "shoes", "2",1);
        UserUseCase userUseCase = new UserUseCase(user);
        userUseCase.userAddToCart(shoe);
        assertEquals(shoe, user.getShoppingCart().get(0));
    }

    @Test
    public void addToFollowTest(){
        User user = new User("Yasmin");
        String usernameToFollow = "Albert";
        UserUseCase userUseCase = new UserUseCase(user);
        userUseCase.userAddToFollow(usernameToFollow);
        assertEquals(1, user.getListFollowing().size());

    }

    @Test
    public void userShoppingget(){
        User user = new User("Yasmin");
        UserUseCase userUseCase = new UserUseCase(user);
        List<Product> cart = userUseCase.userShoppingCart();
        Product shoe = new Product("shoes", "1", 5.0, "shoes", "2",1);
        cart.add(shoe);
        assertEquals(shoe, cart.get(0));

    }
}
