package loginFunctionsTest;

import delete_gateways.DeleteUserGateway;
import login.GetUserGateway;
import login.SaveUserGateway;
import org.junit.Test;
import user.User;

import java.io.IOException;

import static org.junit.Assert.assertEquals;

public class SignInGatewayTest {

    GetUserGateway getUserGateway = new GetUserGateway();
    SaveUserGateway saveUserGateway = new SaveUserGateway();
    DeleteUserGateway deleteUserGateway = new DeleteUserGateway();

    @Test
    public void getUserBasicTest() throws IOException, ClassNotFoundException {
        User newUser = new User("albert");
        saveUserGateway.saveUser("albert", newUser);

        User expectedUser = getUserGateway.getUser("albert");
        assertEquals(newUser.getUsername(), expectedUser.getUsername());
        deleteUserGateway.deleteUser("albert");

    }

}
